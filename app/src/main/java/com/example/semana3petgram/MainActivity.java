package com.example.semana3petgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

        private RecyclerView rvMascotas;
        private LinearLayoutManager llm;
        private MascotaAdapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
            setSupportActionBar(miActionBar);

            rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

            llm = new LinearLayoutManager(this);
            rvMascotas.setLayoutManager(llm);
            adapter = new MascotaAdapter(dataSet(), this);
            rvMascotas.setAdapter(adapter);


        }

        private ArrayList<Mascota> dataSet() {
            ArrayList<Mascota> mascotas = new ArrayList<>();
            mascotas.add(new Mascota("Sherlock", "5", R.drawable.corgi1));
            mascotas.add(new Mascota("Bowie", "3", R.drawable.corgi2));
            mascotas.add(new Mascota("Greta", "2", R.drawable.corgi3));
            mascotas.add(new Mascota("Fox", "6", R.drawable.corgi4));
            mascotas.add(new Mascota("Frances", "7", R.drawable.corgi5));
            mascotas.add(new Mascota("Ezra", "3", R.drawable.corgi6));
            mascotas.add(new Mascota("Harry", "3", R.drawable.corgi7));

            return mascotas;
        }

        public void irFavoritos(View v){
            Intent intent = new Intent (this, Favoritos.class);
            startActivity(intent);
        }
    }