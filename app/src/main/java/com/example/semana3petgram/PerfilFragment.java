package com.example.semana3petgram;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    private RecyclerView rvPerfil;
    private GridLayoutManager glm;
    private PerfilAdapter adapter;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);


        rvPerfil = (RecyclerView) v.findViewById(R.id.rv_perfil);




        glm = new GridLayoutManager(getActivity(), 3);
        rvPerfil.setLayoutManager(glm);
        adapter = new PerfilAdapter(dataSet(), (AppCompatActivity) getActivity() );
        rvPerfil.setAdapter(adapter);

        return v;

    }

    private ArrayList<Perfil> dataSet() {
        ArrayList<Perfil> perfiles = new ArrayList<>();
        perfiles.add(new Perfil("90", R.drawable.gato1));
        perfiles.add(new Perfil("76", R.drawable.gato2));
        perfiles.add(new Perfil("88", R.drawable.gato3));
        perfiles.add(new Perfil("64", R.drawable.gato4));
        perfiles.add(new Perfil("77", R.drawable.gato5));
        perfiles.add(new Perfil("100", R.drawable.gato6));

        return perfiles;
    }
}