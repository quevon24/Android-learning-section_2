package com.seccion2.seccion_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    // Constructor
    public MyAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    // getCount le dice al adaptador cuantos elementos tiene la coleccion
    @Override
    public int getCount() {
        return this.names.size();
    }

    // getItem obtener item de la coleccion
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    // getItemId obtener el id del item de la coleccion
    @Override
    public long getItemId(int id) {
        return id;
    }

    // Toma cada item y se dibuja
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // Copiamos la vista
        View v = convertView;

        // Inflamos la vista que nos ha llegado con el layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);

        // Obtener el
        String currentName = names.get(position);
        // opcion 2
        // currentName = (String) getItem(position);

        // Referenciamos el evento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView2);
        textView.setText(currentName);

        // Devolvemos la vista inflada y modificada con nuestros datos
        return v;

    }
}
