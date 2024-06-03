/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import Exception.AppException;
import java.sql.SQLException;

/**
 *
 * @author Javier Morcillo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Interprete i = new Interprete();
       
            try {
            System.out.println("¡Bienvenido!");
            boolean menu = true;
            do {
                try {
                    String comando = i.askComando(" ");
                    String[] argumentos = comando.split("-");
                    switch (argumentos[0]) {
                        case "U":
                            System.out.println("Registrando Usuario...");
                            i.checkArgs(argumentos, 5);
                           int edat=Integer.parseInt(argumentos[4]);
                            i.insertarUsuari(argumentos[1], argumentos[2], argumentos[3], edat);
                            System.out.println(argumentos[1] + " ha sido registrado/a.");
                            break;
                        case "T":
                            System.out.println("Registrando Tasca...");
                            i.checkArgs(argumentos, 4);
                            i.insertarTasca(argumentos[1], argumentos[2], argumentos[3]);
                            System.out.println("se ha registrado la tasca");
                            break;
                            
                        case "R":
                            i.checkArgs(argumentos, 2);
                            i.deleteUsuari(argumentos[1]);
                            System.out.println("Usuario eliminado");
                                    break;
                        case "I":
                            i.checkArgs(argumentos, 2);
                            i.listarInfoUsuari(argumentos[1]);
                            
                                    break;
                                    
                        case "V":
                            i.checkArgs(argumentos, 2);
                            i.verUsuariosTasaquesPendents();
                            
                                    break;
                        
                        case "X":
                            menu = false;
                            System.out.println("¡Hasta la próxima!");
                            break;
                        default:
                            throw new AppException(0);
                    }
                } catch (AppException ae) {
                    System.out.println(ae.getMessage());
                }
            } while (menu);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        
        

    }
    
}

            