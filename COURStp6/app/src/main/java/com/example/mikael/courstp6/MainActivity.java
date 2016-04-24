package com.example.mikael.courstp6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView;
    private ArrayAdapter<Personne> listAdapter;
    private int pos;
    private static final int AJOUTER = 0;
    private static final int MODIFIER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById(R.id.liste);
        listAdapter = new ArrayAdapter<Personne>(this, R.layout.listitem);
        mainListView.setAdapter(listAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pos = position;
            }
        });
    }

    public void click(View v) {
        if (v.getId() == R.id.buttonADD) {
            Intent request = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(request, AJOUTER);
        } else if (v.getId() == R.id.buttonDELETE) {
            listAdapter.remove(listAdapter.getItem(pos));
        } else {
            Intent request = new Intent(MainActivity.this, Main2Activity.class);
            //request.putExtra("MODIFICATION", listAdapter.getItem(pos));
            startActivityForResult(request, MODIFIER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case MODIFIER:
                if (resultCode == RESULT_OK) {
                    String str = data.getExtras().getString("valider");
                    listAdapter.remove(listAdapter.getItem(pos));
                    //listAdapter.insert(pers, pos);
                }
                break;

            case AJOUTER:
                if (resultCode == RESULT_OK) {
                    String str = data.getExtras().getString("valider");
                    String[] tokens = str.split(";");
                    Personne personne = new Personne(tokens[0],tokens[1],tokens[2]);
                    listAdapter.add(personne);
                }
                break;
        }

    }
}
