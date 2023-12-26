/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
// import file
import entity.ChucVu;
import entity.UserAccount;
import utils.MySQLConnect;
// import sql library
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author nguyentu
 */
public class MainController {
    public LoginController loginController;
    public ChucVu chucVu;
    public MainController(LoginController loginController) {
        this.loginController = loginController;
    }

    public MainController() {
    }
    
    
    
    // get and show ChucVu in FrMain
    public ChucVu getChucVu(UserAccount userAccount ){
        chucVu = new ChucVu();
    try{
        Connection connection = MySQLConnect.getConnection();
        String query = "SELECT ChucVu.idChucVu,ChucVu.tenChucVu, ChucVu.luongCoBan FROM UserAccount "
                + "JOIN ChucVu ON UserAccount.idChucVu = ChucVu.idChucVu WHERE userName = ?";
        try(PreparedStatement statement = connection.prepareStatement(query) ){
            statement.setString(1,userAccount.getUserName());
            try{
                ResultSet rs = statement.executeQuery();
                if(rs.next()){
                    chucVu.setIdChucVu(rs.getString("idChucVu"));
                    chucVu.setTenChucVu(rs.getString("tenChucVu"));
                    chucVu.setLuongCoBan(rs.getDouble("luongCoBan"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    }catch(SQLException e){
         e.printStackTrace();
    }
     return chucVu;   
}
    // get and show FullName in FrMain
    public String getFullName(UserAccount userAccount){
        String fullName = null;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT fullName FROM UserAccount WHERE userName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userAccount.getUserName());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                fullName = rs.getString("fullName");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return fullName;
    }
}
