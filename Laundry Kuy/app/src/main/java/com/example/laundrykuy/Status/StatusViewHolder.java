package com.example.laundrykuy.Status;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.laundrykuy.Mencuci.Member;
import com.example.laundrykuy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatusViewHolder extends AppCompatActivity {
    public TextView TV_NAMA, TV_TANGGAL, TV_STATUS;
    private DatabaseReference database;

    private ArrayList<Member> member;
    private StatusMainActivity statusMainActivity;
    private String Uid, Date;
    private RecyclerView jadwal_list;
    private ProgressDialog loading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_main_activity);

        database = FirebaseDatabase.getInstance().getReference().child("kegiatan_harian");
        Uid = getIntent().getStringExtra("Uid");



        DatabaseReference offline = database;
        offline.keepSynced(true);

        jadwal_list = findViewById(R.id.jadwal_lab_list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        jadwal_list.setLayoutManager(mLayoutManager);
        jadwal_list.setItemAnimator(new DefaultItemAnimator());

        loading = ProgressDialog.show(KegiatanListActivity.this,
                null,
                "Please wait...",
                true,
                false);

        database.child(Uid).child("Hari").child(Date).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                kegiatanReq = new ArrayList<>();

                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    KegiatanReq kegiatan = noteDataSnapshot.getValue(KegiatanReq.class);
                    kegiatan.setDate(Date);
                    kegiatan.setKey(noteDataSnapshot.getKey());
                    kegiatan.setUserId(Uid);
                    kegiatanReq.add(kegiatan);
                }

                hariReqAdapterRecyclerView = new HariReqAdapterRecyclerView(kegiatanReq, KegiatanListActivity.this);
                jadwal_list.setAdapter(hariReqAdapterRecyclerView);
                loading.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println(databaseError.getDetails() + " " + databaseError.getMessage());
                loading.dismiss();
            }
        });

    }
}
