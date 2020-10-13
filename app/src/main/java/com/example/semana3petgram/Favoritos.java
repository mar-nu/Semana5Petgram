package com.example.semana3petgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    private RecyclerView rvMascotas;
    private LinearLayoutManager llm;
    private MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar2 = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        llm = new LinearLayoutManager(this);
        rvMascotas.setLayoutManager(llm);
        adapter = new MascotaAdapter(dataSet(), this);
        rvMascotas.setAdapter(adapter);


    }

    private ArrayList<Mascota> dataSet() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Greta", "2", R.drawable.corgi3));
        mascotas.add(new Mascota("Harry", "3", R.drawable.corgi7));
        mascotas.add(new Mascota("Fox", "6", R.drawable.corgi4));
        mascotas.add(new Mascota("Frances", "7", R.drawable.corgi5));
        mascotas.add(new Mascota("Ezra", "3", R.drawable.corgi6));


        return mascotas;
    }
}