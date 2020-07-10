package com.example.laundrykuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.laundrykuy.About.AbaoutActivity;
import com.example.laundrykuy.Estimasi.EstimasiActivity;
import com.example.laundrykuy.Mencuci.MenuMencuci;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.Status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuActivity extends AppCompatActivity {
    private DatabaseReference database;

    Intent pindah;
    private String Uid;
    CardView Mencuci,Layanan,Estimasi,About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        database = FirebaseDatabase.getInstance().getReference();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        Uid = getIntent().getStringExtra("Uid");
        Mencuci = findViewById(R.id.mencuci);
        Layanan = findViewById(R.id.layanan);
        Estimasi = findViewById(R.id.Estimasi);
        About = findViewById(R.id.about);

        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                    overridePendingTransition(0,0);
                    return true;
                    case R.id.home:
                    return true;
                    case R.id.status:
                        Intent intent1 = new Intent(MenuActivity.this, StatusActivity.class);
                        intent1.putExtra("Uid", Uid);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
            });



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

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AbaoutActivity.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
            }
        });





    }
}
