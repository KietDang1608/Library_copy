package DTO;

public class PhieuNhap {
    private int PhieuNhap;
    private int maNCC;
    private String maNV;
    private String ngayNhap;

    public PhieuNhap(int phieuNhap, int maNCC, String maNV, String ngayNhap) {
        this.PhieuNhap = phieuNhap;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
    }

    public PhieuNhap() {
    }

    public int getPhieuNhap() {
        return PhieuNhap;
    }

    public void setPhieuNhap(int phieuNhap) {
        PhieuNhap = phieuNhap;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" +
                "PhieuNhap=" + PhieuNhap +
                ", maNCC=" + maNCC +
                ", maNV='" + maNV + '\'' +
                ", ngayNhap='" + ngayNhap + '\'' +
                '}';
    }
}
