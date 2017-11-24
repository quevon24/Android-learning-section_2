package com.seccion2.seccion_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        // Forma 1 lista
        names = new ArrayList<String>();
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Ruben");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Ruben");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Ruben");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Ruben");
        names.add("Santiago");

        // Forma 2 lista
//        List<String> names2 = new ArrayList<String>() {{
//            add("Alejandro");
//            add("Fernando");
//            add("Ruben");
//            add("Santiago");
//        }};

        // Adaptador de listview, la forma de mostrar los datos, requiere contexto, layout y array
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        // Enlazamos el adaptador con nuestro list View
        // listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        MyAdapter myadapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myadapter);

    }
}

