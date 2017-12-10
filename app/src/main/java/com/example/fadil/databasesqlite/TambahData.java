package com.example.fadil.databasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.fadil.databasesqlite.R.id.mNama;
import static com.example.fadil.databasesqlite.R.id.mNim;

public class TambahData extends AppCompatActivity {
    koneksidatabase datamhs;
    EditText Nama,Nim,Kelas,Jurusan;
    Button inser;
    String nim, nama, kelas,jurusan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        datamhs =new koneksidatabase(this);
        Nama = (EditText) findViewById(mNama);
        Nim = (EditText) findViewById(mNim);
        Kelas = (EditText) findViewById(R.id.mKelas);
        Jurusan = (EditText) findViewById(R.id.mJurusan);
        inser = (Button) findViewById(R.id.inser);

        inser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                masukandata();
            }
        });
    }
    public void masukandata(){
        nama = Nama.getText().toString();
        nim = Nim.getText().toString();
        kelas = Kelas.getText().toString();
        jurusan = Jurusan.getText().toString();

        Boolean hasil=datamhs.masukandata(nama,nim,kelas,jurusan);

        if (hasil== true){
            Toast.makeText(this,"Data berhasil di input",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data gagal di input",Toast.LENGTH_SHORT).show();
        }
    }
}
