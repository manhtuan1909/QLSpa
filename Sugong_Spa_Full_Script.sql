CREATE DATABASE Sugong_Spa;
GO
USE Sugong_Spa;
GO
----------------------------------------------------
CREATE TABLE TaiKhoanDangNhap (
    MaNguoiDung INT PRIMARY KEY,
    TenDangNhap VARCHAR(255) NOT NULL,
    MatKhau VARCHAR(255) NOT NULL
);
----------------------------------------------------
CREATE TABLE NhaCungCap(
	MaNhaCungCap VARCHAR(100) PRIMARY KEY,
	Ten NVARCHAR(255),
	DiaChi NVARCHAR(255),
	SoDienThoai VARCHAR(10)
)
----------------------------------------------------
CREATE TABLE KhachHang (
    MaKhachHang INT IDENTITY(1,1) PRIMARY KEY,
    Ho NVARCHAR(100) NOT NULL,
    Ten NVARCHAR(100) NOT NULL,
    GioiTinh NVARCHAR(3),
    NgaySinh DATE,
    SoDienThoai VARCHAR(10) NOT NULL UNIQUE,
    Email VARCHAR(100) UNIQUE,
    DiaChi NVARCHAR(255),	
    NgayTao DATETIME DEFAULT GETDATE()
);
----------------------------------------------------
CREATE TABLE DichVu (
    MaDichVu INT IDENTITY(1,1) PRIMARY KEY,
    TenDichVu NVARCHAR(255) NOT NULL,
    MoTa NVARCHAR(MAX),
	HinhAnh VARCHAR(100) DEFAULT 'null.png',
    ThoiLuong INT NOT NULL,
    Gia DECIMAL(10, 2) NOT NULL,
    NgayTao DATETIME DEFAULT GETDATE()
);
----------------------------------------------------
CREATE TABLE SanPham (
    MaSanPham INT IDENTITY(1,1) PRIMARY KEY,
    NTenSanPham NVARCHAR(255) NOT NULL,
    MoTa NVARCHAR(MAX),
	HinhAnh VARCHAR(100) DEFAULT 'null.png',
    SoLuongTon INT NOT NULL,
    GiaBan DECIMAL(10, 2) NOT NULL,
	MaNhaCungCap VARCHAR(100),
    NgayTao DATETIME DEFAULT GETDATE(),
	FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap)
);
----------------------------------------------------
CREATE TABLE NhanVien (
    MaNhanVien INT IDENTITY(1,1) PRIMARY KEY,
    Ho NVARCHAR(100) NOT NULL,
    Ten NVARCHAR(100) NOT NULL,
    GioiTinh NVARCHAR(3),
    SoDienThoai VARCHAR(10) NOT NULL UNIQUE,
    Email VARCHAR(100) UNIQUE,
    ChucVu NVARCHAR(255),
	MaNguoiDung INT,
    NgayTao DATETIME DEFAULT GETDATE(),
	FOREIGN KEY (MaNguoiDung) REFERENCES TaiKhoanDangNhap(MaNguoiDung)
);
----------------------------------------------------
CREATE TABLE LichHen (
    MaLichHen INT IDENTITY(1,1) PRIMARY KEY,
    MaKhachHang INT NOT NULL,
    MaDichVu INT NULL, -- Cho phép NULL để lịch hẹn có thể tạo mà không cần dịch vụ ngay lập tức
    MaNhanVien INT NOT NULL,
    NgayHen DATE NOT NULL, -- Ngày hẹn
    GioDen TIME NOT NULL, -- Giờ khách đến
    TrangThai VARCHAR(50) DEFAULT 'Đã đặt lịch', -- Mặc định khi tạo thành công sẽ là "Đã đặt lịch", có thể là "Đã hủy" hoặc "Đã hoàn thành"
    GhiChu TEXT,
    NgayTao DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);
