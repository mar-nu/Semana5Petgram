package com.example.semana3petgram;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTA + "(" +
                ConstantesBaseDatos.TABLA_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_MASCOTA_FOTO + " INTEGER " +
                ")";

        String queryCrearTableLike = "CREATE TABLE "+ ConstantesBaseDatos.TABLA_LIKES + "(" +
                ConstantesBaseDatos.TABLA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_LIKES_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLA_LIKES_LIKES + " INTEGER," +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLA_LIKES_ID_MASCOTA +  ")" +
                "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTA + "(" + ConstantesBaseDatos.TABLA_MASCOTA_ID + ")" +


                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTableLike);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTA;
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));


            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKES_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLA_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }


            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota (Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKES_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLA_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLA_LIKES_ID_MASCOTA + "="+mascota.getId();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
