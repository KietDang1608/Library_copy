package DTO;

public class QuyDinh {
    private int maQuyDinh;
    private String tenQuyDinh;
    private int tienPhat;

    public QuyDinh(int maQuyDinh, String tenQuyDinh, int tienPhat) {
        this.maQuyDinh = maQuyDinh;
        this.tenQuyDinh = tenQuyDinh;
        this.tienPhat = tienPhat;
    }

    public QuyDinh() {
    }

    public int getMaQuyDinh() {
        return maQuyDinh;
    }

    public void setMaQuyDinh(int maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }

    public String getTenQuyDinh() {
        return tenQuyDinh;
    }

    public void setTenQuyDinh(String tenQuyDinh) {
        this.tenQuyDinh = tenQuyDinh;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    @Override
    public String toString() {
        return "QuyDinh{" +
                "maQuyDinh=" + maQuyDinh +
                ", tenQuyDinh='" + tenQuyDinh + '\'' +
                ", tienPhat=" + tienPhat +
                '}';
    }
}