----------------------------------------------------
CREATE TABLE HoaDon (
    MaHoaDon INT IDENTITY(1,1) PRIMARY KEY,
    MaKhachHang INT NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien DECIMAL(10, 2) NOT NULL,
    TrangThai NVARCHAR(150) DEFAULT 'Chưa thanh toán', -- Có thể là "Đã thanh toán" hoặc "Đã hủy"
    GhiChu NVARCHAR(MAX),
    NgayTao DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
----------------------------------------------------
CREATE TABLE ChiTietDichVu (
    MaChiTietDichVu INT IDENTITY(1,1) PRIMARY KEY,
    MaHoaDon INT NOT NULL,
    MaDichVu INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGia DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu) ON DELETE CASCADE,
    ThanhTien AS (SoLuong * DonGia) -- Tính tổng tiền theo số lượng và đơn giá
);
----------------------------------------------------
CREATE TABLE ChiTietSanPham (
    MaChiTietSanPham INT IDENTITY(1,1) PRIMARY KEY,
    MaHoaDon INT NOT NULL,
    MaSanPham INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGia DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham) ON DELETE CASCADE,
    ThanhTien AS (SoLuong * DonGia) -- Tính tổng tiền theo số lượng và đơn giá
);
----------------------------------------------------
--======================================================================================================================================================
-- Kiểm tra độ dài của số điện thoại
ALTER TABLE KhachHang
ADD CONSTRAINT CK_SoDienThoaiHopLe_KH CHECK (LEN(SoDienThoai) = 10);

-- Kiểm tra tính hợp lệ của địa chỉ email
ALTER TABLE KhachHang
ADD CONSTRAINT CK_EmailHopLe_KH CHECK (Email LIKE '%_@__%.__%');

-- Đảm bảo ngày sinh không lớn hơn ngày hiện tại
ALTER TABLE KhachHang
ADD CONSTRAINT CK_NgaySinhHopLe_KH CHECK (NgaySinh <= GETDATE());

-- Ràng buộc kiểm tra số lượng dịch vụ không âm và lớn hơn 0 trong bảng ChiTietDichVu
ALTER TABLE ChiTietDichVu
ADD CONSTRAINT CK_ChiTietDichVu_SoLuong CHECK (SoLuong > 0);

-- Ràng buộc kiểm tra số lượng sản phẩm không âm và lớn hơn 0 trong bảng ChiTietSanPham
ALTER TABLE ChiTietSanPham
ADD CONSTRAINT CK_ChiTietSanPham_SoLuong CHECK (SoLuong > 0);

-- Đảm bảo số lượng tồn kho không âm
ALTER TABLE SanPham
ADD CONSTRAINT CK_SanPham_SoLuongTon CHECK (SoLuongTon >= 0);

-- Đảm bảo giá bán của sản phẩm là số dương
ALTER TABLE SanPham
ADD CONSTRAINT CK_SanPham_GiaBan CHECK (GiaBan > 0);

-- Ràng buộc để đảm bảo số điện thoại của nhân viên là duy nhất và có 10 ký tự
ALTER TABLE NhanVien
ADD CONSTRAINT CK_SoDienThoaiHopLe_NV CHECK (LEN(SoDienThoai) = 10);

-- Ràng buộc để đảm bảo email của nhân viên là duy nhất và phải có định dạng hợp lệ
ALTER TABLE NhanVien
ADD CONSTRAINT CK_EmailHopLe_NV CHECK (Email LIKE '%_@__%.__%');
--======================================================================================================================================================
-- Trigger tự động xóa số lượng 0
CREATE TRIGGER trg_DeleteChiTietDichVu
ON ChiTietDichVu
AFTER INSERT, UPDATE
AS
BEGIN
    DELETE FROM ChiTietDichVu
    WHERE SoLuong = 0;
END;
GO
-- Trigger tự động xóa số lượng 0
CREATE TRIGGER trg_DeleteChiTietSanPham
ON ChiTietSanPham
AFTER INSERT, UPDATE
AS
BEGIN
    DELETE FROM ChiTietSanPham
    WHERE SoLuong = 0;
