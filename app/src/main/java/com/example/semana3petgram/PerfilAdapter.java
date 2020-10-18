package com.example.semana3petgram;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>{

    private ArrayList<Perfil>perfiles;
    AppCompatActivity activity;

    public PerfilAdapter(ArrayList<Perfil> perfiles, AppCompatActivity activity) {
        this.perfiles = perfiles;
        this.activity=activity;
    }



    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PerfilViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.perfil_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final Perfil perfil = perfiles.get(position);
        holder.pimgFoto.setImageResource(perfil.getFoto());
        holder.ptvLike.setText(perfil.getLikes());




    }

    @Override
    public int getItemCount() {
        return perfiles.size();
    }

    class PerfilViewHolder extends RecyclerView.ViewHolder{

        ImageView pimgFoto;
        TextView ptvLike;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            pimgFoto = (ImageView) itemView.findViewById(R.id.pimgFoto);
            ptvLike = (TextView) itemView.findViewById(R.id.ptvLike);

        }
    }
}

