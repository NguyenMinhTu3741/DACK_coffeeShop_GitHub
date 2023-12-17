use coffeeShop;
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