END;
-- Trigger để kiểm tra số lượng tồn kho trước khi tạo chi tiết hóa đơn cho dịch vụ
CREATE TRIGGER KiemTraSoLuongTon_DichVu
ON ChiTietDichVu
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @MaDichVu INT, @SoLuong INT;

    SELECT @MaDichVu = i.MaDichVu, @SoLuong = i.SoLuong
    FROM INSERTED i
    WHERE i.MaDichVu IS NOT NULL;

    IF @MaDichVu IS NOT NULL
    BEGIN
        DECLARE @Stock INT;
        SELECT @Stock = d.ThoiLuong
        FROM DichVu d
        WHERE d.MaDichVu = @MaDichVu;

        IF @Stock < @SoLuong
        BEGIN
            ROLLBACK TRANSACTION;
            RAISERROR (N'Dịch vụ không đủ thời lượng.', 16, 1);
        END
    END
END;
GO
-- Trigger để kiểm tra số lượng tồn kho trước khi tạo chi tiết hóa đơn cho sản phẩm
CREATE TRIGGER KiemTraSoLuongTon_SanPham
ON ChiTietSanPham
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @MaSanPham INT, @SoLuong INT;

    SELECT @MaSanPham = i.MaSanPham, @SoLuong = i.SoLuong
    FROM INSERTED i
    WHERE i.MaSanPham IS NOT NULL;

    IF @MaSanPham IS NOT NULL
    BEGIN
        DECLARE @Stock INT;
        SELECT @Stock = s.SoLuongTon
        FROM SanPham s
        WHERE s.MaSanPham = @MaSanPham;

        IF @Stock < @SoLuong
        BEGIN
            ROLLBACK TRANSACTION;
            RAISERROR (N'Sản phẩm không đủ số lượng tồn kho.', 16, 1);
        END
        ELSE
        BEGIN
            UPDATE SanPham
            SET SoLuongTon = SoLuongTon - @SoLuong
            WHERE MaSanPham = @MaSanPham;
        END
    END
END;
GO
-- Trigger để tự động cập nhật số lượng tồn kho sau khi thay đổi (CRUD) chi tiết hóa đơn của bảng SanPham:
CREATE TRIGGER CapNhatSoLuongTon_SanPham
ON ChiTietSanPham
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    IF (SELECT COUNT(*) FROM inserted) > 0
    BEGIN
        UPDATE SanPham
        SET SoLuongTon = SanPham.SoLuongTon +
            (SELECT ISNULL(SUM(inserted.SoLuong), 0) FROM inserted WHERE inserted.MaSanPham = SanPham.MaSanPham) -
            (SELECT ISNULL(SUM(deleted.SoLuong), 0) FROM deleted WHERE deleted.MaSanPham = SanPham.MaSanPham)
        FROM SanPham
        WHERE EXISTS (SELECT 1 FROM inserted WHERE inserted.MaSanPham = SanPham.MaSanPham)
            OR EXISTS (SELECT 1 FROM deleted WHERE deleted.MaSanPham = SanPham.MaSanPham);
    END

    -- Xử lý sau khi xóa
    IF (SELECT COUNT(*) FROM deleted) > 0
    BEGIN
        UPDATE SanPham
        SET SoLuongTon = SanPham.SoLuongTon - 
            (SELECT ISNULL(SUM(deleted.SoLuong), 0) FROM deleted WHERE deleted.MaSanPham = SanPham.MaSanPham)
        FROM SanPham
        WHERE EXISTS (SELECT 1 FROM deleted WHERE deleted.MaSanPham = SanPham.MaSanPham);
    END
END;
GO
--Trigger để kiểm tra tính hợp lệ của thời gian hẹn trước khi tạo lịch hẹn:
CREATE TRIGGER KiemTraLichHopLe
ON LichHen
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @NgayHen DATE, @GioDen TIME;

    SELECT @NgayHen = NgayHen, @GioDen = GioDen FROM INSERTED;

    IF @NgayHen < CAST(GETDATE() AS DATE) OR (@NgayHen = CAST(GETDATE() AS DATE) AND @GioDen < CAST(GETDATE() AS TIME))
    BEGIN
        RAISERROR (N'Không thể tạo lịch hẹn với ngày hoặc giờ hẹn trước ngày hoặc giờ hiện tại.', 16, 1);
        ROLLBACK TRANSACTION; -- Đảm bảo rằng giao dịch sẽ bị rollback nếu có lỗi
    END
    ELSE
    BEGIN
        -- Nếu điều kiện không gặp lỗi, chèn dữ liệu vào bảng LichHen
        INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu)
        SELECT MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu FROM INSERTED;
    END
