package com.example.ivan.proyectofinalv2.entity;

import android.content.Intent;

/**
 * Created by Dell on 04/12/2017.
 */

public class Actividad {

    private String nombre;
    //private Float tiempo;
    private Integer horas;
    private Integer minutos;
    private Integer segundos;
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

    public Integer getHoras() {return horas; }

    public Integer getMinutos() {return minutos; }

    public Integer getSegundos() {return segundos; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getTiempo() {
        return (float)((horas*60)+(minutos)+(segundos/60));
    }

    public void setHoras(Integer horas) { this.horas = horas; }

    public void setMinutos(Integer minutos) { this.minutos = minutos;}

    public void setSegundos(Integer segundos) { this.segundos = segundos;}

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
                ", horas='" + horas + '\'' +
                ", minutos='" + minutos + '\'' +
                ", segundos='" + segundos + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", distancia='" + distancia + '\'' +
                ", fecha='" + fecha + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }

    public Actividad(String nombre, Integer horas, Integer minutos, Integer segundos, String descripcion, Float distancia, String fecha, String peso) {
        this.nombre = nombre;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.descripcion = descripcion;
        this.distancia = distancia;
        this.fecha = fecha;
        this.peso = peso;
    }
}
