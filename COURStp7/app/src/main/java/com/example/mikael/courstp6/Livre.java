package com.example.mikael.courstp6;

import java.io.Serializable;

/**
 * Created by Mikael on 24/04/2016.
 */
public class Livre implements Serializable{
    private String titre, page, numero;

    public Livre(String titre, String page, String numero){
        this.titre = titre;
        this.page = page;
        this.numero = numero;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return titre;
    }
}
