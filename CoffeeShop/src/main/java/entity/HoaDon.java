package entity;
// import lombok
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import other library
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDon {
    public Integer idHoaDon;
    public String idAccount;
    public Date ngayThanhToan;
    public String idBan;
    public Double thanhTien;
    public CTHD cthd;
}
