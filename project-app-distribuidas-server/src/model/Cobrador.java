/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author pilli
 */
public class Cobrador implements Serializable {
     int id_cobrador;
    String cedula_cobrador;
    String nombre_cobrador;
    String direccion_cobrador;

    public Cobrador(int id_cobrador, String cedula_cobrador, String nombre_cobrador, String direccion_cobrador) {
        this.id_cobrador = id_cobrador;
        this.cedula_cobrador = cedula_cobrador;
        this.nombre_cobrador = nombre_cobrador;
        this.direccion_cobrador = direccion_cobrador;
    }

    public Cobrador() {
    }
    
    

    public int getId_cobrador() {
        return id_cobrador;
    }

    public void setId_cobrador(int id_cobrador) {
        this.id_cobrador = id_cobrador;
    }

    public String getCedula_cobrador() {
        return cedula_cobrador;
    }

    public void setCedula_cobrador(String cedula_cobrador) {
        this.cedula_cobrador = cedula_cobrador;
    }

    

    public String getNombre_cobrador() {
        return nombre_cobrador;
    }

    public void setNombre_cobrador(String nombre_cobrador) {
        this.nombre_cobrador = nombre_cobrador;
    }

    public String getDireccion_cobrador() {
        return direccion_cobrador;
    }

    public void setDireccion_cobrador(String direccion_cobrador) {
        this.direccion_cobrador = direccion_cobrador;
    }
}
