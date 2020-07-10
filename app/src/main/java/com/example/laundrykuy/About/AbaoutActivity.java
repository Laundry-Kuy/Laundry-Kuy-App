package com.example.laundrykuy.About;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.laundrykuy.MenuActivity;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.R;
import com.example.laundrykuy.Status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AbaoutActivity extends AppCompatActivity {
    private DatabaseReference database;
    private String Uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaout);
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
                        Intent intent = new Intent(AbaoutActivity.this, ProfileActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        Intent intent2 = new Intent(AbaoutActivity.this, MenuActivity.class);
                        intent2.putExtra("Uid", Uid);
                        startActivity(intent2);
                        overridePendingTransition(0,0);

                        return true;
                    case R.id.status:
                        Intent intent1 = new Intent(AbaoutActivity.this, StatusActivity.class);
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