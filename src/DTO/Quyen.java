package DTO;
public class Quyen {

    private int maQuyen;
    private String tenQuyen;

    public Quyen(int maQuyen, String tenQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
    }

    public Quyen() {
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    @Override
    public String toString() {
        return "Quyen{" +
                "maQuyen=" + maQuyen +
                ", tenQuyen='" + tenQuyen + '\'' +
                '}';
    }
}
