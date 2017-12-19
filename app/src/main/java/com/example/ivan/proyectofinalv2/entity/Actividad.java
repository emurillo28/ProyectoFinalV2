package com.example.ivan.proyectofinalv2.entity;

/**
 * Created by Dell on 04/12/2017.
 */

public class Actividad {

    private String nombre;
    private Float tiempo;
    private String descripcion;
    private Float distancia;

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    private String fecha;
    private String peso;

    public Actividad(){}



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getTiempo() {
        return tiempo;
    }

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", tiempo='" + tiempo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", distancia='" + distancia + '\'' +
                ", fecha='" + fecha + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }

    public Actividad(String nombre, Float tiempo, String descripcion, Float distancia, String fecha, String peso) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.descripcion = descripcion;
        this.distancia = distancia;
        this.fecha = fecha;
        this.peso = peso;
    }
}
