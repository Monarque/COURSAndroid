package com.example.mikael.courstp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
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
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        double nbr1 = Double.parseDouble(nombre1.getText().toString());
        double nbr2 = Double.parseDouble(nombre2.getText().toString());

        if(rg.getCheckedRadioButtonId() == R.id.radioButtonMETRE){
            double calcul = nbr1 / (nbr2*nbr2);
            resultat.setText(String.valueOf(calcul));
        }else{
            double conv = nbr2 * 0.01;
            double calcul = nbr1 / (conv*conv);
            resultat.setText(String.valueOf(calcul));
        }

    }
}
