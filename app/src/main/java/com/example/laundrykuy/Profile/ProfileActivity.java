package com.example.laundrykuy.Profile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrykuy.Login.LoginActivity;
import com.example.laundrykuy.MenuActivity;
import com.example.laundrykuy.R;
import com.example.laundrykuy.Status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseReference database;
    private ProgressDialog loading;
    private TextView iNama, iEmail, iTelpon;
    private ImageView FotoAkun;
    private String Uid;
    private Button btnSetting, btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        iNama = findViewById(R.id.akun_nama);
        iEmail = findViewById(R.id.akun_email);
        iTelpon = findViewById(R.id.akun_telpon);
        btnSetting = findViewById(R.id.akun_setting);
        btnLogout = findViewById(R.id.akun_logout);
        FotoAkun = findViewById(R.id.akun_foto);

        database = FirebaseDatabase.getInstance().getReference();

        loading = ProgressDialog.show(ProfileActivity.this,
                "",
                "Please wait...",
                true,
                false);

        Uid = getIntent().getStringExtra("Uid");

        DatabaseReference offline = database.child("Users");
        offline.keepSynced(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:

                        return true;
                    case R.id.home:
                        Intent intent = new Intent(ProfileActivity.this, MenuActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:
                        Intent intent1 = new Intent(ProfileActivity.this, StatusActivity.class);
                        intent1.putExtra("Uid", Uid);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        database.child("Users").child(Uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loading.dismiss();
                String Gnama = dataSnapshot.child("nama").getValue(String.class);
                String Gemail = dataSnapshot.child("email").getValue(String.class);
                String Gtelpon = dataSnapshot.child("telpon").getValue(String.class);
                final String Gfoto = dataSnapshot.child("foto").getValue(String.class);

                if (Gfoto.isEmpty()){
                    FotoAkun.setImageResource(R.drawable.ic_launcher_foreground);
                    iNama.setText(Gnama);
                    iEmail.setText(Gemail);
                    iTelpon.setText(Gtelpon);
                }else {
                    Picasso.get().load(Gfoto).into(FotoAkun);
                    Picasso.get().load(Gfoto).networkPolicy(NetworkPolicy.OFFLINE).into(FotoAkun, new Callback() {
                        @Override
                        public void onSuccess() {}
                        @Override
                        public void onError(Exception e) {Picasso.get().load(Gfoto).into(FotoAkun); }
                    });
                    iNama.setText(Gnama);
                    iEmail.setText(Gemail);
                    iTelpon.setText(Gtelpon);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProfileSetting.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }

    }

