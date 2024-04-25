 package com.example.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtnamapel = findViewById(R.id.namapelanggan);
        final EditText edtnamabar = findViewById(R.id.namabarang);
        final EditText edtjumlahbel = findViewById(R.id.jumlahbeli);
        final EditText edtharga = findViewById(R.id.harga);
        final EditText edtuangbay = findViewById(R.id.uangbayar);
        Button btnproses = findViewById(R.id.tombol);
        Button btnhapus = findViewById(R.id.tombol2);
        Button btnexit = findViewById(R.id.tombol3);
        final TextView txtnamapelanggan = findViewById(R.id.namapelanggan)
        final TextView txtnamabarang = findViewById(R.id.namabarang);
        final TextView txtjumlahbeli = findViewById(R.id.jumlahbeli);
        final TextView txthrg = findViewById(R.id.harga);
        final TextView txtuangbayar = findViewById(R.id.uangbayar);
        final TextView txtbonus = findViewById(R.id.bonus);
        final TextView txttotalbelanja = findViewById(R.id.totalbelanja);
        final TextView txtuangkembali = findViewById(R.id.uangkembali);
        final TextView txtketerangan = findViewById(R.id.keterangan);
        //memberikan action pada tombol proses
        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();
                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);

                //pemberian if dan else untuk aturan pemberian bonus
                if (total >=10000000){
                    txtbonus.setText("Bonus: Harddisk");
                } else if (total >= 7000000 && total <= 9999999){
                    txtbonus.setText("Bonus: Keyboard");
                } else if (total >= 3000000 && total < 6999999){
                    txtbonus.setText("Bonus: Mouse");
                } else {
                    txtbonus.setText("Bonus Tidak Ada Bonus");
                }
                double uangkembalian = (ub - total);
                if (ub < total){
                    txtketerangan.setText("Keterangan uang bayar kurang Rp "+ (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali: Rp B");
                }else{
                    txtketerangan.setText("Keterangan: Tunggu Kembalian");
                            txtuangkembali.setText("Uang Kembali:" + uangkembalian);
                }
            }
        });
        //memberikan action pada tombol reset data
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapelanggan.setText(" ");
                txtnamabarang.setText(" ");
                txttotalbelanja.setText(" Total Belanja: Rp 0");
                txthrg.setText(" ");
                txtuangbayar.setText(" ");
                txtuangkembali.setText("Uang Kembali: Rp 8");
                        txtbonus.setText("Bonus: - ");
                txtjumlahbeli.setText("");
                txtketerangan.setText("Keterangan: - ");
                Toast.makeText(getApplicationContext(),  "Data sudah direset", Toast.LENGTH_LONG).show();
            }
        });
        //memberikan action pada tombol keluar
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

            }
        }