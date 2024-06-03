/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Exception.AppException;
import Modelo.Tasca;
import Modelo.Usuari;
import Persistencia.Dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Javier Morcillo
 */
public class Interprete {
    private BufferedReader br;
    Dao d=new Dao();
    public Interprete() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String askComando(String message) {
        String comando = "";
        boolean error = true;
        do {
            try {
                System.out.print(message);
                comando = br.readLine().toUpperCase().trim();
                if (comando == null) {
                    System.out.println("El comando no debe estar vacío.");
                } else {
                    error = false;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } while (error);
        return comando;
    }
    public void checkArgs(String[] argumentos, int num) throws AppException, SQLException {
        if (argumentos.length != num) {
            throw new AppException(1);
        }
        }
    public void insertarUsuari(String nombreUsuario, String paraulaPas, String nomComplet, int edat) throws SQLException{
      
        Usuari u=new Usuari(nombreUsuario, paraulaPas, nomComplet, edat);
        d.insertarUsuari(u);
    }
        public void insertarTasca(String nomUsuari, String titulo, String contenido) throws AppException, SQLException {
        if (!d.existeUsuari(nomUsuari)) {
            throw new AppException(3);
        }
        d.insertarTasca(nomUsuari, titulo, contenido);
   
    }
        public void deleteUsuari(String nomUsuari) throws SQLException, AppException{
            if (!d.existeUsuari(nomUsuari)) {
            throw new AppException(6);
        
        }
            if(!d.usuarioTieneTareas(nomUsuari)){
                throw new AppException(7);
            }
            d.deleteUsuari(nomUsuari);
            System.out.println("El propietario " + nomUsuari + " ha sido eliminado del registro.");
        }
        public void listarInfoUsuari(String nombreUsuari) throws SQLException, AppException{
            if (!d.existeUsuari(nombreUsuari)){
                     throw new AppException(6);
            }
            System.out.println("TASQUES DE: "+nombreUsuari+"\n ");
            for (Tasca t: d.listarInfoUsuari(nombreUsuari)){
                System.out.println(t.toString()); 
                
            }
            System.out.println("Total: "+d.contarTasquesUser(nombreUsuari));
}
        public void verUsuariosTasaquesPendents() throws SQLException{
            System.out.println("---  USUARIS AMB TASQUES PENDENTS---");
            for(Usuari u:d.verUsuariosTasaquesPendents()){
                System.out.println(u.toString()); 
            }
            System.out.println("--------------------------------------------------");
        }
                
}
