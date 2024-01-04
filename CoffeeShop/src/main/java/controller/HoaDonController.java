/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
// Import SQL librabry 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
// import file 
import utils.MySQLConnect;
import entity.CTHD;
import entity.HoaDon;


/**
 *
 * @author nguyentu
 */
public class HoaDonController {

    public HoaDonController() {
    }
    
    public String changeIdAccount(String fullName){
        String idAccount = null; 
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idAccount FROM UserAccount WHERE fullName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,fullName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                idAccount = rs.getString("idAccount");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idAccount;
    }
    
    public String changeIdBan(String soBan){
        String idBan = null;
        try{
            Connection conn = MySQLConnect.getConnection();
            String query = "SELECT idBan FROM Ban WHERE soBan = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, soBan);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                idBan = rs.getString("idBan");
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return idBan;
    }
    
    public String changeIdDoUong(String tenDoUong){
        String idDoUong = null;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idDoUong FROM DoUong WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                idDoUong = rs.getString("idDoUong");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idDoUong;
    }
    
    public boolean checkExist(String tenDoUong){
        Boolean check = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM DoUong WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                String tempTenDoUong = rs.getString("tenDoUong");
                if(tempTenDoUong.equalsIgnoreCase(tenDoUong)){
                    check = true;
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
             
    } 
    public int createHoaDon(HoaDon hoaDon){
        int idHoaDon = -1; 
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "INSERT INTO HoaDon(idAccount, ngayThanhToan, idBan, thanhTien) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, hoaDon.idAccount);
            statement.setString(2, null);
            statement.setString(3, hoaDon.idBan);
            statement.setString(4, null);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                idHoaDon = rs.getInt(1);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idHoaDon;
    }
    
    
    public void createCTHD(int idHoaDon, CTHD cthd){
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idHoaDon, idDoUong FROM CTHD WHERE idHoaDon = ? AND idDoUong = ?";
            PreparedStatement checkStatement = connection.prepareStatement(query);
            checkStatement.setInt(1, idHoaDon);
            checkStatement.setString(2, cthd.idDoUong);
            ResultSet resultSet = checkStatement.executeQuery();
            if (resultSet.next()) {
                String updateQuery = "UPDATE CTHD SET soLuong = ? WHERE idHoaDon = ? AND idDoUong = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, cthd.soLuong);
                updateStatement.setInt(2, idHoaDon);
                updateStatement.setString(3, cthd.idDoUong);
                updateStatement.executeUpdate();
            }else{
                String insertQuery = "INSERT INTO CTHD (idHoaDon, idDoUong, soLuong) VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(insertQuery);
                statement.setInt(1, idHoaDon);
                statement.setString(2, cthd.idDoUong);
                statement.setInt(3, cthd.soLuong);
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }     
    }
    public void deleteDoUongFromCTHD(int idHoaDon, String tenDoUong){
        try{
        Connection connection = MySQLConnect.getConnection();
        String query = "DELETE FROM CTHD WHERE idHoaDon = ? AND idDoUong ="
                + "(SELECT idDoUong FROM DoUong WHERE tenDoUong = ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idHoaDon);
        statement.setString(2, tenDoUong);
        statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean checkDoUongInCTHD(int idHoaDon, String tenDoUong){
        Boolean check = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idDoUong FROM CTHD WHERE idHoaDon = ? and idDoUong = (SELECT idDouong FROM DoUong WHERE tenDoUong = ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idHoaDon);
            statement.setString(2, tenDoUong);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                check = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
}
