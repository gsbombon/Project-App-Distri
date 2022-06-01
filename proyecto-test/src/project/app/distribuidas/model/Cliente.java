
package project.app.distribuidas.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private int id_cuidad;
    private String ruc;
    
    private String nombre;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int id, String ruc, String nombre, String direccion) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId_cuidad() {
        return id_cuidad;
    }

    public void setId_cuidad(int id_cuidad) {
        this.id_cuidad = id_cuidad;
    }
    
    public int getId() {
        return id;
    }

    public String getRuc() {
        return ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
