package com.example.laundrykuy.Mencuci;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laundrykuy.MenuActivity;
import com.example.laundrykuy.MenuLayanan;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MenuMencuci extends AppCompatActivity {
    private DatabaseReference database;
    private RadioButton Satuan, Kiloan;
    private ImageButton Btn_kalender;
    private ProgressDialog loading;
    private Button btn_tanggal, btn_order, btn_cancel;
    private TextView TV_jenis;
    private EditText ET_tanggal, ET_alamat,ET_nama;
    private String Uid, sId, Date, m1, m2, paket;
    private String sJenis_laundry, sAlamat, sTanggal_laundry,sAtas_nama, sStatus_pakaian;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_mencuci);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        database = FirebaseDatabase.getInstance().getReference().child("Orderan");
        Uid = getIntent().getStringExtra("Uid");

        member = new Member();
        ET_nama = findViewById(R.id.et_nama);
        ET_tanggal = findViewById(R.id.et_tanggal);
        ET_alamat = findViewById(R.id.et_alamat);

        TV_jenis = findViewById(R.id.tv_jenis);

        Satuan = findViewById(R.id.rb_satuan);
        Kiloan = findViewById(R.id.rb_kiloan);

        btn_order = findViewById(R.id.btn_order);
        Btn_kalender = findViewById(R.id.btn_kalender);

        ET_nama.setText(sAtas_nama);
        ET_tanggal.setText(sTanggal_laundry);
        ET_alamat.setText(sAlamat);
        TV_jenis.setText(sJenis_laundry);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:
                        startActivity(new Intent(getApplicationContext(), MenuLayanan.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        Btn_kalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kalender();
            }
        });

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Satuan.getText().toString();
                Kiloan.getText().toString();
                if (Satuan.isChecked()){
                    m1 ="Laundry Satuan";
                }else{
                    m1 ="Laundry Kiloan";
                }

                TV_jenis.setText(m1);

                member.setAtas_nama(ET_nama.getText().toString().trim());
                member.setJenis_laundry(TV_jenis.getText().toString().trim());
                member.setAlamat(ET_alamat.getText().toString().trim());
                member.setTanggal_laundry(ET_tanggal.getText().toString().trim());
                member.setStatus_pakaian("");
                database.child(Uid)
                        .push()
                        .setValue(member);
                Toast.makeText(MenuMencuci.this, "Orderan Berhasil", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MenuMencuci.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    private void kalender() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                String dateText = DateFormat.format("EEEE, d MMM, yyyy", calendar1).toString();
                ET_tanggal.setText(dateText);
            }
        }, YEAR, MONTH, DATE);
        datePickerDialog.show();
    }

  }

