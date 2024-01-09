/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
// import lombok
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author nguyentu
 */
@NoArgsConstructor
@Setter
@Getter
public class Kho {
    public int idDoUong;
    public int soLuong;

    public Kho(int idDoUong, int soLuong) {
        this.idDoUong = idDoUong;
        this.soLuong = soLuong;
    }
    
}
