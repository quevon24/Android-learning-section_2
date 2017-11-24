package com.seccion2.seccion_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private MyAdapter myAdapter;
    private int counter = 0;


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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this, R.layout.grid_item, names);
        gridView.setAdapter(myAdapter);

        // Registrar context menu
        registerForContextMenu(gridView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflamos el layout del menu del opciones
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejamos eventos click en el menu de opciones
        switch (item.getItemId()) {
            case R.id.add_item:
                // Añadir nuevo nombre
                this.names.add("Added nº" + (++counter));
                // informar al adaptador de que se ha producido un cambio
                this.myAdapter.notifyDataSetChanged();
                // refrescar adaptador
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // Inflamos layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.names.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);

    }

    // Manejamos eventos click en el context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Trae la informacion de donde se ha hecho click
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.delete_item:
                // Borramos item clickeado
                this.names.remove(info.position);
                // Informar al adaptador de que se ha producido un cambio
                this.myAdapter.notifyDataSetChanged();
                // refrescar adaptador
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
