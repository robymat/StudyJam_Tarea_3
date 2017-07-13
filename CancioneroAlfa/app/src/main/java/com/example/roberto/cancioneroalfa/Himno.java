package com.example.roberto.cancioneroalfa;

import java.io.Serializable;

/**
 * Created by Roberto on 2/5/17.
 */

public class Himno implements Serializable {
    private String Nombre;
    private String Autor;
    private int Imagen;
    private  String Canto;

    public Himno() {
    }

    public Himno(String nombre) {
        Nombre = nombre;
    }

    public Himno(String nombre, String autor) {
        Nombre = nombre;
        Autor = autor;
    }

    public Himno(String nombre, String autor, int imagen) {
        Nombre = nombre;
        Autor = autor;
        Imagen = imagen;
    }
    public Himno(String nombre, String autor, int imagen,String canto) {
        Nombre = nombre;
        Autor = autor;
        Imagen = imagen;
        Canto= canto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAutor() {return Autor;}

    public void setAutor(String autor) {Autor = autor;}

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getCanto() {return Canto;}

    public void setCanto(String canto) {Canto = canto;}


}
