package com.example.roberto.cancioneroalfa;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvAutor;
    private TextView tvCanto;

    private Typeface tf_thing;
    private Typeface tf_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvAutor = (TextView) findViewById(R.id.tvDetalleAutor);
        tvCanto = (TextView) findViewById(R.id.tvDetalleCanto);

        tf_thing= Typeface.createFromAsset(getAssets(),"fonts/roboto_thin.ttf");
        tf_thing= Typeface.createFromAsset(getAssets(),"fonts/roboto_black.ttf");

        tvNombre.setTypeface(tf_bold);
        tvAutor.setTypeface(tf_thing);

        Himno himno= (Himno) getIntent().getSerializableExtra("cancion");
        tvNombre.setText(himno.getNombre().toString());
        tvAutor.setText(himno.getAutor().toString());
        ivImagen.setImageResource(himno.getImagen());
        tvCanto.setText(himno.getCanto().toString());
    }
}
