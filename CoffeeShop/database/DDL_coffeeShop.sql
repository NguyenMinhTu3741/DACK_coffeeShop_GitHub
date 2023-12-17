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
    idAccount varchar(5),
    ngayThanhToan datetime,
    idBan varchar(5),
    thanhTien decimal
);

create table CTHD(
	idHoaDon varchar(5),
    idFood varchar(5),
    soLuong int,
    primary key(idHoaDon, idFood)
);

create table Food(
	idFood varchar(5) primary key,
    foodName varchar(20), 
    price decimal
);

create table UserAccount(
	idAccount varchar(5) primary key,
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

alter table CTHD add constraint FK_IDFOOD
foreign key(idFood) references Food(idFood);

-- Add constraint for UserAccount
alter table UserAccount add constraint FK_IDCHUCVU
foreign key(idChucVu) references ChucVu(idChucVu);

-- DML 
-- Add dummy data
-- Add data in Ban
INSERT INTO Ban (idBan, tinhTrang) VALUES
('B001', 1),
('B002', 0),
('B003', 1);

-- Add data in ChucVu
INSERT INTO ChucVu (idChucVu, tenChucVu, luongCoBan) VALUES
('CV001', 'Nhân viên', 5000000),
('CV002', 'Quản lý', 10000000),
('CV003', 'Giám đốc', 20000000);

-- Add data in UserAccount
INSERT INTO UserAccount (idAccount, idChucVu, userName, passWord, fullName, address, email) VALUES
('A001', 'CV001', 'user1', 'password1', 'Nguyễn Văn A', 'Hà Nội', 'user1@example.com'),
('A002', 'CV002', 'user2', 'password2', 'Trần Thị B', 'TP.HCM', 'user2@example.com'),
('A003', 'CV003', 'user3', 'password3', 'Lê Văn C', 'Đà Nẵng', 'user3@example.com');

-- Add data in Hoadon
INSERT INTO Hoadon (idHoaDon, idAccount, ngayThanhToan, idBan, thanhTien) VALUES
('HD001', 'A001', '2023-12-10 10:30:00', 'B001', 150000),
('HD002', 'A002', '2023-12-10 11:00:00', 'B002', 200000),
('HD003', 'A003', '2023-12-10 12:30:00', 'B003', 180000);

-- Add data in Food
INSERT INTO Food (idFood, foodName, price) VALUES
('F001', 'Cà phê đen', 30000),
('F002', 'Trà sữa trân châu', 50000),
('F003', 'Bánh mì sandwich', 40000);

-- Add data in CTHD
INSERT INTO CTHD (idHoaDon, idFood, soLuong) VALUES
('HD001', 'F001', 2),
('HD001', 'F002', 1),
('HD002', 'F003', 3);












