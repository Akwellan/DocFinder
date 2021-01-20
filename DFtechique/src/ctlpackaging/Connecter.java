package ctlpackaging;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liamsi
 */
public class Connecter {
    Connection con;
    public Connecter(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.err.println(e);
            //pour afficher l erreur
        }
        try{
            con=DriverManager.getConnection("jdbc:mysql://172.17.50.18:3306/docfinder","root","");
        }catch(SQLException e){System.err.println(e);}
    }
    Connection obtenirconnexion(){return con;}
}
