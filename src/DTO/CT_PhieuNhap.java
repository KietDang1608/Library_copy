package DTO;

public class CT_PhieuNhap {
    private int maPhieu;
    private int maSach;
    private int soLuong;
    private int donGia;

    public CT_PhieuNhap(int maPhieu, int maSach, int soLuong, int donGia) {
        this.maPhieu = maPhieu;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public CT_PhieuNhap() {
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "CT_PhieuNhap{" +
                "maPhieu=" + maPhieu +
                ", maSach=" + maSach +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
