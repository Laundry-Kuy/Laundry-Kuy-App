package com.example.laundrykuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrykuy.Mencuci.MenuMencuci;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.Status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuLayanan extends AppCompatActivity {
    private DatabaseReference database;
    private String Uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layanan);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        database = FirebaseDatabase.getInstance().getReference().child("Orderan");
        Uid = getIntent().getStringExtra("Uid");
        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent intent2 = new Intent(MenuLayanan.this, ProfileActivity.class);
                        intent2.putExtra("Uid", Uid);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        Intent intent = new Intent(MenuLayanan.this, MenuActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:
                        Intent intent1 = new Intent(MenuLayanan.this, StatusActivity.class);
                        intent1.putExtra("Uid", Uid);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


    }

}
