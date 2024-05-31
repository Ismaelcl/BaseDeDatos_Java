/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Javier Morcillo
 */
public class Usuari {
    
    private String nombreUsuario;
    private String paraulaPas;
    private String nomComplet;
    private int edat;
    
    public Usuari(String nombreUsuario, String paraulaPas, String nomComplet, int edat){
        this.nombreUsuario=nombreUsuario;
        this.paraulaPas=paraulaPas;
        this.nomComplet=nomComplet;
        this.edat=edat;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getParaulaPas() {
        return paraulaPas;
    }

    public void setParaulaPas(String paraulaPas) {
        this.paraulaPas = paraulaPas;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
    
}
