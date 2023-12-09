package DTO;
import java.util.ArrayList;
import java.util.List;

public class CT_PhanQuyen {
    private int maQuyen;
    private int maViTri;


    private List<Integer> maQuyenList;


    // Constructors, getters, and setters

    public CT_PhanQuyen() {
        this.maQuyenList = new ArrayList<>();
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public List<Integer> getMaQuyenList() {
        return maQuyenList;
    }

    public void addMaQuyen(int maQuyen) {
        this.maQuyenList.add(maQuyen);
    }




    public CT_PhanQuyen(int maQuyen, int maViTri) {
        this.maQuyen = maQuyen;
        this.maViTri = maViTri;
    }


    public int getMaQuyen() {
        return maQuyen;
    }
    public String getTenQuyen() {

        return null;

    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }


    @Override
    public String toString() {
        return "CT_PhanQuyen{" +
                "maQuyen=" + maQuyen +
                ", maViTri=" + maViTri +
                '}';
    }
}
