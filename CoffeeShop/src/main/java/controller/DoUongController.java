package controller;
// improt SQL Librabry
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
// import file
import utils.MySQLConnect;
import entity.DoUong;
import view.*;
import controller.MainController;
// import other 
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author nguyentu
 */
public class DoUongController{
    // public DoUong doUong; 
    public FrDoUong frDoUong;
    public FrSuaDoUong frSuaDoUong;
    public DoUong doUong;
    public FrXoaDoUong frXoaDoUong;
    public MainController mainController;
    
    public DoUongController(FrDoUong frDoUong) {
        this.frDoUong = frDoUong;
    }
    
    public DoUongController(){
        
    }
    
    public DoUong getDoUong() {
        return doUong;
    }

    public void setDoUong(DoUong doUong) {
        this.doUong = doUong;
    }

    
    public void themDoUong(FrDoUong frDoUong){
        this.frDoUong = frDoUong;
        
    }
    
    public void suaDoUong(FrSuaDoUong frSuaDoUong){
        this.frSuaDoUong = frSuaDoUong;
    }
    
    public void xoaDoUong(FrXoaDoUong frXoaDoUong){
        this.frXoaDoUong = frXoaDoUong;
    }
    
    public void create(Object object) {
        DoUong doUong = new DoUong();
        doUong = (DoUong) object;
        if((checkDuplicate(doUong.tenDoUong))){
            JOptionPane.showMessageDialog(frDoUong, "Tên đồ uống bị trùng xin vui lòng nhập lại ", "Invalidation", JOptionPane.ERROR_MESSAGE);  
        }
        else{
            try{
                Connection connection = MySQLConnect.getConnection();
                String query = "INSERT INTO DoUong (tenDoUong, price) VALUES(?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,doUong.tenDoUong);
                statement.setDouble(2,doUong.price);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(frDoUong, "Nhập thành công", "Success", JOptionPane.INFORMATION_MESSAGE);           
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }

    }
  
    public boolean checkDuplicate(String name){
    boolean check = false;
    try{
        Connection connection = MySQLConnect.getConnection();
        String query = "SELECT * FROM DoUong";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String tempName = rs.getString("tenDoUong");
            if(tempName.equals(name)){
                check = true;
                break;
            }
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
       return check;
}

    public void update(Object object, String tenDoUong) {
        DoUong doUong = new DoUong();
        doUong = (DoUong) object;
        // this.doUong = (DoUong) object;
        try{
        Connection connection = MySQLConnect.getConnection();
        String query = "UPDATE DoUong SET tenDoUong = ?, price = ? WHERE tenDoUong = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,doUong.tenDoUong);
        statement.setDouble(2,doUong.price);
        statement.setString(3,tenDoUong);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(frSuaDoUong, "Nhập thành công", "Success", JOptionPane.INFORMATION_MESSAGE);           
        }catch(SQLException e){
            e.printStackTrace();
        }


}
    public void delete(String tenDoUong) {
        Boolean check_delete = false;
        if(find(tenDoUong)){
            try{    
                Connection connection = MySQLConnect.getConnection();
                String query = "DELETE FROM DoUong WHERE tenDoUong = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tenDoUong);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(frXoaDoUong, "Xoá thành công", "Success", JOptionPane.INFORMATION_MESSAGE);           
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
        }
        else{
            JOptionPane.showMessageDialog(frXoaDoUong, "Xoá thất bại, chưa nhập tên hoặc tên không tồn tại", "Error", JOptionPane.ERROR_MESSAGE);              
        }
    }

    public boolean find(String name) {
        Boolean check_find = false;
        try{    
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM DoUong WHERE tenDoUong = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery(); 
            if (rs.next()) {
                String tenDoUong = rs.getString("tenDoUong");
                double price = rs.getDouble("Price");
                doUong = new DoUong(tenDoUong,price);
                check_find = true;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return check_find;
    }
}
