package com.example.fadil.databasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.fadil.databasesqlite.R.id.mNama;
import static com.example.fadil.databasesqlite.R.id.mNim;

public class EditData extends AppCompatActivity {
    koneksidatabase datamhs;
    EditText Id,Nama,Nim,Kelas,Jurusan;
    Button edit;
    String nim, nama, kelas,jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        datamhs =new koneksidatabase(this);
        Nama = (EditText) findViewById(mNama);
        Nim = (EditText) findViewById(mNim);
        Kelas = (EditText) findViewById(R.id.mKelas);
        Jurusan = (EditText) findViewById(R.id.mJurusan);
        Id = (EditText) findViewById(R.id.mId);
        edit = (Button) findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedata();
            }
        });
    }
    public void updatedata(){
        String id = Id.getText().toString();
        String nama = Nama.getText().toString();
        String nim = Nim.getText().toString();
        String kelas = Kelas.getText().toString();
        String jurusan = Jurusan.getText().toString();

        Boolean hasil =datamhs.editdata(id, nama, nim , kelas, jurusan);

        if (hasil== true){
            Toast.makeText(this,"Data berhasil di Update",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data gagal di Update",Toast.LENGTH_SHORT).show();
        }
    }
}
