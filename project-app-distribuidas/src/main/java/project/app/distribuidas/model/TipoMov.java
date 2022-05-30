/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.app.distribuidas.model;

/**
 *
 * @author lizpu
 */
public class TipoMov {
    private int codigoMov;
    private String nombreMov;
    private String signoMov;

    public TipoMov(){
    }
    
    public int getCodigoMov() {
        return codigoMov;
    }

    public void setCodigoMov(int codigoMov) {
        this.codigoMov = codigoMov;
    }

    public String getNombreMov() {
        return nombreMov;
    }

    public void setNombreMov(String nombreMov) {
        this.nombreMov = nombreMov;
    }

    public String getSignoMov() {
        return signoMov;
    }

    public void setSignoMov(String signoMov) {
        this.signoMov = signoMov;
    }
       
}