END;
GO
--Trigger để tự động cập nhật tổng tiền của bảng HoaDon sau khi thêm hoặc cập nhật ChiTietDichVu:
CREATE TRIGGER CapNhatTongTien_ChiTietDichVu
ON ChiTietDichVu
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    DECLARE @MaHoaDon INT;

    IF (SELECT COUNT(*) FROM INSERTED) > 0
    BEGIN
        -- Lấy mã hóa đơn từ bảng ChiTietDichVu
        SELECT @MaHoaDon = MaHoaDon FROM INSERTED;

        -- Cập nhật tổng tiền của hóa đơn dựa trên tổng thành tiền của tất cả các chi tiết dịch vụ của hóa đơn
        UPDATE HoaDon
        SET TongTien = ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietDichVu WHERE MaHoaDon = @MaHoaDon), 0)
                     + ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietSanPham WHERE MaHoaDon = @MaHoaDon), 0)
        WHERE MaHoaDon = @MaHoaDon;
    END
    ELSE IF (SELECT COUNT(*) FROM DELETED) > 0 -- Xử lý sau khi xóa
    BEGIN
        SELECT @MaHoaDon = MaHoaDon FROM DELETED;

        UPDATE HoaDon
        SET TongTien = ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietDichVu WHERE MaHoaDon = @MaHoaDon), 0)
                     + ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietSanPham WHERE MaHoaDon = @MaHoaDon), 0)
        WHERE MaHoaDon = @MaHoaDon;
    END
END;
GO
--Trigger để tự động cập nhật tổng tiền của bảng HoaDon sau khi thêm hoặc cập nhật ChiTietSanPham:
CREATE TRIGGER CapNhatTongTien_ChiTietSanPham
ON ChiTietSanPham
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    DECLARE @MaHoaDon INT;

    IF (SELECT COUNT(*) FROM INSERTED) > 0
    BEGIN
        -- Lấy mã hóa đơn từ bảng ChiTietSanPham
        SELECT @MaHoaDon = MaHoaDon FROM INSERTED;

        -- Cập nhật tổng tiền của hóa đơn dựa trên tổng thành tiền của tất cả các chi tiết sản phẩm của hóa đơn
        UPDATE HoaDon
        SET TongTien = ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietDichVu WHERE MaHoaDon = @MaHoaDon), 0)
                     + ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietSanPham WHERE MaHoaDon = @MaHoaDon), 0)
        WHERE MaHoaDon = @MaHoaDon;
    END
    ELSE IF (SELECT COUNT(*) FROM DELETED) > 0 -- Xử lý sau khi xóa
    BEGIN
        SELECT @MaHoaDon = MaHoaDon FROM DELETED;

        UPDATE HoaDon
        SET TongTien = ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietDichVu WHERE MaHoaDon = @MaHoaDon), 0)
                     + ISNULL((SELECT SUM(ISNULL(ThanhTien, 0)) FROM ChiTietSanPham WHERE MaHoaDon = @MaHoaDon), 0)
        WHERE MaHoaDon = @MaHoaDon;
    END
END;
GO
--Trigger tự động tạo hóa đơn khi thêm mới lịch hẹn
CREATE TRIGGER trg_AfterInsert_LichHen
ON LichHen
AFTER INSERT
AS
BEGIN
    DECLARE @MaKhachHang INT, @NgayLap DATE, @TrangThai NVARCHAR(150), @GhiChu NVARCHAR(MAX);

    SELECT 
        @MaKhachHang = inserted.MaKhachHang,
        @NgayLap = inserted.NgayHen, -- Sử dụng ngày hẹn làm ngày lập hóa đơn
        @TrangThai = N'Chưa thanh toán',
        @GhiChu = N'Tự động tạo hóa đơn khi đặt lịch hẹn.'
    FROM inserted;

    INSERT INTO HoaDon (MaKhachHang, NgayLap, TongTien, TrangThai, GhiChu)
    VALUES (@MaKhachHang, @NgayLap, 0, @TrangThai, @GhiChu);
