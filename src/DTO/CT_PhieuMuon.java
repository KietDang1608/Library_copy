package DTO;

public class CT_PhieuMuon {
    private int maPhieu;
    private int maSach;

    public CT_PhieuMuon(int maPhieu, int maSach) {
        this.maPhieu = maPhieu;
        this.maSach = maSach;
    }

    public CT_PhieuMuon() {
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

    @Override
    public String toString() {
        return "CT_PhieuMuon{" +
                "maPhieu=" + maPhieu +
                ", maSach=" + maSach +
                '}';
    }
}
