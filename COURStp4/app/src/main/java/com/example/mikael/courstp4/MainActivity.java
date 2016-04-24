package com.example.mikael.courstp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private EditText texte;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById( R.id.liste);
        listAdapter = new ArrayAdapter<String>(this, R.layout.listitem);
        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int position,long id)
            {
                texte = (EditText) findViewById(R.id.editText);
                texte.setText(listAdapter.getItem(position));
                pos = position;
            }
        });
    }

    public void click(View v){
        texte = (EditText) findViewById(R.id.editText);
        if(v.getId() == R.id.buttonADD){
            listAdapter.add(texte.getText().toString());
        }else if(v.getId() == R.id.buttonDELETE){
            listAdapter.remove(listAdapter.getItem(pos));
        }else{
            listAdapter.remove(listAdapter.getItem(pos));
            listAdapter.insert(texte.getText().toString(), pos);
        }
    }
}
