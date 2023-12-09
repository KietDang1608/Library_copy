package DTO;

public class ThanhVien {
    private int maThanhVien;
    private String hoLot;
    private String ten;
    private String sdt;
    private String email;
    private String diaChi;
    private String ngayTao;
    private String hanThe;

    public ThanhVien(int maThanhVien, String hoLot, String ten, String sdt, String email, String diaChi,String ngayTao ,String hanThe) {
        this.maThanhVien = maThanhVien;
        this.hoLot = hoLot;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayTao=ngayTao;
        this.hanThe = hanThe;
    }

    public ThanhVien() {
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getHanThe() {
        return hanThe;
    }

    public void setHanThe(String hanThe) {
        this.hanThe = hanThe;
    }

    @Override
    public String toString() {
        return "ThanhVien{" +
                "maThanhVien=" + maThanhVien +
                ", hoLot='" + hoLot + '\'' +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", hanThe='" + hanThe + '\'' +
                '}';
    }
}
