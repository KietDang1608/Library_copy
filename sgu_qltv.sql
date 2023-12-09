-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for sgu_qltv
CREATE DATABASE IF NOT EXISTS `sgu_qltv` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `sgu_qltv`;

-- Dumping structure for table sgu_qltv.ct_phan_quyen
CREATE TABLE IF NOT EXISTS `ct_phan_quyen` (
  `ma_quyen` int(11) DEFAULT NULL,
  `ma_vi_tri` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.ct_phan_quyen: ~28 rows (approximately)
REPLACE INTO `ct_phan_quyen` (`ma_quyen`, `ma_vi_tri`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 2),
	(1, 3),
	(2, 3),
	(4, 3),
	(1, 4),
	(2, 4),
	(3, 4),
	(4, 4),
	(5, 4),
	(6, 4),
	(7, 4),
	(8, 4),
	(9, 4),
	(10, 4),
	(11, 4),
	(12, 4),
	(1, 1),
	(2, 1),
	(3, 1),
	(5, 1),
	(6, 1),
	(7, 1);

-- Dumping structure for table sgu_qltv.ct_phieu_muon
CREATE TABLE IF NOT EXISTS `ct_phieu_muon` (
  `ma_phieu` int(11) DEFAULT NULL,
  `ma_sach` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.ct_phieu_muon: ~8 rows (approximately)
REPLACE INTO `ct_phieu_muon` (`ma_phieu`, `ma_sach`) VALUES
	(1, 13),
	(2, 20),
	(3, 12),
	(4, 11),
	(5, 4),
	(6, 6),
	(7, 16),
	(7, 17),
	(7, 18),
	(8, 17),
	(8, 1);

-- Dumping structure for table sgu_qltv.ct_phieu_nhap
CREATE TABLE IF NOT EXISTS `ct_phieu_nhap` (
  `ma_phieu` int(11) DEFAULT NULL,
  `ma_sach` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `don_gia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.ct_phieu_nhap: ~18 rows (approximately)
REPLACE INTO `ct_phieu_nhap` (`ma_phieu`, `ma_sach`, `so_luong`, `don_gia`) VALUES
	(1, 1, 40, 130000),
	(1, 2, 40, 130000),
	(2, 3, 40, 80000),
	(2, 4, 20, 100000),
	(3, 5, 20, 65000),
	(3, 6, 20, 30000),
	(4, 7, 20, 125000),
	(4, 8, 20, 135000),
	(5, 9, 20, 99000),
	(6, 10, 20, 180000),
	(7, 11, 20, 140000),
	(8, 12, 30, 200000),
	(9, 13, 10, 45000),
	(10, 14, 30, 100000),
	(10, 15, 30, 100000),
	(10, 16, 30, 65000),
	(10, 17, 30, 75000),
	(10, 18, 30, 85000),
	(11, 20, 20, 195000),
	(12, 29, 20, 30000),
	(13, 1, 1, 100000);

-- Dumping structure for table sgu_qltv.login
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.login: ~1 rows (approximately)
REPLACE INTO `login` (`username`) VALUES
	('kiettd');

-- Dumping structure for table sgu_qltv.nhan_vien
CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `ma_nv` varchar(20) NOT NULL,
  `ma_vi_tri` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `ho_lot` varchar(30) DEFAULT NULL,
  `ten` varchar(10) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(50) DEFAULT NULL,
  `ngay_lam` date DEFAULT NULL,
  `ngay_nghi` date DEFAULT NULL,
  PRIMARY KEY (`ma_nv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.nhan_vien: ~9 rows (approximately)
REPLACE INTO `nhan_vien` (`ma_nv`, `ma_vi_tri`, `password`, `ho_lot`, `ten`, `sdt`, `email`, `dia_chi`, `ngay_lam`, `ngay_nghi`) VALUES
	('admin', 4, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	('datHuynh', 2, '1', 'Huỳnh Tuấn', 'Đạt', '0987115245', 'dat@gmail.com', '126, Điện Biên Phủ, Bình Thạnh', '2023-10-11', NULL),
	('hungDO', 1, '1', 'Đỗ Phước', 'Hưng', '0987456123', 'hung@gmail.com', '103 Phan Đình Phùng, Q1', '2023-10-06', NULL),
	('huyTran123', 3, '1', 'Trần Lương Thiệu', 'Huy', '0246578445', 'huy@gmail.com', '24 Võ Thị Sáu, Q1', '2023-10-11', NULL),
	('kiettd', 4, 'kiettd', 'Đặng Tuấn', 'Kiệt', '0384996870', 'kietd@gmail.com', '8 Lý Phục Man, Q7', '2023-10-06', NULL),
	('minHuu', 3, '1', 'Nguyễn Min', 'Hữu', '0123456789', 'huu@gmail.com', '273 An Dương Vương P3, Q5', '2023-10-06', NULL),
	('phandat', 1, '1', 'Phan Nguyễn Tấn', 'Đạt', '0384996810', 'phandat@gmail.com', '100 Huỳnh tấn Phát', '2023-11-04', NULL),
	('tienNguyen', 4, '1', 'Nguyễn Phước', 'Tiến', '0235446557', 'tien@gmail.com', '100 Trần Hưng Đạo, Q10', '2023-10-11', NULL),
	('vietkhoi123', 3, '1', 'Nguyễn Viế', 'Khôi', '0987425657', 'khoi@gmail.com', '243, Điện Biên Phủ, Q3', '2023-10-11', '2023-12-01');

-- Dumping structure for table sgu_qltv.nha_cung_cap
CREATE TABLE IF NOT EXISTS `nha_cung_cap` (
  `ma_ncc` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(80) DEFAULT NULL,
  `dien_thoai` char(10) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ma_ncc`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.nha_cung_cap: ~7 rows (approximately)
REPLACE INTO `nha_cung_cap` (`ma_ncc`, `ten`, `dia_chi`, `dien_thoai`, `email`) VALUES
	(1, 'Công ty cổ phần phát hành sách TPHCM', '60-62 Lê Lợi, P. Bến Nghé, Q. 1,', '0283822579', 'fahasasg@gmail.com'),
	(2, 'Công Ty TNHH Văn Hóa Việt Long', '14/35, Đào Duy Anh, P.9, Q. Phú Nhuận,Tp.HCM', '0987234543', 'vietlong@gmail.com'),
	(3, 'Nhà Sách Trực Tuyến BOOKBUY.VN\r\n', '147 Pasteur, P. 6, Q. 3,Tp. Hồ Chí Minh', '0933109009', 'bookbuy@gmail.com'),
	(4, 'Nhà sách Bích Quân\r\n', '249 Lý Thường Kiệt, KP. Thống Nhất 1, Dĩ An,Bình Dương\r\n\r\n', '0944566788', 'sachsichauhaiphong@gmail.com'),
	(5, 'Hiệu Sách Tiến Thành', 'Số 11-13 Đường 53, P. 10, Q. 6,TPHCM', '0919196677', 'kimlong240988@gmail.com'),
	(6, 'Nobita.vn - Nhà Sách Trên Internet\r ', '74/7 Nguyễn Cừ, Thảo Điền, Q. 2,TPHCM', '0974941097', 'nobita@gmail.com');

-- Dumping structure for table sgu_qltv.phieu_muon
CREATE TABLE IF NOT EXISTS `phieu_muon` (
  `ma_phieu` int(11) NOT NULL AUTO_INCREMENT,
  `ma_thanh_vien` int(11) DEFAULT NULL,
  `ma_nv` varchar(50) DEFAULT NULL,
  `ngay_muon` date DEFAULT NULL,
  `ngay_tra` date DEFAULT NULL,
  `ngay_han` date DEFAULT NULL,
  PRIMARY KEY (`ma_phieu`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.phieu_muon: ~7 rows (approximately)
REPLACE INTO `phieu_muon` (`ma_phieu`, `ma_thanh_vien`, `ma_nv`, `ngay_muon`, `ngay_tra`, `ngay_han`) VALUES
	(1, 1, 'huyTran123', '2023-11-15', '2023-11-15', '2023-11-22'),
	(2, 8, 'huyTran123', '2023-11-15', '2023-11-20', '2023-11-22'),
	(3, 10, 'huyTran123', '2023-11-15', '2023-11-20', '2023-11-22'),
	(4, 6, 'huyTran123', '2023-11-15', '2023-11-20', '2023-11-22'),
	(5, 3, 'huyTran123', '2023-11-15', '2023-11-20', '2023-11-22'),
	(6, 7, 'huyTran123', '2023-11-15', '2023-11-20', '2023-11-22'),
	(7, 2, 'admin', '2023-11-15', '2023-11-20', '2023-11-22'),
	(8, 4, 'kiettd', '2023-11-28', NULL, '2023-12-05');

-- Dumping structure for table sgu_qltv.phieu_nhap
CREATE TABLE IF NOT EXISTS `phieu_nhap` (
  `ma_phieu` int(11) NOT NULL AUTO_INCREMENT,
  `ma_ncc` int(11) DEFAULT NULL,
  `ma_nv` varchar(20) DEFAULT NULL,
  `ngay_nhap` date DEFAULT NULL,
  PRIMARY KEY (`ma_phieu`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.phieu_nhap: ~11 rows (approximately)
REPLACE INTO `phieu_nhap` (`ma_phieu`, `ma_ncc`, `ma_nv`, `ngay_nhap`) VALUES
	(1, 1, 'kiettd', '2023-01-10'),
	(2, 2, 'huyTran123', '2023-01-10'),
	(3, 1, 'huyTran123', '2023-01-10'),
	(4, 1, 'huyTran123', '2023-01-10'),
	(5, 1, 'huyTran123', '2023-01-10'),
	(6, 1, 'huyTran123', '2023-01-10'),
	(7, 1, 'huyTran123', '2023-01-10'),
	(8, 1, 'huyTran123', '2023-01-10'),
	(9, 1, 'huyTran123', '2023-01-10'),
	(10, 1, 'huyTran123', '2023-01-10'),
	(11, 1, 'huyTran123', '2023-01-10'),
	(12, 5, 'admin', '2023-11-20'),
	(13, 1, 'kiettd', '2023-12-01');

-- Dumping structure for table sgu_qltv.phieu_phat
CREATE TABLE IF NOT EXISTS `phieu_phat` (
  `ma_phieu_phat` int(11) NOT NULL AUTO_INCREMENT,
  `ma_sach` int(11) DEFAULT NULL,
  `ma_thanh_vien` int(11) DEFAULT NULL,
  `ma_phieu_muon` int(11) DEFAULT NULL,
  `ma_quy_dinh` int(11) DEFAULT NULL,
  `ngay_phat` date DEFAULT NULL,
  `trang_thai` varchar(50) DEFAULT NULL,
  `mo_ta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_phieu_phat`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.phieu_phat: ~0 rows (approximately)
REPLACE INTO `phieu_phat` (`ma_phieu_phat`, `ma_sach`, `ma_thanh_vien`, `ma_phieu_muon`, `ma_quy_dinh`, `ngay_phat`, `trang_thai`, `mo_ta`) VALUES
	(1, 13, 1, 1, 2, '2023-11-17', 'true', 'Lam hu sach');

-- Dumping structure for table sgu_qltv.quyen
CREATE TABLE IF NOT EXISTS `quyen` (
  `ma_quyen` int(11) NOT NULL AUTO_INCREMENT,
  `ten_quyen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_quyen`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.quyen: ~15 rows (approximately)
REPLACE INTO `quyen` (`ma_quyen`, `ten_quyen`) VALUES
	(1, 'Quản lý sách'),
	(2, 'Quản lý thể loại sách'),
	(3, 'Quản lý quy định'),
	(4, 'Quản lý phiếu nhập'),
	(5, 'Quản lý phiếu mượn'),
	(6, 'Quản lý thành viên'),
	(7, 'Quản lý phiếu phạt'),
	(8, 'Phân quyền'),
	(9, 'Quản lý nhân viên'),
	(10, 'Quản lý tài khoản'),
	(11, 'Thống kê'),
	(12, 'Quản lý nhà cung cấp'),
	(13, 'Lập phiếu phạt'),
	(14, 'Lập phiếu mượn'),
	(15, 'Nhập hàng');

-- Dumping structure for table sgu_qltv.quy_dinh
CREATE TABLE IF NOT EXISTS `quy_dinh` (
  `ma_quy_dinh` int(11) NOT NULL AUTO_INCREMENT,
  `ten_quy_dinh` varchar(70) DEFAULT NULL,
  `tien_phat` int(11) DEFAULT NULL,
  PRIMARY KEY (`ma_quy_dinh`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.quy_dinh: ~4 rows (approximately)
REPLACE INTO `quy_dinh` (`ma_quy_dinh`, `ten_quy_dinh`, `tien_phat`) VALUES
	(1, 'Trả sách trễ hạn phạt 10% tiền sách * số ngày trễ ', 10),
	(2, 'Làm rách sách, mất trang phạt gấp đôi tiền sách', 200),
	(3, 'Mất sách phạt 100% tiền sách', 100);

-- Dumping structure for table sgu_qltv.sach
CREATE TABLE IF NOT EXISTS `sach` (
  `ma_sach` int(11) NOT NULL AUTO_INCREMENT,
  `ma_loai` int(11) DEFAULT NULL,
  `ten_sach` varchar(50) DEFAULT NULL,
  `img` varchar(60) DEFAULT NULL,
  `tac_gia` varchar(50) DEFAULT NULL,
  `nha_xuat_ban` varchar(50) DEFAULT NULL,
  `ngay_xuat_ban` varchar(50) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  PRIMARY KEY (`ma_sach`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.sach: ~29 rows (approximately)
REPLACE INTO `sach` (`ma_sach`, `ma_loai`, `ten_sach`, `img`, `tac_gia`, `nha_xuat_ban`, `ngay_xuat_ban`, `so_luong`) VALUES
	(1, 6, 'Người dấn thân', 'nguoiDanThan.jpg', 'Higashino Keigo\r\n', 'NXB Trẻ', '2008', 40),
	(2, 4, 'Cuộc Biến Cố Sapiens\r\n', 'cuocBienCoSapiens.jpg', 'Yuval Noah Harari\r\n', 'Nhà Xuất Bản Thế Giới\r\n', '2014\r\n', 40),
	(3, 11, 'Đắc Nhân Tâm\r\n', 'dacNhanTam.jpg', 'Dale Carnegie\r\n', 'Dale Carnegie\r\n', '1936\r\n', 40),
	(4, 6, 'Hai Số Phận\r\n', 'haiSoPhan.jpg', 'Asimov Isaac\r\n', 'NXB Kim Đồng\r\n', '2003\r\n', 19),
	(5, 6, 'Cuốn Theo Chiều Gió\r\n', 'CuonTheoChieuGio.jpg', 'Margaret Mitchell\r\n', 'Macmillan Publishers\r\n', '1936\r\n', 20),
	(6, 6, 'Người Thầy ', 'dauAnRongThan.jpg', 'Nguyễn Chí Vịnh', 'Quân Đội Nhân Dân', '2023', 19),
	(7, 6, 'Những Người Đàn Bà\r\n', 'nguoiDanBaTaiSinh.jpg', 'Kim Thúy\r\n', 'HarperCollins\r\n', '2010', 20),
	(8, 6, 'Tôi Là Bêtô\r\n', 'toiLaBeto.jpg', 'Phan Y Yên\r\n', 'NXB Văn Học\r\n', '2017', 20),
	(9, 11, 'Tôi Phải Sống\r\n', 'toiPhaiSong.jpg', 'Du Phương Liên\r\n', 'NXB Dân Trí\r\n', '2005', 20),
	(10, 6, 'Bố Già\r\n', 'boGia.jpg', 'Mario Puzo\r\n', 'Gollancz\r\n', '1969', 20),
	(11, 11, 'Sức Mạnh Của Thói Quen\r\n', 'sucManhCuaThoiQUen.jpg', 'Charles Duhigg\r\n', 'NXB Lao Động - Xã Hội\r\n', '2012\r\n', 19),
	(12, 6, 'Cây Cam Ngọt', 'cayCamNgot.jpg', 'John Steinbeck\r\n', 'Grove Press\r\n', '1967\r\n', 29),
	(13, 6, 'Mùa Hè Không Tên\r\n', 'muaHeKhongTen.jpg', 'Nguyễn Nhật Ánh\r\n', 'NXB Trẻ\r\n', '1949\r\n', 10),
	(14, 6, 'Kẻ Trộm Sách\r\n', 'keTromSach.jpg', 'Michael Connelly\r\n', 'NXB Trẻ\r\n', '2019\r\n', 30),
	(15, 11, 'Nghĩ Giàu Làm Giàu\r\n', 'nghiGiauLamGiau.jpg', 'Napoleon Hill\r\n', 'NXB Phụ Nữ\r\n', '1937', 30),
	(16, 6, 'Cho Tui Xin 1 Vé Đi Tuổi Thơ\r\n', 'choToiXin1veDiTuoiTho.jpg', 'Nguyễn Nhật Ánh\r\n', 'NXB Trẻ\r\n', '2001\r\n', 29),
	(17, 6, 'Người Mẹ Tốt Hơn Là Người Vợ Tốt\r\n', 'nguoiMeTotHonNguoiVoTot.jpg', 'Nguyễn Nhật Ánh\r\n', 'Đinh Tị\r\n', '2014\r\n', 29),
	(18, 6, 'Có 2 Con Mèo Ngồi Bên Cửa Sổ\r\n', 'co2ConMeo.jpg', 'Nguyễn Nhật Ánh\r\n', 'NXB Trẻ\r\n', '2014\r\n', 29),
	(19, 6, 'Mười Người Da Đen Ngồi Xem Một Cô Gái Trắng Hát\r\n', '10NguoiDaDenNho.jpg', 'Agatha Christie\r\n', 'NXB Kim Đồng\r\n', '1969\r\n', 0),
	(20, 11, 'Đánh Thức Con Người Phi Thường Trong Bạn\r\n', 'danhThucConNguoiPhiThuongTrongBan.jpg', 'Anthony Robbins\r\n', 'NXB Thanh Niên\r\n', '2015', 19),
	(21, 1, 'Hành Trình Chính Trị Của Tôi', 'hanhtrinhCT.jpg', 'Tony', 'Alpha BOOK', '2010', 0),
	(22, 2, 'KHOA HỌC KHÁM PHÁ - CUỘC CHIẾN LỖ ĐEN', 'loden.jpg', 'Leonard Susskind\r\n', 'NXB Trẻ', '2015', 0),
	(23, 3, 'Ngàn Năm Áo Mũ', 'ngan-nam-ao-mu.jpg', 'Trần Quang Đức', 'NXB Thế Giới', '2016', 0),
	(24, 4, 'Nhật Bản - Đất Nước Và Con Người', 'nb.jpg', 'Eiichi Aoki', 'NXB Hồng Đức', '2010', 0),
	(25, 5, 'Giáo Trình Triết Học Mác - Lênin', 'mac_lenin.jpg', 'Bộ Giáo Dục Và Đào Tạo', 'NXB Chính Trị Quốc Gia Sự Thật', '2000', 0),
	(26, 7, 'Không Diệt Không Sinh Đừng Sợ Hãi', 'dietsinh.jpg', 'Thích Nhất Hạnh', 'Thế Giới', '2022', 0),
	(27, 8, '\r\nĐất Rừng Phương Nam', 'drpn.jpg', 'Đoàn Giỏi', 'NXB Kim Đồng', '2018', 0),
	(28, 9, '\r\nEat Clean - Ăn Sạch Sống Khỏe', 'eatclean.jpg', 'Emma Phạm', 'Thế Giới', '2020', 0),
	(29, 10, 'Việt Nam - Lãnh Thổ Và Các Vùng Địa Lý\r\n', 'vnltdl.jpg', 'GS Lê Bá Thảo', 'Dân Trí', '1999', 20);

-- Dumping structure for table sgu_qltv.thanh_vien
CREATE TABLE IF NOT EXISTS `thanh_vien` (
  `ma_thanh_vien` int(11) NOT NULL AUTO_INCREMENT,
  `ho_lot` varchar(50) DEFAULT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(50) DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `han_su_dung` date DEFAULT NULL,
  PRIMARY KEY (`ma_thanh_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.thanh_vien: ~39 rows (approximately)
REPLACE INTO `thanh_vien` (`ma_thanh_vien`, `ho_lot`, `ten`, `sdt`, `email`, `dia_chi`, `ngay_tao`, `han_su_dung`) VALUES
	(1, 'Đặng Tuấn', 'Kiệt', '0384996812', 'kiet@gmail.com', '100 Phan Văn Hớn, Q12', '2023-10-31', '2024-01-06'),
	(2, 'Trần', 'Văn Thị', '0987118456', 'tragiang.vu@gmail.com', '253 Hòa Hảo P.4 Q.10', '2023-10-31', '2023-12-31'),
	(3, 'Lưu', 'Hồng Đức', '0987115236', 'phuongngoc_ho@gmail.com', '112 đường số 47 P.Tân Quý Q.7', '2023-10-31', '2023-12-31'),
	(4, 'Nguyễn', 'Thị Thơ', '0384664561', 'kien13@gmail.com', '416 Cách mạng tháng Tám P.11 Q.3', '2023-10-31', '2023-12-31'),
	(5, 'Phan', 'Thế Sơn', '0987258789', 'linhthai@gmail.com', '31 Cao Thắng P.12 Q.3', '2023-10-31', '2023-12-31'),
	(6, 'Đào', 'Văn Nhất', '0368123456', 'chuonghai@gmail.com', '45A Mạc Đĩnh Chi P.Dakao Q.1', '2023-10-31', '2024-01-31'),
	(7, 'Đỗ', 'Tuấn Năm', '0500648362', 'thanhlan91@gmail.com', '138/25 Nguyễn Trãi P.3 Q.5', '2023-10-31', '2023-12-30'),
	(8, 'Lê', 'Phước Tam', '0466298243', 'quangvu57@gmail.com', '168A Tùng Thiện Vương P.11 Q.8', '2023-10-31', '2023-11-30'),
	(9, 'Hà', 'Gia Thất', '0614807992', 'hoathien12@gmail.com', '1939 Phạm Thế Hiển P.6 Q.8', '2023-10-31', '2023-10-31'),
	(10, 'Liên', 'Minh Hữu', '0478532369', 'lapnghiep20@gmail.com', '456 Trần Hưng Đạo P.2 Q.5', '2023-10-31', '2023-12-31'),
	(11, 'Trương', 'Thị Lựu', '0129610309', 'chikhang@gmail.com', '34 Phú Thọ P.2 Q.11', '2023-10-31', '2023-11-01'),
	(12, 'nguyen thi', 'thap', '0123234456', 'thap@gmail.com', '20 bến vân đồn, Q7', '2023-11-09', '2023-12-09'),
	(13, 'Nguyễn Văn	', 'An', '0901234567', 'nva@gmail.com', '123 Đường Võ Thị Sáu, Quận 1, Thành phố Hồ Chí Min', '2023-10-01', '2023-11-28'),
	(14, '	Trần Thị ', 'Bình', '0987654321', 'tranthib@gmail.com', '456 Đường ADV, Quận 5, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(15, 'Lê Văn', 'Cảnh', '0912345678', 'levanc@gmail.com', '789 Đường KLM, Quận 10, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(16, 'Phạm Thị', 'Dung', '0976543210', 'phamthid@gmail.com', '234 Đường DEF, Quận 3, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(17, 'Trần Văn	', 'Em', '0967890123', 'tranve@gmail.com', '567 Đường GHI, Quận 7, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(19, '	Đỗ Văn', 'Giỏi', '0923456789', 'dovang@gmail.com', '345 Đường MNO, Quận 4, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(21, 'Nguyễn Thị', 'Hằng', '0932109876	', 'nguyenth@gmail.com', '678 Đường PQR, Quận 6, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(22, 'Lý Văn', 'In', '0954321098', 'lyvan@gmail.com', '901 Đường STU, Quận 8, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(23, 'Mai Thị', 'Khánh', '0998765432	', 'maithik@gmail.com', '123 Đường VWX, Quận 9, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(24, '	Vũ Thị', 'Linh', '0987654321', 'vuthil@gmail.com', '234 Đường KLM, Quận 5, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(25, 'Hoàng Văn', 'Minh', '0912345678', 'hoangvanm@gmail.com', '567 Đường NOP, Quận 10, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(26, 'Nguyễn Thị	', 'Ngân', '0976543210', 'nguyenthin@gmail.com', '890 Đường QRS, Quận 2, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(27, 'Trần Văn', 'Ong', '0967890123', 'tranvo@gmail.com', '123 Đường TUV, Quận 7, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(28, 'Phạm Văn', 'Phát', '0945678901', 'phamvanp@gmail.com', '456 Đường WXY, Quận 4, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(29, 'Lê Thị', 'Quỳnh', '0923456789', 'lethiq@gmail.com', '789 Đường XYZ, Quận 3, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(30, 'Đặng Văn', 'Rành', '0932109876', 'dangvanr@gmail.com', '234 Đường ABC, Quận 6, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(31, 'Mai Văn', 'Sĩ', '0954321098', 'maivans@gmail.com', '567 Đường DEF, Quận 8, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(32, '	Nguyễn Văn', 'Thảo', '0998765432	', 'nguyenvant@gmail.com', '890 Đường GHI, Quận 9, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(33, 'Lý Thị', 'Uyên', '0912345678', 'lythiu@gmail.com', '123 Đường JKL, Quận 1, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(34, 'Vũ Văn', 'Vỹ', '0987654321', 'vuvanv@gmail.com', '234 Đường NOP, Quận 5, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(35, 'Hoàng Thị', 'Xuyến', '0912345678', 'hoangthix@gmail.com', '567 Đường QRS, Quận 10, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(36, 'Nguyễn Văn', 'Yến', '0976543210', 'nguyenvany@gmail.com', '890 Đường TUV, Quận 2, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-11-28'),
	(37, 'Trần Văn', 'Vũ', '0967890123', 'tranvanz@gmail.com', '123 Đường WXY, Quận 7, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-12-31'),
	(38, '	Phạm Thị', 'Anh', '0945678901', 'phamthia@gmail.com', '456 Đường ABC, Quận 4, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-12-31'),
	(39, 'Lê Văn', 'Bảo', '0923456789', 'levanb@gmail.com', '789 Đường DEF, Quận 3, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-12-31'),
	(40, '	Đặng Thị', 'Canh', '0932109876', 'dangthic@gmail.com', '234 Đường GHI, Quận 6, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-12-31'),
	(41, 'Mai Văn', 'Dũng', '0954321098', 'maivand@gmail.com', '567 Đường JKL, Quận 8, Thành phố Hồ Chí Minh\r\n', '2023-10-01', '2023-12-31');

-- Dumping structure for table sgu_qltv.the_loai
CREATE TABLE IF NOT EXISTS `the_loai` (
  `ma_loai` int(11) NOT NULL AUTO_INCREMENT,
  `ten_loai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_loai`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.the_loai: ~12 rows (approximately)
REPLACE INTO `the_loai` (`ma_loai`, `ten_loai`) VALUES
	(1, 'Sách chính trị - pháp luật'),
	(2, 'Sách Khoa học công nghệ – Kinh tế'),
	(3, 'Sách Văn học nghệ thuật'),
	(4, 'Sách Văn hóa xã hội – Lịch sử'),
	(5, 'Sách Giáo trình'),
	(6, 'Sách Truyện, tiểu thuyết'),
	(7, 'Sách Tâm lý, tâm linh, tôn giáo'),
	(8, 'Sách thiếu nhi'),
	(9, 'Sách dạy nấu ăn'),
	(10, 'Sách lịch sử'),
	(11, 'Sách tự lực');

-- Dumping structure for table sgu_qltv.vi_tri
CREATE TABLE IF NOT EXISTS `vi_tri` (
  `ma_vi_tri` int(11) NOT NULL AUTO_INCREMENT,
  `ten_vi_tri` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_vi_tri`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table sgu_qltv.vi_tri: ~4 rows (approximately)
REPLACE INTO `vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES
	(1, 'Thủ thư'),
	(2, 'Quản lý'),
	(3, 'Trực kho'),
	(4, 'Admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
