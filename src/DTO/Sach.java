package DTO;

public class Sach {
    private int maSach;
    private int maLoai;
    private String tenSach;
    private String imgPath;
    private String tacGia;
    private String nhaXuatBan;
    private String ngayXuatBan;
    private int soLuong;

    public Sach(int maSach, int maLoai, String tenSach, String imgPath, String tacGia, String nhaXuatBan, String ngayXuatBan, int soLuong) {
        this.maSach = maSach;
        this.maLoai = maLoai;
        this.tenSach = tenSach;
        this.imgPath = imgPath;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.ngayXuatBan = ngayXuatBan;
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "maSach=" + maSach +
                ", maLoai=" + maLoai +
                ", tenSach='" + tenSach + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                ", ngayXuatBan='" + ngayXuatBan + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
    public String getSachPath(){
        return "src/IMG/BookIMG/" + this.getImgPath();
    }
}
