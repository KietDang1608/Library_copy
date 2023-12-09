package BUS;


import DAO.LoginDAO;
import DTO.NhanVien;

public class LoginBUS {
    private String username;
    private LoginDAO dao = new LoginDAO();
    private NhanVienBUS nhanVienBUS = new NhanVienBUS();
    public LoginBUS(){
        username = dao.getUsername();
    }
    public void setLogin(String s){
        dao.deleteData();
        dao.insertData(s);
    }
    public String getLoginName(){
        String s = "";
        for (NhanVien nhanVien: nhanVienBUS.getLst()){
            if (nhanVien.getMaNV().equals(username)){
                s= nhanVien.getHoLot() + " " + nhanVien.getTen();
            }
        }
        return s;
    }
    public String getUsername(){
        return username;
    }
    public boolean checkWorking(String s){
        try {
            for (NhanVien nhanVien : nhanVienBUS.getLst()) {
                if (nhanVien.getMaNV().equals(s)) {
                    System.out.println(nhanVien.getNgayNghi());
                    if (nhanVien.getNgayNghi() != null || nhanVien.getNgayNghi().length() != 0) {
                        return false;
                    }
                }
            }
        }catch (NullPointerException e){}
        return true;
    }
}
