package com.movile.quickbuck.queueapp.model;

/**
 * Created by hp on 31/10/2015.
 */

//Fix me - rename to UserData

public class Usuario {
    private String mNome;
    private String mSenha;
    private String mRestaurante;

    public Usuario(String nome, String senha, String restaurante) {
        mNome = nome;
        mSenha = senha;
        mRestaurante = restaurante;
    }

    public String nome() {
        return mNome;
    }

    public String senha() {
        return mSenha;
    }

    public String restaurante() {
        return mRestaurante;
    }
}
