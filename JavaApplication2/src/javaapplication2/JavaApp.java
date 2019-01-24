/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtozc
 */
public class JavaApp {

    /**
     * @param args the command line arguments
     */
    static Connection conn = null;
    private static Statement stmt;
    public static ResultSet results = null;
    public static String DB_url="jdbc:mysql://localhost:3306/kouceng";
    public static String DB_user="root";
    public static String DB_password="";
    public static String driver = "com.mysql.jdbc.Driver";
    
    public ResultSet DB_query(String sql){
        try{
            Class.forName(driver).newInstance();
            conn=DriverManager.getConnection(DB_url,DB_user,DB_password);
            stmt=(Statement) conn.createStatement();
            results=stmt.executeQuery(sql);
            
        }catch(Exception e){
            e.printStackTrace();    
        }
        return results;
    }
    public void DB_update(String sql){
          try{
            Class.forName(driver).newInstance();
            conn=DriverManager.getConnection(DB_url,DB_user,DB_password);
            stmt=(Statement) conn.createStatement();
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            e.printStackTrace();    
        }
       
        
    }
  
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world!!");
        System.out.println("123");
        ResultSet rs=new JavaApp().DB_query("SELECT *FROM classes");
        try {
            while(rs.next()){
                System.out.println(rs.getString(""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JavaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
