package com.example.mikael.courstp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
        final EditText nombre1 = (EditText) findViewById(R.id.nombre1);
        final EditText nombre2 = (EditText) findViewById(R.id.nombre2);
        final TextView resultat = (TextView) findViewById(R.id.resultat);
        double nbr1 = Double.parseDouble(nombre1.getText().toString());
        double nbr2 = Double.parseDouble(nombre2.getText().toString());

        if(v.getId() == R.id.buttonPLUS){
            double res = nbr1 + nbr2;
            String result = String.valueOf(res);
            resultat.setText(result);
        }
        if (v.getId() == R.id.buttonMOINS){
            double res = nbr1 - nbr2;
            String result = String.valueOf(res);
            resultat.setText(result);
        }
        if (v.getId() == R.id.buttonFOIS){
            double res = nbr1 * nbr2;
            String result = String.valueOf(res);
            resultat.setText(result);
        }
        if (v.getId() == R.id.buttonDIVISER){
            double res = nbr1 / nbr2;
            String result = String.valueOf(res);
            resultat.setText(result);
        }
    }
}
