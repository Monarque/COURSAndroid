package com.example.mikael.courstp6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Intent myIntent;
    private EditText titre;
    private EditText page;
    private EditText numero;
    private Livre livre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myIntent = new Intent();

    }

    public void click(View v){
        if(v.getId() == R.id.buttonANNULER){
            finish();
        }else{
            titre = (EditText) findViewById(R.id.titre);
            page = (EditText) findViewById(R.id.page);
            numero = (EditText) findViewById(R.id.numero);
            String titreString = titre.getText().toString();
            String pageString = page.getText().toString();
            String numeroString = numero.getText().toString();
            livre = new Livre(titreString, pageString, numeroString);
            myIntent.putExtra("valider", livre);
            setResult(RESULT_OK, myIntent);
            finish();
        }
    }
}
