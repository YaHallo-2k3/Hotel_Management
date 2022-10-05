-- values

-- loại phòng
INSERT INTO LoaiPhong
                      (MaLoaiPhong, TenLoaiPhong, GiaGio, GiaNgay, SoNguoi, SoGiuong)
VALUES    ('PHONGDON', N'Phòng đơn', 150000, 250000, 2, 1),
			('PHONGDOI2', N'Phòng đôi 2 người', 150000, 250000, 2, 2),
			('PHONGDOI3', N'Phòng đôi 3 người', 200000, 350000, 3, 2),
			('PHONGDOI4', N'Phòng đôi 4 người', 250000, 400000, 4, 2)

-- PHONG
INSERT INTO Phong
                      (MaPhong, TenPhong, Tang, MaLoaiPhong, TrangThaiPhong)
VALUES    ('101', N'Phòng 101', 1, 'PHONGDON', 0),
		('102', N'Phòng 102', 1, 'PHONGDON', 0),
		('103', N'Phòng 103', 1, 'PHONGDOI2', 0),
		('104', N'Phòng 104', 1, 'PHONGDOI3', 0),
		('105', N'Phòng 105', 1, 'PHONGDOI2', 0),
		('106', N'Phòng 106', 1, 'PHONGDOI4', 0),
		('107', N'Phòng 107', 1, 'PHONGDOI3', 0),
		('108', N'Phòng 108', 1, 'PHONGDOI4', 0),
		('109', N'Phòng 109', 1, 'PHONGDON', 0)

-- chức vụ
INSERT INTO ChucVu
                      (MaChucVu, TenChucVu)
VALUES    ('ADMIN', N'ADMIN'),
		('KETOAN', N'Kế toán'),
		('LETAN', N'Lễ tân')

-- nhân viên
SET DATEFORMAT dmy INSERT INTO NhanVien
                      (MaNhanVien, TenNhanVien, GioiTinh, NgaySinh, SoDienThoai, CMND, MaChucVu, MatKhau, Luong)
VALUES    ('NV22093001', N'Võ Trung Thành', 1, CONVERT(DATETIME, '2000-06-01 00:00:00', 102), '0966026262', '241969434', 'ADMIN', '123', 1000)

--dặt phòng
SET DATEFORMAT dmy INSERT INTO DatPhong
                      (MaDatPhong, TenKhachHang, SoDienThoai, MaLoaiPhong, TienCoc, ThoiGianDen, ThoiGianTra, SoLuongKhach, GhiChu, TrangThaiDatPhong, MaNhanVien)
VALUES    ('DP22093001', N'Hồ Xuân Hương', '0976646544', 'PHONGDON', 0, CONVERT(DATETIME, '2022-10-01 00:00:00', 102), CONVERT(DATETIME, '2022-10-03 00:00:00', 102), 2,' ', 0, 'NV22093001')

-- KHÁCH HÀNG
set dateformat dmy INSERT INTO KhachHang
                      (CMND, TenKhachHang, MaNhanVien)
VALUES    ('234234234', N'Huỳnh Khải Hoàn', 'NV22093001'), ('123123123', N'Xuân Diệu', 'NV22093001')

-- phiếu thuê phòng
INSERT INTO PhieuDichVu (MaPhieuDichVu, MaPhong) VALUES ('PV22093001', '101')

set dateformat dmy INSERT INTO PhieuThuePhong
                      (MaPhieuThue, MaPhong, CMND, SoLuongKhach, TienCoc, GiamGia, NgayTraPhong, GhiChu, MaNhanVien, TrangThaiThanhToan)
VALUES    ('PT22093001', '101', '234234234', 2, 0, 0, CONVERT(DATETIME, '2022-10-03 00:00:00', 102),' ', 'NV22093001', 0)

UPDATE    Phong
SET             TrangThaiPhong = 1
WHERE     (MaPhong = '101')

-- tao SP_TaoPhieuThuePhong để tạo phiếu thuê phòng, khách hàng và đổi trạng thái phòng
go
create procedure SP_TaoPhieuThuePhong (@CMND varchar(15), @MaNhanVien varchar(10), @MaPhieuThue varchar(10), @MaPhong varchar(10),
										@SoLuongKhach int, @TienCoc money, @GiamGia money, @NgayTraPhong datetime, @GhiChu nvarchar(200), @MaPhieuDichVu VARCHAR(10))
as
BEGIN

INSERT INTO PhieuDichVu (MaPhieuDichVu, MaPhong) VALUES (@MaPhieuDichVu, @MaPhong)

set dateformat dmy INSERT INTO PhieuThuePhong
(MaPhieuThue, MaPhong, CMND, SoLuongKhach, TienCoc, GiamGia, NgayTraPhong, GhiChu, MaNhanVien, TrangThaiThanhToan)
VALUES (@MaPhieuThue, @MaPhong, @CMND, @SoLuongKhach, @TienCoc, @GiamGia, @NgayTraPhong, @GhiChu, @MaNhanVien, 0)

UPDATE Phong SET TrangThaiPhong = 1 WHERE (MaPhong = @MaPhong)

