package com.example.mikael.courstp6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    private Intent myIntent;
    private EditText texte;
    private EditText nom;
    private EditText prenom;
    private EditText numero;
    private Personne personne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myIntent = new Intent();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            Personne p = (Personne) b.getSerializable("MODIFICATION");
            nom = (EditText) findViewById(R.id.nom);
            prenom = (EditText) findViewById(R.id.prenom);
            numero = (EditText) findViewById(R.id.numero);
            nom.setText(p.getNom());
            prenom.setText(p.getPrenom());
            numero.setText(p.getNumero());
        }

    }

    public void click(View v){
        if(v.getId() == R.id.buttonANNULER){
            finish();
        }else{
            nom = (EditText) findViewById(R.id.nom);
            prenom = (EditText) findViewById(R.id.prenom);
            numero = (EditText) findViewById(R.id.numero);
            String nomString = nom.getText().toString();
            String prenomString = prenom.getText().toString();
            String numeroString = numero.getText().toString();
            personne = new Personne(prenomString, nomString, numeroString);
            myIntent.putExtra("valider", personne);
            setResult(RESULT_OK, myIntent);
            finish();
        }
    }
}
