/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Javier Morcillo
 */
public class Tasca {

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    private String nomUsuari;
    private String titulo;
    private String contenido;
    private int idtask;
    private boolean bit;
    
    public Tasca(String nomUsuari, String titulo, String contenido){
        this.nomUsuari=nomUsuari;
        this.titulo=titulo;
        this.contenido=contenido;
    }
    @Override
        public String toString(){
            String s="Titulo"+getTitulo()+" Contenido" +getContenido()+ " Mascotas ";
            return s;
        }
}
