package com.example.roberto.cancioneroalfa;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lvDatos;
    private Activity activity;
    private CustomAdapter adaptador;
    private ArrayList<Himno> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDatos = (ListView) findViewById(R.id.lvLista);
        activity = this;
        datos= new ArrayList<Himno>();

        llenarArrayList();

        adaptador= new CustomAdapter(activity,datos);

        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(this);
    }
    public void llenarArrayList() {
        Resources resources= getResources();
        String[] arrayNombres= resources.getStringArray(R.array.nombre);
        String[] arrayAutores= resources.getStringArray(R.array.autor);
        TypedArray imgs= resources.obtainTypedArray(R.array.image);
        String[] arrayCantor = resources.getStringArray(R.array.canto);
        for (int i=0;i<arrayAutores.length;i++){
            datos.add(new Himno(arrayNombres[i],arrayAutores[i],imgs.getResourceId(i,-1),arrayCantor[i]));
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Himno himno = datos.get(position );
        Intent i =new Intent(activity,DetalleActivity.class);
        i.putExtra("cancion",himno);
        startActivity(i);
    }
}
