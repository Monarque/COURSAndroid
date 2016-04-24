package com.example.mikael.courstp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Intent myIntent;
    private EditText texte;

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
            texte = (EditText) findViewById(R.id.text);
            String str = texte.getText().toString();
            myIntent.putExtra("valider", str);
            setResult(RESULT_OK, myIntent);
            finish();
        }
    }
}
