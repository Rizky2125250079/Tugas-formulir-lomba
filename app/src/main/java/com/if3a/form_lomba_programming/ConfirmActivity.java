package com.if3a.form_lomba_programming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ConfirmActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    TextView tvNama, tvJk, tvNoWangsaff, tvAlamat, tvTanggal;
    Button btnTanggal, btnConfirm;
    String nama, jk, noWangsaff, alamat, ChoosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk = findViewById(R.id.tv_jk);
        tvNoWangsaff = findViewById(R.id.tv_no_wangsaf);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnConfirm = findViewById(R.id.btn_konfirm);

        //ambil intent yang dikirim oleh main activity
        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        jk = terima.getStringExtra("varJenisKelamin");
        noWangsaff = terima.getStringExtra("varNoWhatsapp");
        alamat = terima.getStringExtra("varAlamat");

        //set Variabel
        tvNama.setText(nama);
        tvJk.setText(jk);
        tvNoWangsaff.setText(noWangsaff);
        tvAlamat.setText(alamat);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar newCalender = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(day);
                        ChoosenDate = tanggal + "/" + bulan + "/" + tahun;
                        tvTanggal.setText(ChoosenDate);
                    }
                }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH), newCalender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah Data Sudah Benar ? ");

                //Button Positif
                dialog.setPositiveButton("ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this,"Terima Kasih, Pendaftaran Anda Berhasil.",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //Button Negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //tampil dialog
                dialog.show();
            }
        });

    }
}