package com.seccion2.seccion_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        // Forma 1 lista
        List<String> names = new ArrayList<String>();
        names.add("Alejandro");
        names.add("Alejandro");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Fernando");
        names.add("Fernando");
        names.add("Ruben");
        names.add("Ruben");
        names.add("Ruben");
        names.add("Santiago");
        names.add("Santiago");
        names.add("Santiago");

        // Forma 2 lista
        List<String> names2 = new ArrayList<String>(){{
            add("Alejandro");
            add("Fernando");
            add("Ruben");
            add("Santiago");
        }};

        // Adaptador de listview, la forma de mostrar los datos, requiere contexto, layout y array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        // Enlazamos el adaptador con nuestro list View
        listView.setAdapter(adapter);

    }
}
