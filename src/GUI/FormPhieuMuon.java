package GUI;

import BUS.*;
import DTO.*;


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class FormPhieuMuon extends JFrame {

    private JPanel contentPane;
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JTextField txMaPhieu = new JTextField();
    private JTextField txTenTV= new JTextField();
    private JTextField txMaNV= new JTextField();
    private JTextField txNgayMuon= new JTextField();
    private JTextField txNgayHan= new JTextField();
    private         JComboBox cbMaSach = new JComboBox();
    private         JComboBox cbTenSach = new JComboBox();
    private         JComboBox cbMaTV = new JComboBox();

    private ArrayList<Sach> lstMuon = new ArrayList<>();
    Icon them = new ImageIcon("src/IMG/anh/them.png");
    Icon xoa = new ImageIcon("src/IMG/anh/xoa.png");
    Icon huy = new ImageIcon("src/IMG/anh/huy.png");


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPhieuMuon frame = new FormPhieuMuon();
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
    public FormPhieuMuon() {
        this.init();
    }
    public FormPhieuMuon(int maSach){
        this.init();
        cbMaSach.setSelectedIndex(maSach);
        cbTenSach.setSelectedIndex(maSach);
    }
    public void init(){
        txMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbMaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbTenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setBounds(600, 100, 700, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 666, 47);
        contentPane.add(panel);

        JLabel lblThmPhiuMn = new JLabel("THÊM PHIẾU MƯỢN");
        lblThmPhiuMn.setHorizontalAlignment(SwingConstants.CENTER);
        lblThmPhiuMn.setForeground(Color.WHITE);
        lblThmPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThmPhiuMn.setBackground(new Color(33, 115, 70));
        panel.add(lblThmPhiuMn);

        scrollPane.setBounds(10, 307, 666, 261);
        contentPane.add(scrollPane);

        JLabel lbMaSach = new JLabel("Mã sách:");
        lbMaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaSach.setBounds(10, 267, 95, 30);
        contentPane.add(lbMaSach);

        JLabel lbTenSach = new JLabel("Tên:");
        lbTenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTenSach.setBounds(166, 267, 50, 30);
        contentPane.add(lbTenSach);

        cbMaSach.setBounds(95, 267, 61, 30);
        contentPane.add(cbMaSach);

        cbTenSach.setBounds(208, 267, 336, 30);
        contentPane.add(cbTenSach);

        JButton btnAdd = new JButton("");
        btnAdd.setIcon(new ImageIcon("src/IMG/anh/add.png"));
        btnAdd.setBounds(571, 267, 50, 30);
        contentPane.add(btnAdd);

        JButton btnDel = new JButton("");
        btnDel.setIcon(new ImageIcon("src/IMG/anh/minus.png"));
        btnDel.setBounds(631, 267, 50, 30);
        contentPane.add(btnDel);

        JLabel lbMaPhieu = new JLabel("Mã phiếu:");
        lbMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaPhieu.setBounds(10, 67, 95, 30);
        contentPane.add(lbMaPhieu);

        JLabel lbMaThanhVien = new JLabel("Mã thành viên:");
        lbMaThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaThanhVien.setBounds(10, 107, 146, 30);
        contentPane.add(lbMaThanhVien);

        JLabel lbMaNV = new JLabel("Mã nhân viên:");
        lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNV.setBounds(10, 147, 146, 30);
        contentPane.add(lbMaNV);

        JLabel lbNgayMuon = new JLabel("Ngày mượn:");
        lbNgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayMuon.setBounds(10, 187, 133, 30);
        contentPane.add(lbNgayMuon);

        JLabel lbNgayHan = new JLabel("Ngày hạn:");
        lbNgayHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayHan.setBounds(10, 227, 107, 30);
        contentPane.add(lbNgayHan);

        txMaPhieu.setBounds(166, 67, 50, 30);
        contentPane.add(txMaPhieu);
        txMaPhieu.setColumns(10);

        cbMaTV.setBounds(166, 107, 50, 30);
        contentPane.add(cbMaTV);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBackground(Color.yellow);
        btnXoa.setBounds(10, 622, 150, 31);
        btnXoa.setIcon(xoa);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setBackground(Color.red);
        btnHuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(262, 622, 150, 31);
        btnHuy.setIcon(huy);
        contentPane.add(btnHuy);

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setForeground(Color.white);
        btnThem.setBounds(526, 622, 150, 31);
        btnThem.setIcon(them);
        contentPane.add(btnThem);

        txTenTV.setColumns(10);
        txTenTV.setBounds(225, 107, 319, 30);
        contentPane.add(txTenTV);

        txMaNV.setColumns(10);
        txMaNV.setBounds(166, 147, 378, 30);
        contentPane.add(txMaNV);

        txNgayMuon.setColumns(10);
        txNgayMuon.setBounds(166, 187, 378, 30);
        contentPane.add(txNgayMuon);

        txNgayHan.setColumns(10);
        txNgayHan.setBounds(166, 227, 378, 30);
        contentPane.add(txNgayHan);
        addMaSach();
        addTenSach();
        addMaThanhVien();
        cbMaSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbMaSachSelectAction();
            }
        });
        cbTenSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbTenSachSelectAction();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSachToTable();
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delSachFromTable();
            }
        });
        addDBToTable(lstMuon);
        txMaPhieu.setEditable(false);
        txNgayMuon.setEditable(false);
        txNgayHan.setEditable(false);
        txMaNV.setEditable(false);
        txTenTV.setEditable(false);
        setMaPhieu();
        setNgayMuon();
        setNgayHan();
        setMaNV();
        setTenTV();
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themPhieuMuon();
            }
        });
        cbMaTV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTenTV();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaData();
            }
        });
    }

    private void addMaSach(){
        SachBUS sachBUS = new SachBUS();
        for (Sach sach : sachBUS.getLst()){
            cbMaSach.addItem(String.valueOf(sach.getMaSach()));
        }
    }
    private void addTenSach(){
        SachBUS sachBUS = new SachBUS();
        for (Sach sach : sachBUS.getLst()){
            cbTenSach.addItem(sach.getTenSach());
        }
    }
    private void addMaThanhVien(){
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        for (ThanhVien tv:thanhVienBUS.getLst()){
            cbMaTV.addItem(String.valueOf(tv.getMaThanhVien()));
        }
    }
    private void setTenTV(){
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        ThanhVien tv = thanhVienBUS.getTVByID(Integer.parseInt(String.valueOf(cbMaTV.getSelectedItem())));
        txTenTV.setText(tv.getHoLot() + " " + tv.getTen());
    }
    private void cbTenSachSelectAction(){
        int i = cbTenSach.getSelectedIndex();
        cbMaSach.setSelectedIndex(i);
    }
    private void cbMaSachSelectAction(){
        int i = cbMaSach.getSelectedIndex();
        cbTenSach.setSelectedIndex(i);
    }
    private void addSachToTable(){
        if(lstMuon.size()==3){
            JOptionPane.showMessageDialog(null,"Chỉ được mượn tối đa 3 quyển sách!");
            return;
        }
        SachBUS sachBUS = new SachBUS();
        Sach sach = sachBUS.getSachByID(Integer.parseInt(String.valueOf(cbMaSach.getSelectedItem())));
        if (checkExist(sach)){
            if (sach.getSoLuong()==0){
                JOptionPane.showMessageDialog(null,"Đã hết sách này!");
                return;
            }
            lstMuon.add(sach);
            addDBToTable(lstMuon);
        }
    }
    private void addDBToTable(ArrayList<Sach> lstSach){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã sách");
        nModel.addColumn("Tên sách");

        for (Sach sach:lstSach){
            Vector data = new Vector<>();
            data.add(sach.getMaSach());
            data.add(sach.getTenSach());

            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",0,15));
        table.setRowHeight(30);
    }
    private boolean checkExist(Sach sach){
        for (Sach sach1:lstMuon){
            if (sach1.getMaSach() == sach.getMaSach()){
                JOptionPane.showMessageDialog(null,"Sách đã tồn tại trong phiếu mượn!");
                return false;
            }
        }
        return true;
    }
    private void delSachFromTable(){
        int row = table.getSelectedRow();
        if (row <0){
            JOptionPane.showMessageDialog(null,"Hãy chọn một sách dưới bảng để xóa!");
            return;
        }
        int maSach = (int) table.getValueAt(row,0);
        int i = 0;
        for (Sach sach:lstMuon){

            if (sach.getMaSach() == maSach){
                lstMuon.remove(i);
                addDBToTable(lstMuon);
                return;
            }
            i++;
        }
    }
    private void setMaPhieu(){
        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        txMaPhieu.setText(String.valueOf(phieuMuonBUS.getLst().size()+1));
    }
    private void setMaNV(){
        LoginBUS loginBUS = new LoginBUS();
        txMaNV.setText(loginBUS.getUsername());
    }
    private void setNgayMuon(){
        LocalDate dateNow = LocalDate.now();
        String year = String.valueOf(dateNow.getYear());
        String month = String.valueOf(dateNow.getMonth().getValue());
        String day = String.valueOf(dateNow.getDayOfMonth());
        String date = year+"-"+month+"-"+day;
        txNgayMuon.setText(date);
    }
    private void setNgayHan(){
        LocalDate dateNow = LocalDate.now();
        LocalDate dueDate = dateNow.plusDays(7);
        String year = String.valueOf(dueDate.getYear());
        String month = String.valueOf(dueDate.getMonth().getValue());
        String day = String.valueOf(dueDate.getDayOfMonth());
        String date = year+"-"+month+"-"+day;
        txNgayHan.setText(date);
    }
    private boolean checkData(){


        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        ThanhVien thanhVien = thanhVienBUS.getTVByID(Integer.parseInt(String.valueOf(cbMaTV.getSelectedItem())));
        LocalDate dueDate = LocalDate.parse(thanhVien.getHanThe());
        if (dueDate.isBefore(LocalDate.now())){
            JOptionPane.showMessageDialog(null,"Thành viên đã hết hạn đăng ký, vui lòng gia hạn thêm!");
            return false;
        }
        for (PhieuMuon phieuMuon: phieuMuonBUS.getLst()){
            if (Integer.parseInt(String.valueOf(cbMaTV.getSelectedItem()))==phieuMuon.getMaThanhVien()){
                if (phieuMuon.getNgayTra() == null || phieuMuon.getNgayTra().equals("")){
                    JOptionPane.showMessageDialog(null,"Thành viên hiện đang có sách mượn chưa trả, Không thể mượn thêm!");
                    return false;
                }
            }
        }
        if (lstMuon.size()==0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn sách cần mượn");
            return false;
        }
        return true;
    }
    private void xoaData(){
        lstMuon = new ArrayList<>();
        addDBToTable(lstMuon);
    }
    private void themPhieuMuon(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm phiếu mượn!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
                PhieuMuon phieuMuon = new PhieuMuon();
                phieuMuon.setMaPhieu(Integer.parseInt(txMaPhieu.getText()));
                phieuMuon.setMaThanhVien(Integer.parseInt(String.valueOf(cbMaTV.getSelectedItem())));
                phieuMuon.setMaNV(txMaNV.getText());
                phieuMuon.setNgayMuon(txNgayMuon.getText());
                phieuMuon.setNgayTra(null);
                phieuMuon.setNgayHan(txNgayHan.getText());
                phieuMuonBUS.insertLst(phieuMuon);

                CT_PhieuMuonBUS ct_phieuMuonBUS = new CT_PhieuMuonBUS();
                SachBUS sachBUS = new SachBUS();
                for (Sach sach:lstMuon){
                    sach.setSoLuong(sach.getSoLuong()-1);
                    sachBUS.updateData(sach);
                    CT_PhieuMuon ct_phieuMuon = new CT_PhieuMuon();
                    ct_phieuMuon.setMaPhieu(Integer.parseInt(txMaPhieu.getText()));
                    ct_phieuMuon.setMaSach(sach.getMaSach());
                    ct_phieuMuonBUS.insertLst(ct_phieuMuon);
                }
                JOptionPane.showMessageDialog(null,"Đã thêm phiếu mượn thành công!");
                setVisible(false);
            }
        }
    }
}
