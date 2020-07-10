package com.example.laundrykuy.Estimasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.laundrykuy.R;
public class EstimasiActivity extends AppCompatActivity {
    private Button btn_berat;
private ImageButton btn_tambah,btn_kurang,kemeja_tambah,kemeja_kurang,clnbahan_tambah,clnbahan_kurang,jeans_tambah,jeans_kurang,clnpendek_tambah,clnpendek_kurang,sarung_tambah,sarung_kurang,
        kaoskaki_tambah,kaoskaki_kurang,sweater_tambah,sweater_kurang,daster_tambah,daster_kurang,rok_tambah,rok_kurang;
private TextView txt_kaos,txt_jeans,txt_kemeja,txt_celanabahan,txt_celanapendek,txt_sarung,txt_kaoskaki,txt_sweater,txt_daster,txt_rok, txt_hasil,txt_harga;
private int nilai = 0;
private double kaos = 0.145;
private double kemeja = 0.165;
private double cln_bahan = 0.3;
private double cln_pendek = 0.18;
private double jeans = 0.5;
private double sarung = 0.165;
private double kaos_kaki = 0.3;
private double sweater = 0.25;
private double daster = 0.22;
private double rok= 0.22;
private int tarif = 6000;
private double hasil;
private double harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimasi);
        btn_berat = findViewById(R.id.btn_estimasi);
        btn_tambah = findViewById(R.id.img_tambah);
        btn_kurang = findViewById(R.id.img_min);
        kemeja_tambah = findViewById(R.id.kemeja_tambah);
        kemeja_kurang = findViewById(R.id.kemeja_min);
        clnbahan_tambah = findViewById(R.id.celana_tambah);
        clnbahan_kurang = findViewById(R.id.celana_min);
        jeans_tambah = findViewById(R.id.jeans_tambah);
        jeans_kurang = findViewById(R.id.jeans_min);
        clnpendek_tambah = findViewById(R.id.celanapendek_tambah);
        clnpendek_kurang = findViewById(R.id.celanapendek_min);
        sarung_tambah = findViewById(R.id.sarung_tambah);
        sarung_kurang = findViewById(R.id.sarung_min);
        kaoskaki_tambah = findViewById(R.id.kaoskaki_tambah);
        kaoskaki_kurang = findViewById(R.id.kaoskaki_min);
        sweater_tambah = findViewById(R.id.sweater_tambah);
        sweater_kurang = findViewById(R.id.sweater_min);
        daster_tambah = findViewById(R.id.daster_tambah);
        daster_kurang = findViewById(R.id.daster_min);
        rok_tambah = findViewById(R.id.rok_tambah);
        rok_kurang = findViewById(R.id.rok_min);

        txt_kaos = findViewById(R.id.txt_kaos);
        txt_celanabahan = findViewById(R.id.txt_celana);
        txt_jeans = findViewById(R.id.txt_jeans);
        txt_kemeja = findViewById(R.id.txt_kemeja);
        txt_celanapendek= findViewById(R.id.txt_celanapendek);
        txt_sarung = findViewById(R.id.txt_sarung);
        txt_kaoskaki = findViewById(R.id.txt_kaoskaki);
        txt_sweater = findViewById(R.id.txt_sweater);
        txt_daster = findViewById(R.id.txt_daster);
        txt_rok = findViewById(R.id.txt_rok);
        txt_hasil = findViewById(R.id.txt_hasil);
        txt_harga = findViewById(R.id.tv_harga);

        btn_berat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jumlah_kaos = Integer.parseInt(txt_kaos.getText().toString());
                int jumlah_celana_bahan = Integer.parseInt(txt_celanabahan.getText().toString());
                int jumlah_jeans = Integer.parseInt(txt_jeans.getText().toString());
                int jumlah_kemeja = Integer.parseInt(txt_kemeja.getText().toString());
                int jumlah_celana_pendek = Integer.parseInt(txt_celanapendek.getText().toString());
                int jumlah_sarung = Integer.parseInt(txt_sarung.getText().toString());
                int jumlah_kaos_kaki = Integer.parseInt(txt_kaoskaki.getText().toString());
                int jumlah_sweater = Integer.parseInt(txt_sweater.getText().toString());
                int jumlah_daster = Integer.parseInt(txt_daster.getText().toString());
                int jumlah_rok = Integer.parseInt(txt_rok.getText().toString());
                hasil = (jumlah_kaos*kaos)+(jumlah_celana_bahan*cln_bahan)+(jumlah_jeans*jeans)+(jumlah_kemeja*kemeja)+
                        (jumlah_celana_pendek*cln_pendek)+(jumlah_sarung*sarung)+(jumlah_kaos_kaki*kaos_kaki)+(jumlah_sweater*sweater)+
                        (jumlah_daster*daster)+(jumlah_rok*rok);
                txt_hasil.setText(String.format("%.2f",hasil));
                harga = tarif*hasil;
                txt_harga.setText(String.format("%.1f",harga));
            }
        });


        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kaos.setText(Integer.toString(i));
                    }
                }
            }
        });

        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kaos.setText(Integer.toString(i));
                    }
                }
            }
        });

        kemeja_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kemeja.setText(Integer.toString(i));
                    }
                }
            }
        });

        kemeja_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kemeja.setText(Integer.toString(i));
                    }
                }
            }
        });

        clnbahan_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_celanabahan.setText(Integer.toString(i));
                    }
                }
            }
        });

        clnbahan_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_celanabahan.setText(Integer.toString(i));
                    }
                }
            }
        });

        jeans_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_jeans.setText(Integer.toString(i));
                    }
                }
            }
        });

        jeans_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_jeans.setText(Integer.toString(i));
                    }
                }
            }
        });

        clnpendek_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_celanapendek.setText(Integer.toString(i));
                    }
                }
            }
        });

        clnpendek_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_celanapendek.setText(Integer.toString(i));
                    }
                }
            }
        });

        sarung_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_sarung.setText(Integer.toString(i));
                    }
                }
            }
        });

        sarung_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_sarung.setText(Integer.toString(i));
                    }
                }
            }
        });

        kaoskaki_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kaoskaki.setText(Integer.toString(i));
                    }
                }
            }
        });

        kaoskaki_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_kaoskaki.setText(Integer.toString(i));
                    }
                }
            }
        });

        sweater_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_sweater.setText(Integer.toString(i));
                    }
                }
            }
        });

        sweater_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_sweater.setText(Integer.toString(i));
                    }
                }
            }
        });

        daster_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_daster.setText(Integer.toString(i));
                    }
                }
            }
        });

        daster_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_daster.setText(Integer.toString(i));
                    }
                }
            }
        });

        rok_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai ++;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_rok.setText(Integer.toString(i));
                    }
                }
            }
        });

        rok_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai --;
                for (int i = 0; i <= nilai; i++) {
                    if (i % 1 == 0) {
                        txt_rok.setText(Integer.toString(i));
                    }
                }
            }
        });


        }


    }

















