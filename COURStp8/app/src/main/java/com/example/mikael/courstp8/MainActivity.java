package com.example.mikael.courstp8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText multiligne;
    private EditText fichier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){

        fichier = (EditText) findViewById(R.id.fichier);
        multiligne = (EditText) findViewById(R.id.multiligne);

        if(v.getId() == R.id.buttonSAVE){

            try
            {
                OutputStreamWriter out= new OutputStreamWriter(openFileOutput(fichier.getText().toString(), 0));
                BufferedWriter buf = new BufferedWriter(out);
                buf.write(multiligne.getText().toString());
                buf.close();
            }
            catch (Throwable t)
            {
                Toast.makeText(this, "Exception : "+ t.toString(), Toast.LENGTH_LONG).show();
            }

        }else{

            try
            {
                InputStream in=openFileInput(fichier.getText().toString());
                if (in!=null)
                {
                    InputStreamReader tmp=new InputStreamReader(in);
                    BufferedReader reader=new BufferedReader(tmp);
                    String str;
                    StringBuffer buf=new StringBuffer();
                    while ((str = reader.readLine()) != null)
                    {
                        buf.append(str + "\n");
                    }
                    multiligne.setText(buf);
                    in.close();
                }
            }
            catch (java.io.FileNotFoundException e)
            {
                // Ok, nous ne l’avons probablement pas encore créé
            }
            catch (Throwable t)
            {
                Toast.makeText(this, "Exception : "+ t.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
