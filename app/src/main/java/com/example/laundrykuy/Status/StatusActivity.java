package com.example.laundrykuy.Status;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.laundrykuy.Mencuci.Member;
import com.example.laundrykuy.MenuActivity;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Member> list;
    AdapterStatus adapter;
    ImageView icon_list;
    private String Uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_main_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        reference = FirebaseDatabase.getInstance().getReference().child("Orderan");
        Uid = getIntent().getStringExtra("Uid");

        reference.keepSynced(true);

        recyclerView = findViewById(R.id.list_orderan);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<Member>();


        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.status);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(StatusActivity.this, MenuActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        Intent intent1 = new Intent(StatusActivity.this, ProfileActivity.class);
                        intent1.putExtra("Uid", Uid);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:

                        return true;

                }
                return false;
            }
        });
        reference.child(Uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Member b = dataSnapshot1.getValue(Member.class);
                    list.add(b);
                }
                adapter = new AdapterStatus(StatusActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StatusActivity.this, "Oops Something went Wrong", Toast.LENGTH_SHORT).show();
            }

        });
    }


}
