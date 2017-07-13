package com.example.roberto.cancioneroalfa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Himno> items;

    public CustomAdapter(Activity activity, ArrayList data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Typeface tf_thin= Typeface.createFromAsset(context.getAssets(),"fonts/roboto_thin.ttf");

        viewHolder.itemNombre.setTypeface(tf_thin);
        viewHolder.itemAutor.setTypeface(tf_thin);

        Himno currentItem = (Himno) getItem(position);
        viewHolder.itemNombre.setText(currentItem.getNombre());
        viewHolder.itemAutor.setText(currentItem.getAutor());
        viewHolder.itemImagen.setImageResource(currentItem.getImagen());
        return convertView;
    }



    private class ViewHolder {
        TextView itemNombre;
        TextView itemAutor;
        ImageView itemImagen;

        public ViewHolder(View view) {
            itemNombre = (TextView)view.findViewById(R.id.tvTitulo);
            itemAutor = (TextView) view.findViewById(R.id.tvSubtitulo);
            itemImagen = (ImageView) view.findViewById(R.id.ivImagen);

        }
    }

}