END;
--======================================================================================================================================================
INSERT INTO NhaCungCap (MaNhaCungCap, Ten, DiaChi, SoDienThoai)
VALUES
('NCC001', N'L’Oréal', N'30 Rue d’Alsace, Paris, France', '0123456789'),
('NCC002', N'Neutrogena', N'5760 W 96th St, Los Angeles, USA', '0987654321'),
('NCC003', N'The Ordinary', N'20 Queen St W, Toronto, Canada', '0112233445'),
('NCC004', N'Cetaphil', N'200 Connell Dr, Berkeley Heights, USA', '0223344556'),
('NCC005', N'La Roche-Posay', N'50 Rue de Lisbonne, Paris, France', '0334455667'),
('NCC006', N'Avene', N'88 Avenue des Champs-Élysées, Paris, France', '0445566778'),
('NCC007', N'CeraVe', N'8200 Tower Avenue, Cleveland, USA', '0556677889');
--======================================================================================================================================================
INSERT INTO TaiKhoanDangNhap (MaNguoiDung, TenDangNhap, MatKhau)
VALUES (1, 'user1', 'password1'),
       (2, 'user2', 'password2'),
       (3, 'user3', 'password3');
--======================================================================================================================================================
INSERT INTO KhachHang (Ho, Ten, GioiTinh, NgaySinh, SoDienThoai, Email, DiaChi)
VALUES 
(N'Trần', N'Văn Hoàng', N'Nam', '1992-05-14', '0909987625', 'nguyenvanhoang@gmail.com', N'123 Lê Trọng Tấn,Tân Phú,TPHCM'),
(N'Trần', N'Thị Bùng', N'Nữ', '1995-11-23', '0913654211', 'tranthibung@gmail.com', N'121 Nguyễn Hữu Tiến,Tân Phú,TPHCM'),
(N'Lê', N'Hùng Hiếu', N'Nam', '1990-07-19', '0217190123', 'lehh@gmail.com', N'1080 Nguyễn Chí Thanh,Tân Bình,TPHCM'),
(N'Phạm', N'Thị Dung', N'Nữ', '2000-01-05', '0342628201', 'ptd@gmail.com', N'101 Ngô Quyền,Gò Vấp,TPHCM'),
(N'Hoàng', N'Quốc Tuấn', N'Nữ', '1997-03-22', '0220190121', 'anhkhongbiet@gmail.com', N'621 CMT8,Quận 3,TPHCM');
--======================================================================================================================================================
INSERT INTO DichVu (TenDichVu, MoTa, ThoiLuong, Gia)
VALUES 
(N'Chăm sóc da mặt', N'Dịch vụ chăm sóc da mặt giúp làn da trở nên sáng hơn và tươi trẻ.', 60, 500000.00),
(N'Massage toàn thân', N'Dịch vụ massage toàn thân giúp giảm căng thẳng và mệt mỏi sau những ngày làm việc căng thẳng.', 90, 800000.00),
(N'Chăm sóc móng tay', N'Dịch vụ chăm sóc móng tay chuyên nghiệp giúp móng tay của bạn trở nên đẹp và khỏe mạnh.', 45, 300000.00),
(N'Chăm sóc móng chân', N'Dịch vụ chăm sóc móng chân giúp bạn có đôi chân mềm mại và dễ chịu.', 45, 350000.00),
(N'Cắt tóc', N'Dịch vụ cắt tóc thời trang với các kiểu tóc mới nhất từ các chuyên gia.', 30, 250000.00),
(N'Đắp mặt nạ', N'Đắp mặt nạ giúp làn da của bạn được dưỡng ẩm và trở nên mịn màng.', 45, 400000.00),
(N'Làm đẹp lông mày', N'Dịch vụ làm đẹp lông mày giúp lông mày trở nên đều và đẹp tự nhiên.', 30, 200000.00),
(N'Làm nối mi', N'Dịch vụ làm nối mi giúp mi bạn trở nên dày và cong tự nhiên.', 60, 600000.00),
(N'Tẩy tế bào chết', N'Dịch vụ tẩy tế bào chết giúp loại bỏ các tế bào da chết, làm sạch da và làm sáng da.', 45, 350000.00),
(N'Trị mụn', N'Dịch vụ trị mụn giúp làm giảm vi khuẩn trên da và làm dịu các vùng da bị mụn.', 60, 550000.00),
(N'Phun môi', N'Dịch vụ phun môi giúp làm đầy và tạo hình cho đôi môi của bạn.', 45, 700000.00),
(N'Làm trắng răng', N'Dịch vụ làm trắng răng giúp răng của bạn trở nên sáng và trắng tự nhiên.', 60, 650000.00),
(N'Điều trị nám', N'Dịch vụ điều trị nám giúp làm giảm sự xuất hiện của nám và tàn nhang.', 90, 900000.00),
(N'Điều trị tàn nhang', N'Dịch vụ điều trị tàn nhang giúp làm mờ và giảm thiểu tàn nhang trên da.', 90, 900000.00),
(N'Massage đầu', N'Dịch vụ massage đầu giúp giảm căng thẳng và mệt mỏi, kích thích sự tuần hoàn máu.', 30, 250000.00);
--======================================================================================================================================================
INSERT INTO SanPham (NTenSanPham, MoTa, HinhAnh, SoLuongTon, GiaBan, MaNhaCungCap)
VALUES
(N'Sữa rửa mặt', N'L’Oréal Revitalift Bright Reveal Tẩy tế bào chết hàng ngày', 'loreal_cleanser.png', 50, 450000, 'NCC001'),
(N'Neutrogena Hydro Boost', N'Gel nước dưỡng ẩm Neutrogena Hydro Boost', 'neutrogena_hydro_boost.png', 100, 505000, 'NCC002'),
(N'Niacinamide 10% + Zinc 1%', N'The Ordinary Niacinamide 10% + Zinc 1%', 'ordinary_niacinamide.png', 200, 135000, 'NCC003'),
(N'Sữa rửa mặt dịu nhẹ Cetaphil', N'Sữa rửa mặt dịu nhẹ Cetaphil', 'cetaphil_cleanser.png', 150, 340000, 'NCC004'),
(N'Kem dưỡng ngày L’Oréal', N'L’Oréal Paris Revitalift Kem chống nhăn và làm săn chắc da ban ngày', 'loreal_day_cream.png', 80, 570000, 'NCC001'),
(N'Kem chống nắng Neutrogena', N'Kem chống nắng Neutrogena Ultra Sheer Dry-Touch SPF 100', 'neutrogena_sunscreen.png', 120, 250000, 'NCC002'),
(N'Axit Hyaluronic 2% + B5', N'The Ordinary Axit Hyaluronic 2% + B5', 'ordinary_hyaluronic_acid.png', 180, 155000, 'NCC003'),
(N'Kem dưỡng ẩm Cetaphil', N'Kem dưỡng ẩm Cetaphil', 'cetaphil_moisturizer.png', 130, 300000, 'NCC004'),
(N'Kem dưỡng Toleriane Double Repair', N'La Roche-Posay Toleriane Kem dưỡng phục hồi da', 'laroche_toleriane.png', 90, 460000, 'NCC005'),
(N'Nước khoáng Avene', N'Nước khoáng Avene', 'avene_spring_water.png', 110, 415000, 'NCC006'),
(N'Sữa rửa mặt dưỡng ẩm CeraVe', N'Sữa rửa mặt dưỡng ẩm CeraVe', 'cerave_hydrating_cleanser.png', 140, 345000, 'NCC007'),
(N'Serum trị mụn La Roche-Posay', N'La Roche-Posay Effaclar Serum trị mụn', 'laroche_serum.png', 85, 690000, 'NCC005'),
(N'Toner Avene Cleanance', N'Avene Cleanance MAT Toner làm sạch da', 'avene_cleanance_toner.png', 115, 460000, 'NCC006'),
(N'Kem dưỡng mắt CeraVe', N'Kem dưỡng mắt CeraVe', 'cerave_eye_cream.png', 95, 285000, 'NCC007'),
(N'Kem chống nắng Avene', N'Kem chống nắng Avene Emulsion SPF 50+', 'avene_sunscreen.png', 100, 570000, 'NCC006'),
(N'Kem dưỡng phục hồi CeraVe', N'Kem dưỡng phục hồi da ban đêm CeraVe', 'cerave_night_cream.png', 105, 320000, 'NCC007'),
(N'Mặt nạ dưỡng ẩm Neutrogena', N'Mặt nạ dưỡng ẩm Neutrogena Hydro Boost', 'neutrogena_mask.png', 75, 60000, 'NCC002'),
(N'Kem chống lão hóa L’Oréal', N'L’Oréal Paris Revitalift Kem chống lão hóa ban đêm', 'loreal_night_cream.png', 65, 670000, 'NCC001'),
(N'Kem dưỡng ẩm The Ordinary', N'The Ordinary Kem dưỡng ẩm tự nhiên', 'ordinary_moisturizer.png', 160, 190000, 'NCC003'),
(N'Serum The Ordinary', N'The Ordinary Retinol 0.5% in Squalane', 'ordinary_retinol.png', 120, 215000, 'NCC003'),
(N'Toner La Roche-Posay', N'La Roche-Posay Soothing Lotion', 'laroche_toner.png', 130, 505000, 'NCC005'),
(N'Kem dưỡng ẩm Avene', N'Kem dưỡng ẩm Avene Hydrance Optimale Riche', 'avene_moisturizer.png', 95, 625000, 'NCC006'),
(N'Serum phục hồi da CeraVe', N'CeraVe Skin Renewing Serum', 'cerave_serum.png', 110, 445000, 'NCC007'),
(N'Toner dưỡng ẩm Neutrogena', N'Neutrogena Alcohol-Free Toner', 'neutrogena_toner.png', 80, 180000, 'NCC002'),
(N'Kem dưỡng ngày La Roche-Posay', N'La Roche-Posay Hydraphase Intense Riche', 'laroche_day_cream.png', 70, 745000, 'NCC005');
--======================================================================================================================================================
INSERT INTO NhanVien (Ho, Ten, GioiTinh, SoDienThoai, Email, ChucVu, MaNguoiDung)
VALUES 
(N'Nguyễn', N'Thị Hương', N'Nữ', '0678901234', 'nguyenthihuong@gmail.com', N'Nhân viên spa',3),
(N'Trần', N'Văn Bình', N'Nam', '0789012345', 'tranvanbinh@gmail.com', N'Quản Lí',1),
(N'Lê', N'Thị Hoa', N'Nam', '0890123456', 'lethihua@gmail.com', N'Nhân viên lễ tân',2)
--======================================================================================================================================================
INSERT INTO HoaDon (MaKhachHang, NgayLap, TongTien, TrangThai, GhiChu)
VALUES 
(1, '2024-05-25', 0, N'Đã thanh toán', N'Khách hàng mua nhiều sản phẩm và dịch vụ.'),
(2, '2024-05-26', 0, N'Đã thanh toán', N'Khách hàng sử dụng gói dịch vụ chăm sóc toàn diện.'),
(3, '2024-05-27', 0, N'Đã thanh toán', N'Khách hàng mua sản phẩm và dịch vụ riêng lẻ.'),
(4, '2024-05-28', 0, N'Đã thanh toán', N'Khách hàng sử dụng gói dịch vụ thư giãn.'),
(5, '2024-05-29', 0, N'Đã thanh toán', N'Khách hàng mua bộ dụng cụ cắt tóc.');
--======================================================================================================================================================
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (1, 1, 2, 500000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (1, 2, 1, 300000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (1, 3, 5, 150000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (1, 6, 5, 150000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (2, 4, 1, 1500000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (2, 1, 1, 1000000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (3, 3, 8, 300000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (3, 2, 5, 200000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (4, 1, 2, 1200000.00)
INSERT INTO ChiTietDichVu (MaHoaDon, MaDichVu, SoLuong, DonGia) VALUES (5, 5, 3, 500000.00)
--======================================================================================================================================================
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (1, 1, 1, 450000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (1, 10, 2, 415000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (1, 4, 3, 340000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (1, 5, 1, 570000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (2, 2, 2, 505000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (2, 7, 2, 155000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (3, 3, 1, 135000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (4, 4, 5, 340000.00);
INSERT INTO ChiTietSanPham (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (5, 5, 4, 570000.00);
--======================================================================================================================================================
INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu) VALUES (1, 1, 1, '2024-07-20', '10:00', N'Đã đặt lịch', N'Khách hàng yêu cầu chăm sóc da mặt');
INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu) VALUES (2, 2, 2, '2024-07-02', '11:00', N'Đã đặt lịch', N'Khách hàng yêu cầu massage toàn thân');
INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu) VALUES (3, 3, 3, '2024-07-03', '12:00', N'Đã đặt lịch', N'Khách hàng yêu cầu chăm sóc móng tay');
INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu) VALUES (4, NULL, 1, '2024-07-04', '13:00', N'Đã đặt lịch', N'Khách hàng sẽ quyết định dịch vụ sau');
INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, TrangThai, GhiChu) VALUES (5, 5, 2, '2024-07-05', '14:00', N'Đã đặt lịch', N'Khách hàng yêu cầu cắt tóc');
--======================================================================================================================================================
DELETE FROM NhanVien;
DELETE FROM TaiKhoanDangNhap;
DELETE FROM SanPham;
DELETE FROM NhaCungCap
DELETE FROM ChiTietDichVu;
DELETE FROM ChiTietSanPham;
DELETE FROM LichHen;
DELETE FROM HoaDon;
DELETE FROM DichVu;
DELETE FROM KhachHang;


DBCC CHECKIDENT ('KhachHang', RESEED, 0);
DBCC CHECKIDENT ('ChiTietDichVu', RESEED, 0);
DBCC CHECKIDENT ('ChiTietSanPham', RESEED, 0);
DBCC CHECKIDENT ('HoaDon', RESEED, 0);
DBCC CHECKIDENT ('LichHen', RESEED, 0);
DBCC CHECKIDENT ('NhanVien', RESEED, 0);
DBCC CHECKIDENT ('SanPham', RESEED, 0);
DBCC CHECKIDENT ('DichVu', RESEED, 0);
DBCC CHECKIDENT ('NhanVien', RESEED, 0);

--======================================================================================================================================================
-- Tạm tắt kiểm tra ràng buộc khóa ngoại để thực hiện xóa
EXEC sp_MSForEachTable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL';

-- Xóa các bảng
DROP TABLE IF EXISTS ChiTietDichVu;
DROP TABLE IF EXISTS ChiTietSanPham;
DROP TABLE IF EXISTS LichHen;
DROP TABLE IF EXISTS HoaDon;
DROP TABLE IF EXISTS SanPham;
DROP TABLE IF EXISTS NhanVien;
DROP TABLE IF EXISTS DichVu;
DROP TABLE IF EXISTS KhachHang;
DROP TABLE IF EXISTS NhaCungCap;
DROP TABLE IF EXISTS TaiKhoanDangNhap;

-- Bật lại kiểm tra ràng buộc khóa ngoại
EXEC sp_MSForEachTable 'ALTER TABLE ? WITH CHECK CHECK CONSTRAINT ALL';
--======================================================================================================================================================
-- Truy vấn dữ liệu
SELECT * FROM ChiTietDichVu
SELECT * FROM ChiTietSanPham
SELECT * FROM LichHen
SELECT * FROM HoaDon
SELECT * FROM SanPham
SELECT * FROM NhanVien
SELECT * FROM DichVu
SELECT * FROM KhachHang
