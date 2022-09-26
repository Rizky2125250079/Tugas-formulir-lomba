package com.if3a.formulirrelatif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etNpm, etNama;
    private RadioGroup rgJk;
    private RadioButton rbJk;
    private Spinner spProdi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNpm = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        rgJk = findViewById(R.id.rg_jk);
        spProdi = findViewById(R.id.sp_prodi);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String npm, nama, jk, prodi;
            int selectedID;
            npm = etNpm.getText().toString();
            nama = etNama.getText().toString();
            prodi = spProdi.getSelectedItem().toString();

            //Radio Group dan Radio Button
            selectedID = rgJk.getCheckedRadioButtonId();
            rbJk = rgJk.findViewById(selectedID);
            jk = rbJk.getText().toString();

            if(npm.trim().equals(""))
            {
                etNpm.setError("Npm Tidak Boleh kosong");
                return;
            }
            else if(nama.trim().equals(""))
            {
                etNama.setError("Nama Tidak Boleh kosong");
                return;
            }
            else
            {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("varNPM", npm);
                intent.putExtra("varNama", nama);
                intent.putExtra("varJK", jk);
                intent.putExtra("varProdi", prodi);
                startActivity(intent);
            }

            }
        });
    }
}