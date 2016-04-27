package com.example.mikael.courstp6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Intent myIntent;
    private TextView titre;
    private TextView page;
    private TextView numero;
    private Livre livre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myIntent = new Intent();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            Livre p = (Livre) b.getSerializable("AFFICHER");
            titre = (TextView) findViewById(R.id.labelTITLE);
            page = (TextView) findViewById(R.id.labelPAGE);
            numero = (TextView) findViewById(R.id.labelNUM);
            titre.setText(p.getTitre());
            page.setText(p.getPage());
            numero.setText(p.getNumero());
        }
    }

    public void click(View v){
        if(v.getId() == R.id.buttonOK){
            finish();
        }else if(v.getId() == R.id.buttonCALL){
            String toDial="tel:" + numero.getText().toString();
            System.out.println(toDial);
            Uri teleph= Uri.parse(toDial);
            startActivity(new Intent(Intent.ACTION_DIAL, teleph));
        }else{
            Uri address = Uri.parse(page.getText().toString());
            Intent surf = new Intent(Intent.ACTION_VIEW, address);
            startActivity(surf);

        }
    }
}
