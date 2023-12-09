package GUI;

import BUS.CT_PhieuMuonBUS;
import BUS.PhieuMuonBUS;
import BUS.SachBUS;
import BUS.ThanhVienBUS;
import DTO.*;
import com.toedter.calendar.JCalendar;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class PhieuMuonGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txTim = new JTextField();
    private JTextField txMaPhieu= new JTextField();
    private JTextField txMaTV= new JTextField();
    private JTextField txTenTV= new JTextField();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JTextField txMaNV= new JTextField();
    private JTextField txNgayMuon= new JTextField();
    private JTextField txNgayHan= new JTextField();
    private JTextField txNgayTra= new JTextField();
    private JButton btnTim = new JButton("");
    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnChonNgay = new JButton("");
    private JButton btnXacNhan = new JButton("");
    private JButton btnHuy = new JButton("");
    private JTable tbCT = new JTable();
    private JScrollPane scrollPane2 = new JScrollPane(tbCT);
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhieuMuonGUI frame = new PhieuMuonGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PhieuMuonGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 1266, 62);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblPhiuMn = new JLabel("PHIẾU MƯỢN");
        lblPhiuMn.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhiuMn.setForeground(Color.WHITE);
        lblPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblPhiuMn.setBackground(new Color(33, 115, 70));
        panel.add(lblPhiuMn);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);

        JLabel lbTim = new JLabel("Tìm theo:");
        lbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTim.setBounds(808, 10, 111, 30);
        pnInfo.add(lbTim);

        JComboBox cbTim = new JComboBox();
        cbTim.addItem("Mã phiếu mượn");
        cbTim.addItem("Mã thành viên");
        cbTim.addItem("Mã nhân viên");
        cbTim.setSelectedIndex(0);
        cbTim.setBounds(907, 10, 349, 30);
        pnInfo.add(cbTim);

        txTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTim.setColumns(10);
        txTim.setBounds(808, 86, 397, 30);
        pnInfo.add(txTim);

        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(1205, 86, 51, 30);
        pnInfo.add(btnTim);
        btnTim.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = String.valueOf(cbTim.getSelectedItem());
                String data = txTim.getText();
                PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
                addDBToTablePM(phieuMuonBUS.timKiem(item,data));
            }
        });
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(1137, 160, 119, 30);
        btnThem.setForeground(Color.white);
        pnInfo.add(btnThem);


        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        btnSua.setBounds(1008, 160, 119, 30);
        btnSua.setBackground(new Color(242, 238, 157));
        pnInfo.add(btnSua);

        JButton btnPdf = new JButton("In PDF");
        btnPdf.setIcon(new ImageIcon("src/IMG/anh/update.png"));
        btnPdf.setBackground(Color.orange);
        btnPdf.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPdf.setBounds(1008, 120, 119, 30);
        pnInfo.add(btnPdf);
        btnPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Hãy chọn một phiếu mượn để in PDF!");
                }
                else {
                    int maPhieu = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
                    PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
                    PhieuMuon pm = phieuMuonBUS.getPMByID(maPhieu);
                    phieuMuonBUS.inPhieuMuon(pm);
                }
            }
        });

        JLabel lbMaPhieu = new JLabel("Mã phiếu mượn:");
        lbMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaPhieu.setBounds(10, 10, 160, 30);
        pnInfo.add(lbMaPhieu);

        JLabel lbThanhVien = new JLabel("Thành viên:");
        lbThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbThanhVien.setBounds(10, 46, 160, 30);
        pnInfo.add(lbThanhVien);

        txMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaPhieu.setColumns(10);
        txMaPhieu.setBounds(180, 11, 69, 29);
        pnInfo.add(txMaPhieu);

        txMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaTV.setColumns(10);
        txMaTV.setBounds(180, 47, 51, 29);
        pnInfo.add(txMaTV);

        txTenTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenTV.setColumns(10);
        txTenTV.setBounds(241, 47, 226, 29);
        pnInfo.add(txTenTV);

        JLabel lbNhanVien = new JLabel("Mã nhân viên:");
        lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNhanVien.setBounds(10, 86, 160, 30);
        pnInfo.add(lbNhanVien);

        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setColumns(10);
        txMaNV.setBounds(180, 86, 226, 29);
        pnInfo.add(txMaNV);

        JLabel lbNgayMuon = new JLabel("Ngày mượn:");
        lbNgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayMuon.setBounds(10, 126, 160, 30);
        pnInfo.add(lbNgayMuon);

        JLabel lbNgayHan = new JLabel("Ngày hạn:");
        lbNgayHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayHan.setBounds(10, 160, 160, 30);
        pnInfo.add(lbNgayHan);

        txNgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayMuon.setColumns(10);
        txNgayMuon.setBounds(180, 127, 226, 29);
        pnInfo.add(txNgayMuon);

        txNgayHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayHan.setColumns(10);
        txNgayHan.setBounds(180, 160, 151, 29);
        pnInfo.add(txNgayHan);

        JLabel lbNgayTra = new JLabel("Ngày trả:");
        lbNgayTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayTra.setBounds(341, 160, 95, 30);
        pnInfo.add(lbNgayTra);

        txNgayTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayTra.setColumns(10);
        txNgayTra.setBounds(489, 161, 151, 29);
        pnInfo.add(txNgayTra);


        btnChonNgay.setBounds(446, 160, 43, 30);
        btnChonNgay.setIcon(new ImageIcon("src/IMG/anh/calendar.png"));
        pnInfo.add(btnChonNgay);


        btnXacNhan.setBounds(907, 160, 91, 30);
        btnXacNhan.setBackground(new Color(210, 224, 251));
        btnXacNhan.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        pnInfo.add(btnXacNhan);

        btnHuy.setBounds(808, 160, 91, 30);
        btnHuy.setBackground(new Color(140, 51, 51));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        pnInfo.add(btnHuy);

        scrollPane.setBounds(10, 292, 689, 411);
        contentPane.add(scrollPane);
        scrollPane2.setBounds(709, 292, 567, 411);

        contentPane.add(scrollPane2);
        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        addDBToTablePM(phieuMuonBUS.getLst());
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBackground(new Color(131, 162, 255));
        btnRefresh.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        pnInfo.add(btnRefresh);
        btnRefresh.setBounds(1137, 120, 119, 30);
        btnRefresh.setFont(new Font("Tahoma",0,15));

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhieuMuonBUS phieuMuonBUS1 = new PhieuMuonBUS();
                addDBToTablePM(phieuMuonBUS1.getLst());
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPhieuMuon formPhieuMuon = new FormPhieuMuon();
                formPhieuMuon.setVisible(true);
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDBToTableCT();
            }
        });
        turnOffEdit();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setData();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOnEdit();
            }
        });
        turnOffEdit();
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOffEdit();
            }
        });
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
        btnChonNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo khung lịch
                JCalendar calendar = new JCalendar();
                // Lấy ngày hiện tại
                Calendar currentDate = Calendar.getInstance();
                // Chuyển đổi đối tượng Calendar thành đối tượng Date
                Date date = currentDate.getTime();
                // Đặt ngày hiện tại cho khung lịch
                calendar.setDate(date);

                // Tạo dialog để hiển thị khung lịch

                // Tạo hộp thoại
                JDialog dialog = new JDialog();

                // Đặt mô hình cho hộp thoại
                dialog.setModal(true);
                dialog.getContentPane().add(calendar);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(contentPane);
                dialog.setVisible(true);

                // Lấy ngày tháng năm đã chọn
                int year = calendar.getCalendar().get(Calendar.YEAR);
                int month = calendar.getCalendar().get(Calendar.MONTH);
                int day = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);

                // Hiển thị ngày tháng năm đã chọn lên JTextField
                if (month > 9)
                    if (day > 9)
                        txNgayTra.setText(String.format("%d-%d-%d", year, month + 1, day));
                    else txNgayTra.setText(String.format("%d-%d-0%d", year, month + 1, day));
                else {
                    if (day > 9){
                        txNgayTra.setText(String.format("%d-%d-%d", year, month + 1, day));
                    }
                    else txNgayTra.setText(String.format("%d-0%d-0%d", year, month + 1, day));
                }
            }
        });
    }
    private void addDBToTablePM(ArrayList<PhieuMuon> phieuMuons){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã phiếu");
        nModel.addColumn("Mã thành viên");
        nModel.addColumn("Mã nhân viên");
        nModel.addColumn("Ngày mượn");
        nModel.addColumn("Ngày trả");
        nModel.addColumn("Ngày hạn");

        for (PhieuMuon phieuMuon:phieuMuons){
            Vector data = new Vector<>();
            data.add(phieuMuon.getMaPhieu());
            data.add(phieuMuon.getMaThanhVien());
            data.add(phieuMuon.getMaNV());
            data.add(phieuMuon.getNgayMuon());
            data.add(phieuMuon.getNgayTra());
            data.add(phieuMuon.getNgayHan());

            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",0,15));
        table.setRowHeight(30);
    }
    public void addDBToTableCT(){
        int row = table.getSelectedRow();
        if (row >= 0) {
            int maPhieu = Integer.parseInt(String.valueOf(table.getValueAt(row,0)));
            CT_PhieuMuonBUS ct_phieuMuonBUS = new CT_PhieuMuonBUS();
            SachBUS sachBUS = new SachBUS();
            DefaultTableModel nModel = new DefaultTableModel();
            nModel.addColumn("Mã phiếu");
            nModel.addColumn("Mã sách");
            nModel.addColumn("Tên sách");

            for (CT_PhieuMuon ct : ct_phieuMuonBUS.getLst()) {
                if (ct.getMaPhieu() == maPhieu) {
                    Vector data = new Vector<>();
                    Sach sach = sachBUS.getSachByID(ct.getMaSach());
                    data.add(String.valueOf(maPhieu));
                    data.add(String.valueOf(sach.getMaSach()));
                    data.add(String.valueOf(sach.getTenSach()));
                    nModel.addRow(data);
                }
            }
            tbCT.setModel(nModel);
            tbCT.setFont(new Font("Tahoma", 0, 15));
            tbCT.setRowHeight(30);
        }
    }
    public void turnOffEdit(){
        txMaPhieu.setEditable(false);
        txMaTV.setEditable(false);
        txTenTV.setEditable(false);
        txMaNV.setEditable(false);
        txNgayMuon.setEditable(false);
        txNgayHan.setEditable(false);
        txNgayTra.setEditable(false);
        btnChonNgay.setEnabled(false);

        btnHuy.setVisible(false);
        btnXacNhan.setVisible(false);
        btnSua.setVisible(true);
    }
    public void setData(){
        int row = table.getSelectedRow();
        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        PhieuMuon phieuMuon =phieuMuonBUS.getLst().get(row);
        txMaPhieu.setText(String.valueOf(phieuMuon.getMaPhieu()));
        txMaTV.setText(String.valueOf(phieuMuon.getMaThanhVien()));
        txMaNV.setText(phieuMuon.getMaNV());
        txNgayMuon.setText(phieuMuon.getNgayMuon());
        txNgayHan.setText(phieuMuon.getNgayHan());
        txNgayTra.setText(phieuMuon.getNgayTra());
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        ThanhVien tv = thanhVienBUS.getTVByID(Integer.parseInt(txMaTV.getText()));
        txTenTV.setText(tv.getHoLot() + " " + tv.getTen());
    }
    private void turnOnEdit(){
        if (table.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null,"Hãy chọn một phiếu dưới bảng để chỉnh sửa!");
            return;
        }
        String ngayTra = txNgayTra.getText();
        if (ngayTra.length()>1){
            JOptionPane.showMessageDialog(null,"Phiếu mượn đã có ngày trả, không thể sửa thông tin!");
            return;
        }
        btnHuy.setVisible(true);
        btnXacNhan.setVisible(true);
        btnSua.setVisible(false);
        btnChonNgay.setEnabled(true);
    }
    private boolean checkNgayTra(){
        LocalDate ngayTra = LocalDate.parse(txNgayTra.getText());
        LocalDate ngayMuon = LocalDate.parse(txNgayMuon.getText());

        if (ngayTra.isBefore(ngayMuon)){
            JOptionPane.showMessageDialog(null,"Ngày trả không trước ngày mượn!");
            return false;
        }
        return true;
    }
    private void updateData(){
        if (txNgayTra.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn ngày trả!");
            return;
        }
        if (checkNgayTra()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn sửa thông tin phiếu mượn?","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
                SachBUS sachBUS = new SachBUS();
                PhieuMuon pm = phieuMuonBUS.getPMByID(Integer.parseInt(txMaPhieu.getText()));

                pm.setNgayTra(txNgayTra.getText());
                System.out.println(pm.toString());
                phieuMuonBUS.updateData(pm);
                CT_PhieuMuonBUS ct_phieuMuonBUS = new CT_PhieuMuonBUS();
                for (CT_PhieuMuon ct_phieuMuon:ct_phieuMuonBUS.getLst()){
                    if (ct_phieuMuon.getMaPhieu() == Integer.parseInt(txMaPhieu.getText())){
                        Sach sach = sachBUS.getSachByID(ct_phieuMuon.getMaSach());
                        sach.setSoLuong(sach.getSoLuong()+1);
                        sachBUS.updateData(sach);
                    }
                }
                turnOffEdit();
                JOptionPane.showMessageDialog(null,"Đã cập nhật thông tin thành công!");
            }
        }
    }
}
