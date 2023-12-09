package DTO;

public class PhieuMuon {
    private int maPhieu;
    private int maThanhVien;
    private String maNV;
    private String ngayMuon;
    private String ngayTra;
    private String ngayHan;

    public PhieuMuon(int maPhieu, int maThanhVien, String maNV, String ngayMuon, String ngayTra, String ngayHan) {
        this.maPhieu = maPhieu;
        this.maThanhVien = maThanhVien;
        this.maNV = maNV;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ngayHan = ngayHan;
    }

    public PhieuMuon() {
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getNgayHan() {
        return ngayHan;
    }

    public void setNgayHan(String ngayHan) {
        this.ngayHan = ngayHan;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" +
                "maPhieu=" + maPhieu +
                ", maThanhVien=" + maThanhVien +
                ", maNV='" + maNV + '\'' +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", ngayTra='" + ngayTra + '\'' +
                ", ngayHan='" + ngayHan + '\'' +
                '}';
    }
}
