package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan5.database.AppDatabase;
import com.example.pertemuan5.database.DataDiri;

public class UpdateActivity extends AppCompatActivity {
    private String nama , name;
    private String alamat, address;
    char kelamin, gender;
    private int id;
    private EditText etNama, etAlamat, etJenkel;
    private Button btnUpdate,btnDelete ;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        appDatabase = AppDatabase.intDB(getApplicationContext());

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        alamat = intent.getStringExtra("alamat");
        kelamin = intent.getCharExtra("kelamin", ' ');
        id = intent.getIntExtra("id", 0);

        etNama = findViewById(R.id.namaUp);
        etAlamat = findViewById(R.id.alamatUp);
        etJenkel = findViewById(R.id.jenkelUp);
        btnUpdate = findViewById(R.id.btn_updateUp);
        btnDelete = findViewById(R.id.btn_deleteUp);

        //TODO 1 : SETtEXT HASIL INTENT TADI
        etNama.setText(nama);
        etAlamat.setText(alamat);
        etJenkel.setText(""+kelamin);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    void update() {
        //TODO 1: SIMPAN HASIL INPUTAN KEDALAM STRING TADI
        name = etNama.getText().toString();
        address = etAlamat.getText().toString();
        gender = etJenkel.getText().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(name);
        item.setAlamat(address);
        item.setJkelamin(gender);
        item.setId(id);

        //TODO 2: PANGGIL FUNGSI UPDATE DAO()
        appDatabase.dao().updateData(item);

        //TODO 3 : FINISH
        finish();
    }

        public void delete() {
            DataDiri item = new DataDiri();
            item.setId(id);
            appDatabase.dao().deleteData(item);
            finish();
        }

    }

