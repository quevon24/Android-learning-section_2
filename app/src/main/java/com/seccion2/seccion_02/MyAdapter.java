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

        // View Holder Pattern
        // Para mejorar el desempeño de la app
        ViewHolder holder;

        if (convertView == null) {
            // Inflamos la vista que nos ha llegado con el layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            // Referenciamos el evento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Obtener el
        String currentName = names.get(position);
        // opcion 2
        // currentName = (String) getItem(position);

        // Referenciamos el evento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);

        // Devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

    }

    static class ViewHolder {
        private TextView nameTextView;

    }

}
