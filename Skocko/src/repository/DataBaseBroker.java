/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import commonskocko.CommonSkocko;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Ljubomir
 */
public class DataBaseBroker {

    private Connection connection;
    
  

    public void sacuvajIgru(ArrayList<CommonSkocko> igra) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/prosoft23";
            String user = "root";
            String password = "@Ghostfreak123!";
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO igra (kombinacija, brojPogodjenihNaMestu,brojPogodjenihNisuNaMestu) VALUES (?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            for(CommonSkocko sk : igra){
                statement.setString(1, sk.getKombinacija());
                statement.setInt(2, sk.getPogodjeniNaMestu());
                statement.setInt(3, sk.getPogodjeniNisuNaMestu());
                statement.executeUpdate();
                
            }
            
             statement.close();
             connection.close();
             
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        

    }

}
