/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
// import SQL library
import entity.ChucVu;
import utils.MySQLConnect;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import file
import entity.UserAccount;
import entity.ChucVu;
import view.FrLogin;
// other library
import javax.swing.JOptionPane;
/**
 *
 * @author nguyentu
 */
public class LoginController {  
    public UserAccount userAccount;
    public ChucVu chucVu;
    public FrLogin frLogin;
    // constructor
    public LoginController(UserAccount userAccount) {
        this.userAccount = userAccount;

    }
    
    // check empty input
    public void checkEmpty(UserAccount userAccount, FrLogin frLogin){
        boolean checkBothEmpty = false;
        boolean checkOneEmpty = false;
        StringBuilder sb = new StringBuilder();
        if(userAccount.userName.equals("") && userAccount.passWord.equals("")){
            checkBothEmpty = true;
        }
        if(userAccount.userName.equals("") && checkBothEmpty == false){
            checkOneEmpty = true;
         sb.append("Tài khoản không được bỏ trống"); 
         
        }
        if(userAccount.passWord.equals("") && checkBothEmpty == false){
            checkOneEmpty = true;
            sb.append("Mật khẩu không được bỏ trống");
        }
        if (checkBothEmpty == true)
        {
            JOptionPane.showMessageDialog(frLogin,"Tài khoản và mật khẩu không được bỏ trống", "Authentication",JOptionPane.ERROR_MESSAGE);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(frLogin,sb.toString(), "Authentication",JOptionPane.ERROR_MESSAGE);
        }
    }
    // check userName and passWord exists
    public boolean checkCredentials(UserAccount userAccount){
        boolean isValid = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT COUNT(*) FROM UserAccount WHERE userName = ? AND passWord = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, userAccount.getUserName());
                statement.setString(2, userAccount.getPassWord());
                try(ResultSet rs = statement.executeQuery()){
                    if(rs.next()){
                        int count = rs.getInt(1);
                        isValid = (count > 0);
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return isValid;
    }
    // get chucvu from userName
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
    // get fullname from userName
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
