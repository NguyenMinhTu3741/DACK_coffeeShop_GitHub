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
    // Này là dùng để chuyển từ tên người dùng khi người dùng nhập vào và chuyển thành ID ngừoi dùng khi thêm vào dữ liệu
    // fullName(User input) --> idAccount(Input database)
    
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
    // Này dùng dể chuyển từ số bàn khi ngừoi dùng nhập vào và chuyển thành ID bàn để thêm vào dữ liệu
    // soBan(User input) --> idBan(Input database)
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
    // Này dùng để chuyển từ tên đồ uống khi người dùng nhập vào và thành ID đồ uống để thêm vào dữ liệu
    // TenDoUong(User input) --> IdDoUong(Input database)
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
    // Kiểm tra đồ uống có trong csdl không
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
    // Dòng này để tạo Hoá Đơn
    public int createHoaDon(HoaDon hoaDon){
        int idHoaDon = -1; 
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "INSERT INTO HoaDon(idAccount, ngayThanhToan, idBan, thanhTien, tinhTrang) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, hoaDon.idAccount);
            statement.setString(2, null);
            statement.setString(3, hoaDon.idBan);
            statement.setString(4, null);
            statement.setDouble(5, 0);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                idHoaDon = rs.getInt(1);
            }
            // update tinhTrang in Ban is busy
            String updateQuery = "UPDATE Ban SET tinhTrang = 1 WHERE idBan = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1,hoaDon.idBan);
            updateStatement.executeUpdate(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return idHoaDon;
    }
    
    // Này dùng để tạo CTHD 
    public void createCTHD(int idHoaDon, CTHD cthd){
        try{
            // Dùng để truy vấn xem thực sự là có CTHD chưa nếu chưa thì tạo còn có rồi thì việc chỉ thêm đồ uống vào
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
    // Dùng để xoá đồ uống trong CTHD
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
    // Dùng để kiểm tra đồ uống có tồn tại trong CSDL không trước khi thêm đồ uống vào CTHD
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
    // Dùng để cập nhập giá tiền cho cột thanhTien trên bảng HoaDon thông qua số lượng
    // đồ uống trong CTHD
    public void updateThanhTien(){
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "UPDATE HoaDon\n" +
            "SET thanhTien = (\n" +
            "    SELECT SUM(DoUong.price * CTHD.soLuong)\n" +
            "    FROM CTHD\n" +
            "    JOIN DoUong ON DoUong.idDoUong = CTHD.idDoUong\n" +
            "    WHERE CTHD.idHoaDon = HoaDon.idHoaDon\n" +
            ")";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // Cập nhập tình trạng và ngày thanh toán của Hoá Đơn và Bàn khi bấm vào đã thanh toán
    // Tức là hoá đơn đã thanh toán và bàn đang trống
    public void updateTinhTrang(int idHoaDon){
        try{
            Connection connection = MySQLConnect.getConnection();
            String updateHoaDon = "UPDATE HoaDon\n" +
            "SET tinhTrang = 1, ngayThanhToan = CURRENT_TIMESTAMP()\n" +
            "WHERE idHoaDon = ?";
            PreparedStatement statement = connection.prepareStatement(updateHoaDon);
            statement.setInt(1, idHoaDon);
            statement.executeUpdate();
            // update tinhTrang in Ban
            String updateBan = "UPDATE Ban\n" +
            "JOIN HoaDon on HoaDon.idBan = Ban.idBan\n" +
            "SET Ban.tinhTrang = 0 WHERE HoaDon.idHoaDon = ?";
            PreparedStatement statement2 = connection. prepareStatement(updateBan);
            statement2.setInt(1, idHoaDon);
            statement2.executeUpdate();
            // update số lượng đồ uống trong 
            String updateKho = "UPDATE Kho k\n" +
            "JOIN CTHD c ON k.idDoUong = c.idDoUong\n" +
            "JOIN Hoadon h ON c.idHoaDon = h.idHoaDon\n" +
            "SET k.soLuong = k.soLuong - c.soLuong\n" +
            "WHERE h.idHoaDon = ?";
            PreparedStatement statement3 = connection.prepareStatement(updateKho);
            statement3.setInt(1,idHoaDon);
            statement3.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // Kiểm tra id hoá đơn có tồn tại không 
    public boolean checkIDHoaDon(int idHoaDon){
        boolean check = false;
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT idHoaDon FROM HoaDon WHERE idHoaDon = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idHoaDon);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                check = true;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    // Xoá hoá đơn
    public void deleteHoaDon(int idHoaDon){
    try{
        Connection connection = MySQLConnect.getConnection();
        // Đặt lại trạng thái bàn là trống (0) trước khi xoá hoá đơn
        String updateTinhTrangBan = "UPDATE Ban "
                + "JOIN HoaDon ON HoaDon.idBan = Ban.idBan "
                + "SET Ban.tinhTrang = 0 WHERE HoaDon.idHoaDon = ?";
        PreparedStatement statement2 = connection.prepareStatement(updateTinhTrangBan);
        statement2.setInt(1, idHoaDon);
        statement2.executeUpdate();
        // Xoá hoá đơn
        String query = "DELETE FROM HoaDon WHERE idHoaDon = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idHoaDon);
        statement.executeUpdate();

    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    
    // Lấy thông tin idBan và idAccount khi bấm vào button xem hoá đơn để gửi qua cho FrThemDoUong
    public HoaDon findHoaDon(int idHoaDon){
        HoaDon hoaDon = new HoaDon();
        try{
            Connection connection = MySQLConnect.getConnection();
            String query = "select idAccount, idBan\n" +
            "from HoaDon \n" +
            "where idHoaDon = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,idHoaDon);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                hoaDon.idAccount = rs.getString("idAccount");
                hoaDon.idBan = rs.getString("idBan");
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hoaDon;
    }
    
    
    
}
