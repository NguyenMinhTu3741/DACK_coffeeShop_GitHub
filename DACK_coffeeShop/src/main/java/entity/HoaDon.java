package entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDon {
    public String idHoaDon;
    public String idAccount;
    public Date ngayThanhToan;
    public String idBan;
    public Double thanhTien;

}
