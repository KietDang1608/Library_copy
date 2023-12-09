package BUS;

import java.awt.*;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import CheckInfo.CheckTool;
import DAO.PhieuPhatDAO;
import DTO.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PhieuPhatBUS
{
    private static ArrayList<PhieuPhat> lstPp;
    private PhieuPhatDAO dao = new PhieuPhatDAO();
    PhieuPhat pp = new PhieuPhat();
    public PhieuPhatBUS()
    {
        lstPp = dao.readData();
    }

    public ArrayList<PhieuPhat> getLst()
    {
        return lstPp;
    }

    public void insertLst(PhieuPhat ct)
    {
        lstPp.add(ct);
        dao.insertData(ct);
    }
    public void updatedata(PhieuPhat p) {
        for(int i =0; i<= lstPp.size() ; i++) {
            if(p.getMaPhieuPhat()==(lstPp.get(i).getMaPhieuPhat())) {
                lstPp.set(i, p);
                dao.updateData(p);
                break;
            }
        }
    }

    //Kiểm tra mã phiếu phạt có bị trùng không
    public static Boolean checkID(int ma)
    {
        for(PhieuPhat ct: lstPp)
        {
            if(ct.getMaPhieuPhat()==ma) return false;
        }
        return true;
    }

    //kiểm tra mã sách có tồn tại chưa
    public static Boolean checkMaSach(int ma)
    {
        SachBUS busSach=new SachBUS();
        for(Sach sa:busSach.getLst())
        {
            if(sa.getMaSach()==ma) return true;
        }
        return false;
    }

    //Kiểm tra mã thành viên có tồn tại chưa
    public static Boolean checkMaTv(int ma)
    {
        ThanhVienBUS busTv=new ThanhVienBUS();
        for(ThanhVien Tv:busTv.getLst())
        {
            if(Tv.getMaThanhVien()==ma) return true;
        }
        return false;
    }

    //kiểm tra mã phiếu mượn có tồn tại chưa
    public static Boolean checkMaPhieuMuon(int ma)
    {
        PhieuMuonBUS busPm=new PhieuMuonBUS();
        for(PhieuMuon Pm:busPm.getLst())
        {
            if(Pm.getMaPhieu()==ma) return true;
        }
        return false;
    }

    //kiểm tra mã quy định có tồn tại chưa
    public static Boolean checkMaQd(int ma)
    {
        QuyDinhBUS busQd=new QuyDinhBUS();
        for(QuyDinh Qd:busQd.getLst())
        {
            if(Qd.getMaQuyDinh()==ma) return true;
        }
        return false;
    }
    public ArrayList<PhieuPhat> find(String cb, int txnhap) {
        ArrayList<PhieuPhat> phieuphatlist = new ArrayList<>();

        switch (cb) {
            case "Mã Phiếu Phạt":
                for (PhieuPhat pp : lstPp) {
                    if (pp.getMaPhieuPhat() == txnhap) {
                        phieuphatlist.add(pp);
                        break;
                    }
                }
                break;
            case "Mã Thành Viên":
                for (PhieuPhat pp : lstPp) {
                    if (pp.getMaThanhVien() == txnhap) {
                        phieuphatlist.add(pp);
                    }
                }
                break;
            case "Mã Phiếu Mượn":
                for (PhieuPhat pp : lstPp) {
                    if (pp.getMaPhieuMuon() == txnhap) {
                        phieuphatlist.add(pp);
                    }
                }
                break;
        }

        return phieuphatlist;
    }
    public int getTienPhat(int maSach,int maQuyDinh){
        QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
        PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
        CT_PhieuNhapBUS ct_phieuNhapBUS = new CT_PhieuNhapBUS();

        int giaSach = 0;
        int giaPhat = 0;

        for (CT_PhieuNhap ct_phieuNhap : ct_phieuNhapBUS.getLst()){
            if (maSach == ct_phieuNhap.getMaSach()){
                giaSach = ct_phieuNhap.getDonGia();
                break;
            }
        }
        for (QuyDinh quyDinh: quyDinhBUS.getLst()){
            if (quyDinh.getMaQuyDinh() == maQuyDinh){
                giaPhat = giaSach * quyDinh.getTienPhat()/100;
                break;
            }
        }
        return giaPhat;
    }
    public PhieuPhat getPPByID(int id){
        PhieuPhat pp = new PhieuPhat();
        for (PhieuPhat phieuPhat:lstPp){
            if (id == phieuPhat.getMaPhieuPhat()){
                pp = phieuPhat;
            }
        }
        return pp;
    }
    public void inPhieuPhat(PhieuPhat pp) {
        CheckTool checkTool = new CheckTool();
        String filename="src/PDF/PhieuPhat.pdf";
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (DocumentException e1){
            e1.printStackTrace();
        }
        com.itextpdf.text.Font head = FontFactory.getFont(FontFactory.TIMES_ROMAN, 30, Font.BOLD);
        com.itextpdf.text.Font base = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.ITALIC);

        Paragraph para=new Paragraph("PHIEU PHAT",head);
        try {
            para.setAlignment(1);

            document.add(para);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }

        String s2="<=========================++++++=========================>";
        para=new Paragraph(s2);
        try {
            para.setAlignment(1);

            document.add(para);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        String s4="\n";
        para=new Paragraph(s4);
        try {
            document.add(para);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            document.add(new Paragraph(" "));
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        SachBUS sachBUS = new SachBUS();
        QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
        String line = "\n______________________________________________________________________________\n";
        String maPhieuPhat =line + "Ma phieu phat: " +String.valueOf(pp.getMaPhieuPhat());
        String maPhieuMuon = line + "Ma phieu muon: " + String.valueOf(pp.getMaPhieuMuon());
        String maSach = line + "Ma sach: " + String.valueOf(pp.getMaSach());
        String tenSach = checkTool.convertVietnameseString(sachBUS.getSachByID(pp.getMaSach()).getTenSach());
        tenSach = line +"Ten sach: " +tenSach;
        String maThanhVien = line + "Ma thanh vien: " + String.valueOf(pp.getMaThanhVien());
        String tenThanhVien = checkTool.convertVietnameseString(thanhVienBUS.getTVByID(pp.getMaThanhVien()).getHoLot() + " " +thanhVienBUS.getTVByID(pp.getMaThanhVien()).getTen());
        tenThanhVien = line + "Ten thanh vien: " + tenThanhVien;
        String maQuyDinh = line + "Ma quy dinh: " + String.valueOf(pp.getMaQuyDinh());
        String noiDungQuyDinh = checkTool.convertVietnameseString(quyDinhBUS.getQuyDinhByID(pp.getMaQuyDinh()).getTenQuyDinh());
        noiDungQuyDinh = line + "Noi dung: " + noiDungQuyDinh;
        String ngayPhat = line + "Ngay phat: " + pp.getNgayPhat();
        String trangThai = line + "Trang thai: " + (pp.getTrangThai().equals("true")?"Da nop phat":"Chua nop phat");
        String moTa = line + "Mo ta: " +pp.getMoTa();

        String info = maPhieuPhat  + maPhieuMuon +maSach +tenSach +maThanhVien +tenThanhVien+maQuyDinh+noiDungQuyDinh+ngayPhat+trangThai+moTa;
        para = new Paragraph(info);
        try {
            document.add(para);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String tong ="\n"+ line+ "Tong: "+ getTienPhat(pp.getMaSach(),pp.getMaQuyDinh()) + " VND" + line;

        para = new Paragraph(tong);
        try {
            para.setAlignment(2);
            document.add(para);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        document.close();
        try{
            openPdfFile(filename);
        }catch (IOException e){};

    }
    public void openPdfFile(String pdfFilePath) throws IOException {
        // Tạo một đối tượng File để đại diện cho tệp PDF
        File pdfFile = new File(pdfFilePath);

        // Kiểm tra xem Desktop được hỗ trợ không
        if (Desktop.isDesktopSupported()) {
            // Lấy đối tượng Desktop
            Desktop desktop = Desktop.getDesktop();

            // Kiểm tra xem tệp PDF có tồn tại không
            if (pdfFile.exists()) {
                // Mở tệp PDF bằng ứng dụng mặc định trên hệ thống
                desktop.open(pdfFile);
            } else {
                System.out.println("PDF file does not exist.");
            }
        } else {
            System.out.println("Desktop is not supported.");
        }
    }
}