drop database if exists coffeeShop;
create database coffeeShop;
use coffeeShop;
-- DDL
create table Ban(
	idBan varchar(5) primary key,
    tinhTrang int
);

create table Hoadon(
	idHoaDon varchar(5) primary key,
    idAccount INT,
    ngayThanhToan datetime,
    idBan varchar(5),
    thanhTien decimal
);

create table CTHD(
	idHoaDon varchar(5),
    idDoUong varchar(5),
    soLuong int,
    primary key(idHoaDon, idDoUong)
);

create table DoUong(
	idDoUong varchar(5) primary key,
    tenDoUong varchar(20), 
    price decimal
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












