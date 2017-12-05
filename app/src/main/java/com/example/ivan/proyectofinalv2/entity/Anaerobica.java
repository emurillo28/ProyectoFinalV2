package com.example.ivan.proyectofinalv2.entity;

import java.util.Date;

/**
 * Created by Dell on 04/12/2017.
 */

public class Anaerobica {
    private float tiempo;
    private int repeticiones;
    private float peso;
    private String descripcion;
    private String fecha;
    private int idActividad;

    public Anaerobica() {
    }

    public Anaerobica(float tiempo, int repeticiones, float peso, String descripcion, String fecha, int idActividad) {
        this.tiempo = tiempo;
        this.repeticiones = repeticiones;
        this.peso = peso;
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

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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
        return "Anaerobica{" +
                "tiempo=" + tiempo +
                ", repeticiones=" + repeticiones +
                ", peso=" + peso +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", idActividad=" + idActividad +
                '}';
    }
}
