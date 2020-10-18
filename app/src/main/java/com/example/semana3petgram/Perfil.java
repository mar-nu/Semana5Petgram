package com.example.semana3petgram;

public class Perfil {

    private String likes;
    private int foto;

    public Perfil(){

    }

    public Perfil(String likes, int foto) {

        this.likes = likes;
        this.foto = foto;
    }


    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}


