package com.example.semana3petgram;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        /*ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Sherlock", 22, R.drawable.corgi1));
        mascotas.add(new Mascota("Bowie", 3, R.drawable.corgi2));
        mascotas.add(new Mascota("Greta", 9, R.drawable.corgi3));
        mascotas.add(new Mascota("Fox", 23, R.drawable.corgi4));
        mascotas.add(new Mascota("Frances", 9, R.drawable.corgi5));
        mascotas.add(new Mascota("Ezra", 2, R.drawable.corgi6));
        mascotas.add(new Mascota("Harry", 5, R.drawable.corgi7));
        return mascotas;*/
        BaseDatos db = new BaseDatos(context);
        InsertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void InsertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Sherlock");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO, R.drawable.corgi1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Bowie");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Greta");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Fox");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Frances");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Ezra");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi6);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE, "Harry");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO,R.drawable.corgi7);
        db.insertarMascota(contentValues);

    }

    public void DarLike (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);


    }

    public int obtenerLikes(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }
}
