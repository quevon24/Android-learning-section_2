package com.seccion2.seccion_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gridView);

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


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        MyAdapter myadapter = new MyAdapter(this, R.layout.grid_item, names);
        gridView.setAdapter(myadapter);


    }
}
