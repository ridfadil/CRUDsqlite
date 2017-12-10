package com.example.fadil.databasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.fadil.databasesqlite.R.id.mId;

public class HapusDAta extends AppCompatActivity {
    EditText Id;
    Button hapus;
    koneksidatabase datamhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_data);

        Id = (EditText) findViewById(R.id.mId);
        hapus = (Button) findViewById(R.id.hapus);
        datamhs = new koneksidatabase(this);

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusdata();
            }
        });

    }
    public void hapusdata(){
        String id = Id.getText().toString();
        int hasil = datamhs.deleteData(id);
        Toast.makeText(this,"Databerhasil Di hapus",Toast.LENGTH_SHORT).show();
    }
}
