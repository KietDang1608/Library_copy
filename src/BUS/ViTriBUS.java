package BUS;
import DAO.ViTriDAO;
import DTO.ViTri;

import java.util.ArrayList;

public class ViTriBUS {
    private  ArrayList<ViTri> dsViTri;
    public ViTriBUS(){
        ViTriDAO dao = new ViTriDAO();
        dsViTri = dao.readData();
    }

    public  ArrayList<ViTri> getdsViTri() {
        return dsViTri;
    }
}
