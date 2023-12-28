/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
// import file
import entity.UserAccount;
import utils.MySQLConnect;
import view.FrNhanVien;
// import sql library
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyentu
 */
public class NhanVienController {
    // properties
    public UserAccount user; 
    public FrNhanVien frNhanVien;
 
    // constructor
    public NhanVienController() {
    }
    
    // setter
    public void setUser(UserAccount user) {
        this.user = user;
    }
    
    // getter
    public UserAccount getUser() {
        return user;
    }
    
    
    

    public void create(Object object){
        user = new UserAccount();
        user = (UserAccount) object;
        if(checkDuplicateID(user.userName)){
            JOptionPane.showMessageDialog(frNhanVien, "ID bị trùng xin vui lòng nhập lại ", "Invalidation", JOptionPane.ERROR_MESSAGE);  
        }
        else{
            try{
                Connection connection = MySQLConnect.getConnection();
                String query = "INSERT INTO UserAccount (idChucVu, userName, passWord, fullName, address, email) VALUES(?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.idChucVu);
                statement.setString(2,user.userName);
                statement.setString(3,user.passWord);
                statement.setString(4,user.fullName);
                statement.setString(5,user.address);
                statement.setString(6,user.email);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(frNhanVien,"Nhập thành công","Success", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    public void update(Object object){
        user = new UserAccount();
        user = (UserAccount) object;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "UPDATE UserAccount \n" +
"            SET userName = ?, passWord = ?, fullName = ?, address = ?, email = ?, idChucVu = ? \n" +
"            WHERE userName = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            // statement.setString()
            statement.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    public boolean checkDuplicateID(String userName){
        Boolean checkDuplicate = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM UserAccount";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String tempName = rs.getString("userName");
                if(userName.equalsIgnoreCase(tempName)){
                    checkDuplicate = true;
                    break;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return checkDuplicate;
    }
    
    // public boolean checkEmpty()
    
    public String getIDChucVu(String tenChucVu){
        String tempIDChucVu = null;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idChucVu FROM ChucVu WHERE tenChucVu = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,tenChucVu);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                tempIDChucVu = rs.getString("idChucVu");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tempIDChucVu;
    }
    
    public String getTenChucVu(String idChucVu){
        String tenChucVu = null;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT tenChucVu FROM ChucVu WHERE idChucVu = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,idChucVu);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                tenChucVu = rs.getString("tenChucVu");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tenChucVu;
    }
    
    public Boolean find(String userName){
        Boolean check = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM UserAccount WHERE userName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,userName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                String idChucVu = rs.getString("idChucVu");
                String tempUserName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String email = rs.getString("email");
                user = new UserAccount(idChucVu,tempUserName, passWord, fullName,address, email);
                check = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    } 
}
