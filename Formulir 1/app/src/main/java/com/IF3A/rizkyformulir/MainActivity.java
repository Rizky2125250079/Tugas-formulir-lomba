package com.IF3A.rizkyformulir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDaftar = findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Anda Sudah Terdaftar !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}