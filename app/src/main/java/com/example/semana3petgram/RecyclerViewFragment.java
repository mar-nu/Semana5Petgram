package com.example.semana3petgram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {
    private RecyclerView rvMascotas;
    private LinearLayoutManager llm;
    private MascotaAdapter adapter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        llm = new LinearLayoutManager(getActivity());
        rvMascotas.setLayoutManager(llm);
        adapter = new MascotaAdapter(dataSet(), (AppCompatActivity) getActivity());
        rvMascotas.setAdapter(adapter);
        return v;
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
}