/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
// improt SQL Librabry
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
// import file 
import utils.MySQLConnect;
import entity.Kho;
/**
 *
 * @author nguyentu
 */
public class KhoController {

    public Kho kho;

    public void create(Object object){
        kho = (Kho) object;
        try{
            Connection connection = MySQLConnect.getConnection();
            String checkExist = "SELECT idDoUong, soLuong FROM Kho WHERE idDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(checkExist);
            statement.setInt(1,kho.idDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                int soLuongCoSan = rs.getInt("soLuong");
                int soLuongNhapVao = kho.soLuong;
                int tongSoLuong = soLuongCoSan + soLuongNhapVao;
                System.out.println("TONG SO LUONG: " + tongSoLuong);
                String query = "UPDATE Kho SET soLuong = ? WHERE idDoUong = ?";
                PreparedStatement updateStatement = connection.prepareStatement(query);
                updateStatement.setInt(1, tongSoLuong);
                updateStatement.setInt(2, kho.idDoUong);
                
                updateStatement.executeUpdate();
            }
            else{
                try{
                    String query = "INSERT INTO Kho(idDoUong, soLuong) VALUES (?,?)";
                    PreparedStatement statement1 = connection.prepareStatement(query);
                    statement1.setInt(1,kho.idDoUong);
                    statement1.setInt(2, kho.soLuong);
                    System.out.println("CHECKKKKKKKKKKKKKKKKK");
                    statement1.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }catch(SQLException e){
        e.printStackTrace();
    } 
}
    public void delete(String tenDoUong){
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "DELETE Kho\n" +
            "FROM Kho\n" +
            "JOIN DoUong on DoUong.idDoUong = Kho.idDoUong\n" +
            "WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenDoUong);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean checkExists(String tenDoUong){
        boolean check = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idDoUong FROM doUong WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                check = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    public int changeIDDoUong(String tenDoUong){
        int idDoUong = 0;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idDoUong FROM DoUong WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                idDoUong = rs.getInt("idDoUong");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idDoUong;
    }
    
    
}
