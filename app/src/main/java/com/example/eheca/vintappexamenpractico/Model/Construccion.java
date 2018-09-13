package com.example.eheca.vintappexamenpractico.Model;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;

public class Construccion {

    //Esta clase es el modelo del objeto Construcción

    private String nombre, status, licencia, constructora, ubicacion;
    private int aFinalizacion, area;
    private Double precio, avance;
    private ArrayList<String> descripcion, beneficios, galeria;

    private LocalDate entregaProgramada;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getaFinalizacion() {
        return aFinalizacion;
    }

    public void setaFinalizacion(int aFinalizacion) {
        this.aFinalizacion = aFinalizacion;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getAvance() {
        return avance;
    }

    public void setAvance(Double avance) {
        this.avance = avance;
    }

    public ArrayList<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(ArrayList<String> descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(ArrayList<String> beneficios) {
        this.beneficios = beneficios;
    }

    public LocalDate getEntregaProgramada() {
        return entregaProgramada;
    }

    public void setEntregaProgramada(LocalDate entregaProgramada) {
        this.entregaProgramada = entregaProgramada;
    }

    public ArrayList<String> getGaleria() {
        return galeria;
    }

    public void setGaleria(ArrayList<String> galeria) {
        this.galeria = galeria;
    }
}
