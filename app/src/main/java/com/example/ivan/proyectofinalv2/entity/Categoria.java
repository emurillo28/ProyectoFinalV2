package com.example.ivan.proyectofinalv2.entity;

/**
 * Created by Dell on 19/12/2017.
 */

public class Categoria {
    private String nombre;
    private String categoria;

    public Categoria() {

    }

    public Categoria(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
