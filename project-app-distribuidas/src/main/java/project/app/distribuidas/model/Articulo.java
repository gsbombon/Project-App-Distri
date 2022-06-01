package project.app.distribuidas.model;

import java.io.Serializable;

public class Articulo implements Serializable{
    private int id;
    private String nombre;
    private String precio;
    
    public Articulo(){
        
    }
    public Articulo(int id, String nombre, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
}
