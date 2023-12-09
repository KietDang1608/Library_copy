package GUI;

import java.awt.*;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import CheckInfo.CheckTool;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;


import BUS.ThongKeBUS;
import DTO.CT_PhanQuyen;
import DTO.PhieuMuon;

import java.sql.SQLException;

public class ThongKeGUI extends JFrame
{
    JButton btThongKe,btPdf;
    JPanel panel;
    JTable table;
    JLabel lblTitle,lblSach,lblDocgia,lblPhat;
    private Font font = new Font("Tahoma",Font.PLAIN,20);
    private Font font2 = new Font("Tahoma",Font.BOLD,30);
    com.itextpdf.text.Font head = FontFactory.getFont(FontFactory.TIMES_ROMAN, 15,Font.BOLD);
    com.itextpdf.text.Font base = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.ITALIC);
    DefaultTableModel model = new DefaultTableModel();
    private String[] years = {"2023", "2022", "2021", "2020", "2019", "2018"};

    String MaxBookYear="a";
    double PhatYear=0;
    int TheYear=0;

    //các mảng public để tính dữ liệu trong từng tháng
    public int[] MaxBookOfMonth;//mảng chứa số lượng sách của cuốn sách
    //mượn nhiều nhất theo từng tháng
    public int[] BookOfMonth;//mảng chứa số lượng sách được mượn trong từng tháng

    private JComboBox<String> yearComboBox = new JComboBox<>(years);
    public ThongKeGUI()
    {
        setBounds(0, 0, 1300, 750);
        setResizable(false);
        setLayout(null);
        panel=new JPanel();

        panel.setLayout(null);
        setContentPane(panel);
        // frame.add(panel);


        //tạo giao diện
        btThongKe=new JButton("Thống kê");
        btThongKe.setBounds(600, 50, 200, 30);
        btThongKe.setBackground(new Color(33, 115, 70));
        btThongKe.setFont(font);
        btThongKe.setForeground(Color.white);
        btThongKe.setIcon(new ImageIcon("src/IMG/anh/update.png"));
        panel.add(btThongKe);

        btPdf=new JButton("In PDF");
        btPdf.setFont(font);

        btPdf.setBounds(300, 220, 150, 30);
        btPdf.setBackground(new Color(33, 115, 70));
        btPdf.setForeground(Color.white);
        btPdf.setIcon(new ImageIcon("src/IMG/anh/update.png"));
        panel.add(btPdf);

        yearComboBox.setBounds(500, 50, 100, 30);
        yearComboBox.setFont(font);
        yearComboBox.setSelectedIndex(0);
        panel.add(yearComboBox);

        JPanel pntitle = new JPanel();
        pntitle.setBounds(0,0,1300,50);
        pntitle.setBackground(new  Color(33, 115, 70));

        lblTitle=new JLabel("THỐNG KÊ");
        lblTitle.setForeground(Color.white);


        lblTitle.setFont(font2);
        pntitle.add(lblTitle);
        panel.add(pntitle);
        lblSach=new JLabel("Sách được mượn nhiều nhất: ",JLabel.LEFT);
        lblSach.setBounds(300, 133, 500,24);
        lblSach.setFont(font);
        panel.add(lblSach);
        lblDocgia=new JLabel("Đọc giả đăng ký trong năm: ",JLabel.LEFT);
        lblDocgia.setBounds(300, 160, 340,24);
        lblDocgia.setFont(font);
        panel.add(lblDocgia);
        lblPhat=new JLabel("Tiền phạt thu được nhiều nhất: ",JLabel.LEFT);
        lblPhat.setBounds(300, 185, 400,24);
        lblPhat.setFont(font);
        panel.add(lblPhat);

        //table


        table = new JTable()
        {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Tháng");
        nModel.addColumn("Sách được mượn");
        nModel.addColumn("Số lần mượn");
        nModel.addColumn("Số sách được mượn");
        nModel.addColumn("Tiền phạt");
        nModel.addColumn("Đọc giả đăng ký");
        table.setFont(font);
        table.setRowHeight(30);
        // table.setModel(nModel);

        // nModel.setRowCount(0);
        for(int i=1;i<=12;i++)
        {
            Vector row= new Vector();
            row.add("tháng "+i);
            nModel.addRow(row);
            // table.setModel(nModel);
        }
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBounds(100, 270, 1100, 30);
        table.setModel(nModel);
        table.setRowHeight(30);
        table.setBounds(100, 300, 1100, 360);

        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));


        panel.add(tableHeader);
        panel.add(table);
        // frame.revalidate();
        // frame.repaint();


        btThongKe.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MaxBookYear="";
                PhatYear=0;
                TheYear=0;

                //các mảng public để tính dữ liệu trong từng tháng
                MaxBookOfMonth=new int[12];//mảng chứa số lượng sách của cuốn sách
                //mượn nhiều nhất theo từng tháng
                BookOfMonth=new int[12];//mảng chứa số lượng sách được mượn trong từng tháng
                ThongKeBUS tk=new ThongKeBUS();
                MaxBookOfMonth=new int[12];
                BookOfMonth=new int[12];
                String MaxOfEachMonth[]=tk.tkSach((String) yearComboBox.getSelectedItem(),MaxBookOfMonth,BookOfMonth);
                double PhatOfMonth[]=tk.tkPhat((String) yearComboBox.getSelectedItem());
                int TheOfMonth[]=tk.tkThe((String) yearComboBox.getSelectedItem());
                //  nModel.setRowCount(0);
                for(int i=1;i<=12;i++)
                {
                    nModel.setValueAt(MaxOfEachMonth[i-1],i-1, 1);
                    nModel.setValueAt(MaxBookOfMonth[i-1],i-1, 2);
                    nModel.setValueAt(BookOfMonth[i-1],i-1, 3);
                    nModel.setValueAt((int)PhatOfMonth[i-1],i-1, 4);
                    nModel.setValueAt(TheOfMonth[i-1],i-1, 5);
                }
                int max=0;

                for(int i=0;i<12;i++)
                {
                    if(max<MaxBookOfMonth[i])
                    {
                        max=MaxBookOfMonth[i];
                        MaxBookYear=MaxOfEachMonth[i];
                    }
                    PhatYear+=PhatOfMonth[i];
                    TheYear+=TheOfMonth[i];
                    // if(MaxFeeYear<PhatOfMonth[i])MaxFeeYear=PhatOfMonth[i];
                }
                lblSach.setText("Sách được mượn nhiều nhất: "+MaxBookYear);
                lblPhat.setText("Tiền phạt thu được trong năm: "+(int)PhatYear);
                lblDocgia.setText("Đọc giả đăng ký trong năm: "+TheYear);
            }
        }) ;
        btThongKe.doClick();

        btPdf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String filename="src/GUI/test.pdf";
                Document document= new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(filename));
                    document.open();

                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                // qry= "select  maPhieu,maHang,soLuong,donGia,thanhTien from ct_phieu_nhap where maPhieu=?";
                // stmt=c.prepareStatement(qry);
                // stmt.setString(1, maphieu);
                // stmt.execute();
                // rs=stmt.executeQuery();

                Paragraph para=new Paragraph("THONG KE ",head);
                try {
                    para.setAlignment(1);
                    document.add(para);
                } catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                String s2="<================================++++++=================================>";
                String s4="\r\n"+s2+"\r\n"+"\r\n"+"\r\n";
                PdfPTable PDFtable= new PdfPTable(6);

                PDFtable.setTotalWidth(500);
                PDFtable.setLockedWidth(true);

                PdfPCell c1=new PdfPCell(new Phrase("THANG",base));
                PDFtable.addCell(c1);
                c1=new PdfPCell(new Phrase("SACH DUOC MUON", base));
                PDFtable.addCell(c1);
                c1=new PdfPCell(new Phrase("SO LAN MUON",base));
                PDFtable.addCell(c1);
                c1=new PdfPCell(new Phrase("SO SACH DUOC MUON",base));
                PDFtable.addCell(c1);
                c1=new PdfPCell(new Phrase("TIEN PHAT",base));
                PDFtable.addCell(c1);
                c1=new PdfPCell(new Phrase("DOC GIA DANG KY",base));
                PDFtable.addCell(c1);
                PDFtable.setHeaderRows(1);
                CheckTool checkTool = new CheckTool();
                DefaultTableModel mo=  (DefaultTableModel) table.getModel();
                for(int i=0;i<12;i++)
                {
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 0).toString()));
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 1).toString()));
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 2).toString()));
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 3).toString()));
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 4).toString()));
                    PDFtable.addCell(checkTool.convertVietnameseString(mo.getValueAt(i, 5).toString()));
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
                String nam="Nam: "+yearComboBox.getSelectedItem().toString();
                String sach="Sach duoc muon nhieu nhat:"+MaxBookYear;
                String docgia="Tien phat thu duoc trong nam:"+(int)PhatYear;
                String tienphat="Doc gia dang ky trong nam: "+TheYear;
                String s5=checkTool.convertVietnameseString(nam+"\r\n"+"\r\n"+s2+"\r\n"+ sach+"\r\n"+docgia+"\r\n"+tienphat+"\r\n");
                para=new Paragraph(s5);
                try {
                    document.add(para);
                } catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                document.close();




            }
        });

    }
    public static void main(String[] args) {
        new ThongKeGUI().setVisible(true);
    }
}
