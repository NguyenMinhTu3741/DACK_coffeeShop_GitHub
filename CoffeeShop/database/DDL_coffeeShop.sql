drop database if exists coffeeShop;
create database coffeeShop;
use coffeeShop;
-- DDL
create table Ban(
	idBan varchar(5) primary key,
    soBan int,
    tinhTrang boolean DEFAULT false
);

create table Hoadon(
	idHoaDon INT AUTO_INCREMENT primary key,
    idAccount INT,
    ngayThanhToan datetime,
    idBan varchar(5),
    thanhTien decimal,
    tinhTrang boolean DEFAULT false
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

create table Kho(
	idKho INT AUTO_INCREMENT primary key,
    idDoUong INT,
    soLuong int
);
-- Add constraint for HoaDon 
alter table HoaDon add constraint FK_IDBAN
foreign key(idBan) references Ban(idBan);

alter table HoaDon add constraint FK_IDACCOUNT
foreign key(idAccount) references UserAccount(idAccount) ON UPDATE CASCADE
        ON DELETE CASCADE;

-- Add constraint for CTHD
alter table CTHD add constraint FK_IDHOADON
foreign key(idHoaDon) references HoaDon(idHoaDon) ON DELETE CASCADE;

alter table CTHD add constraint FK_IDDOUONG
foreign key(idDoUong) references DoUong(idDoUong);

-- Add constraint for UserAccount
alter table UserAccount add constraint FK_IDCHUCVU
foreign key(idChucVu) references ChucVu(idChucVu);

-- Add constraint for Kho 
alter table Kho add constraint FK_IDDOUONG_KHO
foreign key(idDoUong) references DoUong(idDoUong);

-- create to test system
INSERT INTO ChucVu (idChucVu, tenChucVu, luongCoBan) VALUES
('CV001', 'Nhân viên', 5000000),
('CV002', 'Quản lý', 10000000),	
('CV003', 'Giám đốc', 20000000);
INSERT INTO UserAccount (idChucVu, userName, passWord, fullName, address, email) VALUES
('CV002', 'admin123', 'admin123', 'ADMIN', 'Bình Dương', 'admin@gmail.com');
INSERT INTO DoUong(tenDoUong, price) VALUES("Cà phê sữa", "20.000");
INSERT INTO DoUong(tenDoUong, price) VALUES("Cà phê đá", "15.000");
INSERT INTO Ban (idBan, soBan, tinhTrang) VALUES
('B001',001, 0),
('B002',002, 0),
('B003',003, 0);
INSERT INTO Hoadon ( idAccount, ngayThanhToan, idBan, thanhTien) VALUES
('1', '2023-12-10 10:30:00', 'B001', 150000);
