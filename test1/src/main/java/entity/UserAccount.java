package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
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
}
