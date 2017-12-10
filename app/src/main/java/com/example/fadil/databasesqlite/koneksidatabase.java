package com.example.fadil.databasesqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by fadil on 05/12/2017.
 */

public class koneksidatabase extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="Mhs.db";
    public static final String TABLE_NAME = "Datamhs";

    public static final String colom1 = "ID";
    public static final String colom2 = "Nama";
    public static final String colom3 = "Nim";
    public static final String colom4 = "Kelas";
    public static final String colom5 = "Jurusan";

    public koneksidatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nama TEXT, Nim INTEGER , Kelas TEXT , Jurusan Text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public Cursor tampildata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean masukandata(String Nama, String Nim,String Kelas, String Jurusan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(colom2,Nama);
        konten.put(colom3,Nim);
        konten.put(colom4,Kelas);
        konten.put(colom5,Jurusan);

        long hasil= db.insert(TABLE_NAME,null,konten);
        db.close();

        if (hasil==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean editdata(String id, String Nama, String Nim,String Kelas, String Jurusan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(colom2,Nama);
        konten.put(colom3,Nim);
        konten.put(colom4,Kelas);
        konten.put(colom5,Jurusan);

        int hasil= db.update(TABLE_NAME,konten,"ID =? ",new String[]{id});
        if (hasil>0){
            return true;
        }
        else {
            return false;
        }
    }
    public Integer deleteData ( String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME,"ID=? ", new String[]{id});
        return i;
    }
}
