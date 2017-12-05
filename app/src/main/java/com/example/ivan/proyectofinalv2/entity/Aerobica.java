package com.example.ivan.proyectofinalv2.entity;

import java.util.Date;

/**
 * Created by Dell on 04/12/2017.
 */

public class Aerobica {

    private float tiempo;
    private float distancia;
    private String descripcion;
    private String fecha;
    private int idActividad;

    public Aerobica() {
    }

    public Aerobica(float tiempo, float distancia, String descripcion, String fecha, int idActividad) {
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idActividad = idActividad;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
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

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public String toString() {
        return "Aerobica{" +
                "tiempo=" + tiempo +
                ", distancia=" + distancia +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", idActividad=" + idActividad +
                '}';
    }
}
