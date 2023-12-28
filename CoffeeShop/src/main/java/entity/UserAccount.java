package entity;
// lombok
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserAccount {
    public String idAccount;
    public String idChucVu;
    public String userName;
    public String passWord;
    public String fullName;
    public String address;
    public String email;

    public UserAccount(String idChucVu, String userName, String passWord, String fullName, String address, String email) {
        this.idChucVu = idChucVu;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }  
}
