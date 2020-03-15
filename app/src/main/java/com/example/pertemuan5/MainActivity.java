package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan5.database.AppDatabase;
import com.example.pertemuan5.database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etJenkel;
    private Button etInsert, etTampil;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.intDB(getApplicationContext());

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etJenkel = findViewById(R.id.etJenkel);
        etInsert = findViewById(R.id.etInsert);
        etTampil = findViewById(R.id.etTampil);

        etInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
        etTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tampil = new Intent(getApplicationContext(), TampilData.class);
                startActivity(tampil);
            }
        });
    }

        private void insertData () {
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            char kelamin = etJenkel.getText().toString().charAt(0);

            DataDiri item = new DataDiri();
            item.setNama(nama);
            item.setAlamat(alamat);
            item.setJkelamin(kelamin);

            //setelah itu, kirim ke database
            appDatabase.dao().insertData(item);

            etNama.setText("");
            etAlamat.setText("");
            etJenkel.setText("");
        }
    }
