package com.example.laundrykuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.laundrykuy.Estimasi.EstimasiActivity;
import com.example.laundrykuy.Mencuci.MenuMencuci;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends AppCompatActivity {

    Intent pindah;
    private String Uid;
    CardView Mencuci,Layanan,Estimasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        Uid = getIntent().getStringExtra("Uid");
        Mencuci = findViewById(R.id.mencuci);
        Layanan = findViewById(R.id.layanan);
        Estimasi = findViewById(R.id.Estimasi);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                    case R.id.home:
                    return true;
                    case R.id.status:
                        startActivity(new Intent(getApplicationContext(), MenuLayanan.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
            });

        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);

        menu();


    }
    void menu() {

        Mencuci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuMencuci.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
            }
        });

        Layanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuLayanan.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
            }
        });

        Estimasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EstimasiActivity.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
            }
        });







    }
}
