package DTO;

public class PhieuPhat {
    private int maPhieuPhat;
    private int maSach;
    private int maThanhVien;
    private int maPhieuMuon;
    private int maQuyDinh;
    private String ngayPhat;
    private String trangThai;
    private String moTa;

    public PhieuPhat(int maPhieuPhat, int maSach, int maThanhVien, int maPhieuMuon, int maQuyDinh, String ngayPhat, String trangThai, String moTa) {
        this.maPhieuPhat = maPhieuPhat;
        this.maSach = maSach;
        this.maThanhVien = maThanhVien;
        this.maPhieuMuon = maPhieuMuon;
        this.maQuyDinh = maQuyDinh;
        this.ngayPhat = ngayPhat;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public PhieuPhat() {
    }

    public int getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(int maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaQuyDinh() {
        return maQuyDinh;
    }

    public void setMaQuyDinh(int maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }

    public String getNgayPhat() {
        return ngayPhat;
    }

    public void setNgayPhat(String ngayPhat) {
        this.ngayPhat = ngayPhat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "PhieuPhat{" +
                "maPhieuPhat=" + maPhieuPhat +
                ", maSach=" + maSach +
                ", maThanhVien=" + maThanhVien +
                ", maPhieuMuon=" + maPhieuMuon +
                ", maQuyDinh=" + maQuyDinh +
                ", ngayPhat='" + ngayPhat + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
