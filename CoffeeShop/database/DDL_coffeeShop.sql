drop database if exists coffeeShop;
create database coffeeShop;
use coffeeShop;
-- DDL
create table Ban(
	idBan varchar(5) primary key,
    soBan int,
    tinhTrang boolean
);

create table Hoadon(
	idHoaDon INT AUTO_INCREMENT primary key,
    idAccount INT,
    ngayThanhToan datetime,
    idBan varchar(5),
    thanhTien decimal
);


create table DoUong(
	idDoUong INT AUTO_INCREMENT primary key,
    tenDoUong varchar(20), 
    price decimal
);

create table CTHD(
	idHoaDon INT, 
    idDoUong INT,
    soLuong int,
    primary key(idHoaDon, idDoUong)
);

create table UserAccount(
	idAccount INT AUTO_INCREMENT PRIMARY KEY,
    idChucVu varchar(5),
    userName varchar(20),
    passWord varchar(20),
    fullName varchar(50),
    address varchar(50),
    email varchar(20)
);

create table ChucVu(
	idChucVu varchar(5) primary key,
    tenChucVu varchar(20), 
    luongCoBan decimal
);


-- Add constraint for HoaDon 
alter table HoaDon add constraint FK_IDBAN
foreign key(idBan) references Ban(idBan);

alter table HoaDon add constraint FK_IDACCOUNT
foreign key(idAccount) references UserAccount(idAccount);

-- Add constraint for CTHD
alter table CTHD add constraint FK_IDHOADON
foreign key(idHoaDon) references HoaDon(idHoaDon);

alter table CTHD add constraint FK_IDDOUONG
foreign key(idDoUong) references DoUong(idDoUong);

-- Add constraint for UserAccount
alter table UserAccount add constraint FK_IDCHUCVU
foreign key(idChucVu) references ChucVu(idChucVu);

-- create to test system
INSERT INTO ChucVu (idChucVu, tenChucVu, luongCoBan) VALUES
('CV001', 'Nhân viên', 5000000),
('CV002', 'Quản lý', 10000000),	
('CV003', 'Giám đốc', 20000000);
INSERT INTO UserAccount (idChucVu, userName, passWord, fullName, address, email) VALUES
('CV001', '1', '1', 'Test', 'Bình Dương', 'justtest@gmail.com');
INSERT INTO DoUong(tenDoUong, price) VALUES("Cà phê sữa", "20.000");
INSERT INTO DoUong(tenDoUong, price) VALUES("Cà phê đá", "15.000");
INSERT INTO Ban (idBan, soBan, tinhTrang) VALUES
('B001',001, 1),
('B002',002, 0),
('B003',003, 1);
INSERT INTO Hoadon ( idAccount, ngayThanhToan, idBan, thanhTien) VALUES
('1', '2023-12-10 10:30:00', 'B001', 150000);


SELECT HoaDon.idHoaDon, Ban.soBan, UserAccount.fullName, HoaDon.thanhTien, Ban.tinhTrang, HoaDon.ngayThanhToan
FROM HoaDon
JOIN Ban ON Ban.idBan = HoaDon.idBan
JOIN UserAccount ON UserAccount.idAccount = HoaDon.idAccount


-- Test
-- Truy vấn CTHD để hiển thị 
SELECT DoUong.tenDoUong, CTHD.soLuong, (CTHD.soLuong * DoUong.price) AS totalPrice
FROM CTHD
JOIN DoUong ON DoUong.idDoUong = CTHD.idDoUong
WHERE CTHD.idHoaDon = "24";
-- Xoá đồ uống trong CTHD
DELETE FROM CTHD WHERE idHoaDon = 14 AND idDoUong IN (SELECT idDoUong FROM DoUong WHERE tenDoUong = "Cà phê đá");
-- Hiển thị trên FrHoaDon
SELECT HoaDon.idHoaDon, Ban.soBan, UserAccount.fullName, HoaDon.thanhTien, Ban.tinhTrang, HoaDon.ngayThanhToan +
FROM HoaDon
JOIN Ban ON Ban.idBan = HoaDon.idBan
JOIN UserAccount ON UserAccount.idAccount = HoaDon.idAccount;






-- 
select * from DoUong;
select * from HoaDon
select * from UserAccount




