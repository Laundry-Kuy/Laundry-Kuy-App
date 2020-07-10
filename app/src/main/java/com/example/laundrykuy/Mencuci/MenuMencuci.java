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

import com.example.laundrykuy.Estimasi.EstimasiActivity;
import com.example.laundrykuy.MenuActivity;
import com.example.laundrykuy.Profile.ProfileActivity;
import com.example.laundrykuy.Profile.ProfileSetting;
import com.example.laundrykuy.R;
import com.example.laundrykuy.Status.StatusActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MenuMencuci extends AppCompatActivity {
    private DatabaseReference database;
    private RadioButton Satuan, Kiloan, Reguler, Express,Jemput,Antar,Antar_jemput;
    private ImageButton Btn_kalender;
    private ProgressDialog loading;
    private Button btn_tanggal, btn_order, btn_cekberat;
    private TextView TV_jenis,TV_paket,TV_harga,TV_antar;
    private EditText ET_tanggal, ET_alamat,ET_nama,ET_estimasiberat;
    private String Uid, sId, Date, m1, m2, paket;
    private String sJenis_laundry, sAlamat, sTanggal_laundry,sAtas_nama, sStatus_pakaian, sPaket_laundry,sPaket_pengantaran,sEstimasi_berat_pakaian,sEstimasi_tarif_laundry;
    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_mencuci);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        database = FirebaseDatabase.getInstance().getReference().child("Orderan");
        Uid = getIntent().getStringExtra("Uid");
        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);
        member = new Member();
        ET_nama = findViewById(R.id.et_nama);
        ET_tanggal = findViewById(R.id.et_tanggal);
        ET_alamat = findViewById(R.id.et_alamat);
        ET_estimasiberat = findViewById(R.id.et_estimasiberat);


        TV_jenis = findViewById(R.id.tv_jenis);
        TV_paket =findViewById(R.id.tv_paket);
        TV_harga = findViewById(R.id.tv_harga);
        TV_antar =findViewById(R.id.tv_antar);

        Satuan = findViewById(R.id.rb_satuan);
        Kiloan = findViewById(R.id.rb_kiloan);
        Reguler = findViewById(R.id.rb_reguler);
        Express = findViewById(R.id.rb_express);
        Antar = findViewById(R.id.rb_antar);
        Jemput = findViewById(R.id.rb_jemput);
        Antar_jemput = findViewById(R.id.rb_antarjemput);

        btn_order = findViewById(R.id.btn_order);
        Btn_kalender = findViewById(R.id.btn_kalender);
        btn_cekberat = findViewById(R.id.btn_cekberat);


        ET_estimasiberat.setText(sEstimasi_berat_pakaian);
        TV_harga.setText(sEstimasi_tarif_laundry);
        ET_nama.setText(sAtas_nama);
        ET_tanggal.setText(sTanggal_laundry);
        ET_alamat.setText(sAlamat);
        TV_jenis.setText(sJenis_laundry);
        TV_paket.setText(sPaket_laundry);
        TV_antar.setText(sPaket_pengantaran);



        Bundle bundle = getIntent().getExtras();
        ET_estimasiberat.setText(bundle.getString("berat"));
        TV_harga.setText(bundle.getString("harga"));



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent intent2 = new Intent(MenuMencuci.this, ProfileActivity.class);
                        intent2.putExtra("Uid", Uid);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        Intent intent = new Intent(MenuMencuci.this, MenuActivity.class);
                        intent.putExtra("Uid", Uid);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:
                        Intent intent1 = new Intent(MenuMencuci.this, StatusActivity.class);
                        intent1.putExtra("Uid", Uid);
                        startActivity(intent1);
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

        btn_cekberat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMencuci.this, EstimasiActivity.class);
                intent.putExtra("Uid", Uid);

                startActivity(intent);

                finish();
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

                Reguler.getText().toString();
                Express.getText().toString();
                if (Reguler.isChecked()){
                    m2 ="Paket Reguler (3-4 hari)";
                }else{
                    m2 ="Paket Cuci Kilat (1-2 hari)";
                }

                TV_paket.setText(m2);


                Antar.getText().toString();
                Jemput.getText().toString();
                Antar_jemput.getText().toString();

                if (Jemput.isChecked()){
                    paket ="Jemput Pakaian Ketika Akan Melaundry";
                }else if(Antar.isChecked()){
                    paket ="Antar Pakaian Ketika Sudah Selesai Dilaundry";
                }else{
                    paket = "Antar-Jemput Pakaian";
                }

                TV_antar.setText(paket);

                member.setEstimasi_berat_pakaian(ET_estimasiberat.getText().toString().trim());
                member.setEstimasi_tarif_laundry(TV_harga.getText().toString().trim());
                member.setAtas_nama(ET_nama.getText().toString().trim());
                member.setTanggal_laundry(ET_tanggal.getText().toString().trim());
                member.setAlamat(ET_alamat.getText().toString().trim());
                member.setJenis_laundry(TV_jenis.getText().toString().trim());
                member.setPaket_laundry(TV_paket.getText().toString().trim());
                member.setPaket_pengantaran(TV_antar.getText().toString().trim());
                member.setStatus_pakaian("Menunggu Konfirmasi");

                database.child(Uid)
                        .push()
                        .setValue(member);
                Toast.makeText(MenuMencuci.this, "Orderan Berhasil", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MenuMencuci.this, MenuActivity.class);
                intent.putExtra("Uid", Uid);
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

