package DTO;

public class NhanVien {
    private String maNV;
    private int maViTri;
    private String password;
    private String hoLot;
    private String ten;
    private String sdt;
    private String email;
    private String diaChi;
    private String ngaylam;
    private String ngayNghi;

    public NhanVien(String maNV, int maViTri, String password, String hoLot, String ten, String sdt, String email, String diaChi, String ngaylam, String ngayNghi) {
        this.maNV = maNV;
        this.maViTri = maViTri;
        this.password = password;
        this.hoLot = hoLot;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaylam = ngaylam;
        this.ngayNghi = ngayNghi;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoLot() {
        return hoLot;
    }

    public void setHoLot(String hoLot) {
        this.hoLot = hoLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaylam() {
        return ngaylam;
    }

    public void setNgaylam(String ngaylam) {
        this.ngaylam = ngaylam;
    }

    public String getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(String ngayNghi) {
        this.ngayNghi = ngayNghi;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", maViTri=" + maViTri +
                ", password='" + password + '\'' +
                ", hoLot='" + hoLot + '\'' +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaylam='" + ngaylam + '\'' +
                ", ngayNghi='" + ngayNghi + '\'' +
                '}';
    }
}