END
-- ví dụ về SP_TaoPhieuThuePhong
EXEC dbo.SP_TaoPhieuThuePhong @CMND = '123123123',                            -- varchar(15)
                              @MaNhanVien = 'NV22093001',                      -- varchar(10)
                              @MaPhieuThue = 'PT22093002',                     -- varchar(10)
                              @MaPhong = '102',                         -- varchar(10)
                              @SoLuongKhach = 1,                     -- int
                              @TienCoc = 100000,                       -- money
                              @GiamGia = 0,                       -- money
                              @NgayTraPhong = '01/10/2022', -- datetime
                              @GhiChu = N'no',                          -- nvarchar(200)
							  @MaPhieuDichVu = 'PV22093002'

-- loại sản phẩm
INSERT INTO LoaiSanPham
                      (MaLoaiSanPham, TenLoaiSanPham)
VALUES    ('GIAIKHAT', N'Nước giải khát')

-- sản phẩm
INSERT INTO SanPham
                      (MaSanPham, TenSanPham, MaLoaiSanPham, DonVi, SoLuong, GiaBan)
VALUES    ('REDBULL', N'Nước RedBull', 'GIAIKHAT', N'Lon', 0, 20000)

-- nhap kho
INSERT INTO NhapKho
                      (MaNhapKho, GhiChu, MaNhanVien)
VALUES    ('NK22093001', N'không', 'NV22093001')

-- chi tiết nhập kho
-- tạo SP tạo chi tiết nhập kho và cập nhập số lượng bảng sản phẩm
GO
CREATE PROCEDURE SP_TaoChiTietNhapKho (@MaChiTietNhapKho VARCHAR(10), @MaNhapKho VARCHAR(10), @MaSanPham VARCHAR(10), @SoLuong NUMERIC, @GiaNhap MONEY)
AS
BEGIN

INSERT INTO ChiTietNhapkho
(MaChiTetNhapKho, MaNhapKho, MaSanPham, SoLuong, GiaNhap)
VALUES
(@MaChiTietNhapKho, @MaNhapKho, @MaSanPham, @SoLuong, @GiaNhap)

UPDATE dbo.SanPham SET SoLuong = @SoLuong WHERE MaSanPham = @MaSanPham

END

EXEC dbo.SP_TaoChiTietNhapKho @MaChiTietNhapKho = 'CK22093001', -- varchar(10)
                              @MaNhapKho = 'NK22093001',        -- varchar(10)
                              @MaSanPham = 'REDBULL',        -- varchar(10)
                              @SoLuong = 24,           -- numeric
                              @GiaNhap = 8600         -- money

-- CHI TIẾT DỊCH VỤ
INSERT INTO ChiTietDichVu
                      (MaChiTietDichVu, MaPhieuDichVu, MaSanPham, SoLuong, GiaTien, GhiChu, MaNhanVien)
VALUES    ('CV22093001', 'PV22093002', 'REDBULL', 2, 20000, N'KHONG', 'NV22093001')

UPDATE    SanPham
SET             SoLuong = 22
WHERE     (MaSanPham = 'REDBULL')

-- HÓA ĐON và update tình trạng phòng và tình trạng thanh toán của phiếu thuê
go
CREATE PROCEDURE SP_TaoHoaDon (@MaHoaDon varchar(10), @MaPhieuThue VARCHAR(10), @MaPhieuDichVu VARCHAR(10), @TienPhong MONEY, @TienDichVu MONEY, 
								@MaNhanVien VARCHAR(10))
AS
BEGIN

INSERT INTO HoaDon (MaHoaDon, MaPhieuThue, MaPhieuDichVu, TienPhong, TienDichVu, MaNhanVien) 
VALUES (@MaHoaDon, @MaPhieuThue, @MaPhieuDichVu, @TienPhong, @TienDichVu, @MaNhanVien)

UPDATE dbo.PhieuThuePhong SET TrangThaiThanhToan = 1 WHERE MaPhieuThue = @MaPhieuThue

DECLARE @MaPhong VARCHAR(10)
SELECT @MaPhong = MaPhong FROM dbo.PhieuThuePhong WHERE MaPhieuThue = @MaPhieuThue
UPDATE dbo.Phong set TrangThaiPhong = 2 WHERE MaPhong = @MaPhong

END

EXEC dbo.SP_TaoHoaDon @MaHoaDon = 'HD22100101',      -- varchar(10)
                      @MaPhieuThue = 'PT22093001',   -- varchar(10)
                      @MaPhieuDichVu = 'PV22093001', -- varchar(10)
                      @TienPhong = 2,   -- money
                      @TienDichVu = 2,  -- money
                      @MaNhanVien = 'NV22093001'     -- varchar(10)

-- BÀI TOÁN TÍNH GIỜ VÀ NGÀY
--DECLARE @StartDate DATETIME, @EndDate DATETIME
--SELECT @StartDate = NgayTao FROM dbo.PhieuThuePhong WHERE MaPhieuThue = 'PT22093001';
--SELECT @EndDate = NgayTraPhong FROM dbo.PhieuThuePhong WHERE MaPhieuThue = 'PT22093001';
--SELECT DATEDIFF(HOUR, @StartDate, @EndDate)
--SELECT DATEDIFF(DAY, @StartDate, @EndDate)

