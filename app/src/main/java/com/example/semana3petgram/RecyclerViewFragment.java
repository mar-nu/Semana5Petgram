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


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {
    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter (this, getContext());

        return v;
    }

  /* public void InicializarDatos() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Sherlock", 22, R.drawable.corgi1));
        mascotas.add(new Mascota("Bowie", 3, R.drawable.corgi2));
        mascotas.add(new Mascota("Greta", 9, R.drawable.corgi3));
        mascotas.add(new Mascota("Fox", 23, R.drawable.corgi4));
        mascotas.add(new Mascota("Frances", 9, R.drawable.corgi5));
        mascotas.add(new Mascota("Ezra", 2, R.drawable.corgi6));
        mascotas.add(new Mascota("Harry", 5, R.drawable.corgi7));

    } */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
       MascotaAdapter adapter = new MascotaAdapter(mascotas, (AppCompatActivity) getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);

    }
}