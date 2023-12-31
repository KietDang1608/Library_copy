package DTO;
import java.util.ArrayList;
import java.util.List;

public class ViTri {
    private int maViTri;
    private String tenViTri;


    // Constructors, getters, and setters

    public ViTri() {

    }

    public ViTri(int maViTri, String tenViTri) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
    }



    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    @Override
    public String toString() {
        return "ViTri{" +
                "maViTri=" + maViTri +
                ", tenViTri='" + tenViTri + '\'' +
                '}';
    }
}
