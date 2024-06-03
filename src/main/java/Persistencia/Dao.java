/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Exception.AppException;
import Modelo.Usuari;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Tasca;

/**
 *
 * @author Javier Morcillo
 */
public class Dao {

    public Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/todo";
        String user = "root";
        String pass = "27102005h";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", user, pass);
        return c;
    }

    public void desconectar(Connection c) throws SQLException {
        c.close();
    }

    public void insertarUsuari(Usuari u) throws SQLException {
        if (existeUsuari(u.getNombreUsuario())) {
            return;
        }
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into user values (?,?,?,?);");
        ps.setString(1, u.getNombreUsuario());
        ps.setString(2, u.getParaulaPas());
        ps.setString(3, u.getNomComplet());
        ps.setInt(4, u.getEdat());
        ps.executeUpdate();
        ps.close();
        desconectar(c);

    }

    public boolean existeUsuari(String nombre) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String consulta = "Select * from user where username='" + nombre + "';";
        ResultSet rs = st.executeQuery(consulta);
        boolean existe = false;
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return (existe);

    }
    
    public boolean usuarioTieneTareas (String nombre) throws SQLException{
         Connection c = conectar();
        Statement st = c.createStatement();
        String consulta = "Select * from task where user='"+ nombre+ "';";
        ResultSet rs = st.executeQuery(consulta);
        boolean existe = false;
        if (rs.next()) {
            existe=true;
        }
        
        
      
        rs.close();
        st.close();
        desconectar(c);
        return (existe);
        
    }

    public void insertarTasca(String nomUsuari, String titulo, String contenido) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into task (user, title, content, done) values (?,?,?,?)");
        ps.setString(1, nomUsuari);
        ps.setString(2, titulo);
        ps.setString(3, contenido);
        ps.setBoolean(4, false);
        ps.executeUpdate();
        ps.close();
        desconectar(c);

    }

    public void deleteUsuari(String nombreUsuari) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("Delete from username where nombre='" + nombreUsuari + "';");
        ps.executeUpdate();
        ps.close();
        desconectar(c);

    }

    public ArrayList<Tasca> listarInfoUsuari(String nombreUsuari) throws SQLException {
        ArrayList<Tasca> tasques = new ArrayList();
        Connection c = conectar();
        Statement s = c.createStatement();
        String operacion = "SELECT * from task where user='"+nombreUsuari+"';";
        ResultSet rs = s.executeQuery(operacion);
        while (rs.next()) {
            int idTask = rs.getInt("idtask");
            String nomUsuari = rs.getString("user");
            String titulo = rs.getString("title");
            String contenido = rs.getString("title");
            boolean done = rs.getBoolean("done");
            Tasca t = new Tasca(nomUsuari, titulo, contenido);
            tasques.add(t);
            
        }
        rs.close();
            desconectar(c);
        return tasques;
    }
    public int contarTasquesUser(String nombreUsuari) throws SQLException{
        Connection c = conectar();
        Statement s = c.createStatement();
        String operacion = "SELECT count(*) as c from task where user='"+nombreUsuari+"';";
        ResultSet rs = s.executeQuery(operacion);
        int contar=(rs.next() ? rs.getInt("c"): null);
        rs.close();
        s.close();
        desconectar(c);
        return contar;
    }
    
    public ArrayList<Usuari> verUsuariosTasaquesPendents() throws SQLException{
        ArrayList<Usuari>usuariosPendents=new ArrayList();
        Connection c = conectar();
        Statement s = c.createStatement();
        String nombreUsuari;
        ResultSet rs = s.executeQuery("SELECT u.username, u.name, u.age FROM user u, task t WHERE u.username=t.user and t.done=0;");
        while (rs.next()){
            String username=rs.getString("username");
            String name=rs.getString("name");
            int edad=rs.getInt("age");
            Usuari u1=new Usuari(username, name, edad);
            usuariosPendents.add(u1);
            
        }
        rs.close();
        s.close();
        desconectar(c);
        return usuariosPendents;
    }
    
   

    
    
}
