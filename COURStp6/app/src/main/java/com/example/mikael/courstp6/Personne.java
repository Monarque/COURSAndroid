package com.example.mikael.courstp6;

/**
 * Created by Mikael on 24/04/2016.
 */
public class Personne {
    private String nom, prenom, numero;

    public Personne(String prenom, String nom, String numero){
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return prenom+";"+nom+";"+numero;
    }
}
