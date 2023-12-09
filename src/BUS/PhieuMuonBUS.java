package BUS;

import java.awt.*;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import CheckInfo.CheckTool;
import DAO.phieu_muonDAO;
import DTO.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.text.TextAlignment;

import javax.swing.table.DefaultTableModel;

public class PhieuMuonBUS
{
    private ArrayList<PhieuMuon> lstPm;
    private phieu_muonDAO dao = new phieu_muonDAO();

    public PhieuMuonBUS()
    {
        lstPm = dao.readData();
    }

    public ArrayList<PhieuMuon> getLst()
    {
        return lstPm;
    }

    public void insertLst(PhieuMuon ct)
    {
        lstPm.add(ct);
        dao.insertData(ct);
    }

    //Kiểm tra mã phiếu mượn có trùng không
    public Boolean checkID(int ma)
    {
        for(PhieuMuon ct: lstPm)
        {
            if(ct.getMaPhieu()==ma) return false;
        }
        return true;
    }

    //Kiểm tra mã nhân viên có tồn tại chưa
    public Boolean checkMaNv(String ma)
    {
        NhanVienBUS busNv=new NhanVienBUS();
        for(NhanVien Nv:busNv.getLst())
        {
            if(Nv.getMaNV().equals(ma)) return true;
        }
        return false;
    }

    //Kiểm tra mã thành viên có tồn tại chưa
    public Boolean checkMaTv(int ma)
    {
        ThanhVienBUS busTv=new ThanhVienBUS();
        for(ThanhVien Tv:busTv.getLst())
        {
            if(Tv.getMaThanhVien()==ma) return true;
        }
        return false;
    }
    public PhieuMuon getPMByID(int id){
        PhieuMuon pm = new PhieuMuon();
        for (PhieuMuon phieuMuon:lstPm){
            if (phieuMuon.getMaPhieu() == id){
                pm = phieuMuon;
                break;
            }
        }
        return pm;
    }
    public void updateData(PhieuMuon pm){
        for (int i = 0;i<lstPm.size();i++){
            if (pm.getMaPhieu() == lstPm.get(i).getMaPhieu()){
                lstPm.set(i,pm);
                dao.updateData(pm);
                break;
            }
        }
    }
    public ArrayList<PhieuMuon> timKiem(String item, String data){
        ArrayList<PhieuMuon> founds = new ArrayList<>();
        switch (item){
            case "Mã phiếu mượn":
                for (PhieuMuon phieuMuon : lstPm){
                    if (String.valueOf(phieuMuon.getMaPhieu()).equals(data)){
                        founds.add(phieuMuon);
                        break;
                    }
                }
                break;
            case "Mã thành viên":
                for (PhieuMuon phieuMuon : lstPm){
                    if (String.valueOf(phieuMuon.getMaThanhVien()).equals(data)){
                        founds.add(phieuMuon);
                        break;
                    }
                }
                break;
            case "Mã nhân viên":
                for (PhieuMuon phieuMuon : lstPm){
                    if (phieuMuon.getMaNV().contains(data)){
                        founds.add(phieuMuon);
                    }
                }
                break;
        }
        return founds;
    }
    public void inPhieuMuon(PhieuMuon pm) {
        CT_PhieuMuonBUS ct_phieuMuonBUS = new CT_PhieuMuonBUS();
        String fontPath = "path/to/your/VnArial.ttf";

        // Tạo một đối tượng PdfFont từ font Unicode
        CheckTool checkTool = new CheckTool();
        String filename="src/PDF/PhieuMuon.pdf";
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

        Paragraph para=new Paragraph("PHIEU MUON",head);
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
        PdfPTable PDFtable= new PdfPTable(2);

        PDFtable.setTotalWidth(500);
        PDFtable.setLockedWidth(true);

        PdfPCell c1=new PdfPCell(new Phrase("MA SACH",base));
        PDFtable.addCell(c1);
        c1=new PdfPCell(new Phrase("TEN SACH", base));
        PDFtable.addCell(c1);

        PDFtable.setHeaderRows(1);

        SachBUS sachBUS = new SachBUS();
        for (CT_PhieuMuon ct_phieuMuon:ct_phieuMuonBUS.getLst()){
            if (ct_phieuMuon.getMaPhieu()==pm.getMaPhieu()){
                PDFtable.addCell(String.valueOf(ct_phieuMuon.getMaSach()));
                String tenSach = checkTool.convertVietnameseString(sachBUS.getSachByID(ct_phieuMuon.getMaSach()).getTenSach());
                PDFtable.addCell(tenSach);
            }
        }
        para=new Paragraph(s4);

        try {
            document.add(para);
            document.add(PDFtable);
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
        String line = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
        String maPhieu =line + "Ma phieu: " +String.valueOf(pm.getMaPhieu());
        String maTV =line + "Ma thanh vien: " +String.valueOf(pm.getMaThanhVien());
        String tenTV = line +"Ten thanh vien: " +thanhVienBUS.getTVByID(pm.getMaThanhVien()).getHoLot() + " " + thanhVienBUS.getTVByID(pm.getMaThanhVien()).getTen();
        tenTV = checkTool.convertVietnameseString(tenTV);
        String maNhanVien =line + "Ma nhan vien: " +pm.getMaNV();
        String ngayMuon =line +"Ngay muon: " + pm.getNgayMuon();
        String ngayHan =line + "Ngay han: " +pm.getNgayHan();
        String ngayTra = line +"Ngay tra: " +pm.getNgayTra();

        String info = maPhieu+"\n"+maTV+"\n"+tenTV+"\n"+maNhanVien+"\n"+ngayMuon+"\n"+ngayHan+"\n"+ngayTra+"\n"+line;
        para = new Paragraph(info);
        try {
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