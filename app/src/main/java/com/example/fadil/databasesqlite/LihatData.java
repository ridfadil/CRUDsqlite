package com.example.fadil.databasesqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LihatData extends AppCompatActivity {
    koneksidatabase datamhs;
    TextView hasil;
    Button tampil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        datamhs= new koneksidatabase(this);
        hasil = (TextView) findViewById(R.id.hasil);
        tampil = (Button) findViewById(R.id.tampil);

        tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilkandata();
            }
        });
    }
    public void tampilkandata(){
        Cursor res = datamhs.tampildata();
        StringBuffer ini = new StringBuffer();
        if (res != null && res.getCount()>0){
            while (res.moveToNext()){
                ini.append("Id: "+res.getString(0)+"\n");
                ini.append("Nama: "+res.getString(1)+"\n");
                ini.append("Nim: "+res.getString(2)+"\n");
                ini.append("Kelas: "+res.getString(3)+"\n");
                ini.append("Jurusan: "+res.getString(4)+"\n"+"\n");
            }
            hasil.setText(ini.toString());
            Toast.makeText(this,"Data di Tampilkan",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Tidak ada Data di Tampilkan",Toast.LENGTH_SHORT).show();
        }
    }
}
