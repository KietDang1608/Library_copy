package GUI;

import BUS.*;
import CheckInfo.CheckTool;
import DTO.CT_PhieuNhap;
import DTO.NhaCungCap;
import DTO.PhieuNhap;
import DTO.Sach;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class FormNhapHang extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JTextField txMaPhieu = new JTextField();
    private JTextField txMaNV= new JTextField();
    private JTextField txNgayNhap= new JTextField();
    private JTextField txSoLuong= new JTextField();
    private JTextField txDonGia= new JTextField();
    private JComboBox cbMaSach = new JComboBox();
    private JComboBox cbTenSach = new JComboBox();
    private JComboBox cbMaNCC = new JComboBox();
    private JComboBox cbTenNCC = new JComboBox();
    private JLabel lbTong = new JLabel("Tổng: ");
    private ArrayList <CT_PhieuNhap> lstNhap = new ArrayList<>();
    Icon them = new ImageIcon("src/IMG/anh/them.png");

    Icon huy = new ImageIcon("src/IMG/anh/huy.png");
    Icon xoa = new ImageIcon("src/IMG/anh/xoa.png");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormNhapHang frame = new FormNhapHang();
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
    public FormNhapHang() {
        cbMaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbTenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setBounds(600, 100, 700, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 666, 47);
        contentPane.add(panel);

        JLabel lblThmPhiuNhp = new JLabel("THÊM PHIẾU NHẬP HÀNG");
        lblThmPhiuNhp.setHorizontalAlignment(SwingConstants.CENTER);
        lblThmPhiuNhp.setForeground(Color.WHITE);
        lblThmPhiuNhp.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThmPhiuNhp.setBackground(new Color(33, 115, 70));
        panel.add(lblThmPhiuNhp);

        scrollPane.setBounds(10, 351, 666, 200);
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

        JLabel lblNhCungCp = new JLabel("Nhà cung cấp:");
        lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNhCungCp.setBounds(10, 107, 146, 30);
        contentPane.add(lblNhCungCp);

        JLabel lbMaNV = new JLabel("Mã nhân viên:");
        lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNV.setBounds(10, 147, 146, 30);
        contentPane.add(lbMaNV);

        JLabel lblNgyNhp = new JLabel("Ngày nhập:");
        lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNgyNhp.setBounds(10, 187, 133, 30);
        contentPane.add(lblNgyNhp);

        txMaPhieu.setColumns(10);
        txMaPhieu.setBounds(166, 67, 50, 30);
        txMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(txMaPhieu);


        cbMaNCC.setBounds(166, 107, 50, 30);
        contentPane.add(cbMaNCC);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBackground(Color.yellow);
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBounds(10, 622, 150, 31);
        btnXoa.setIcon(xoa);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setBackground(Color.red);
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(262, 622, 150, 31);
        btnHuy.setIcon(huy);
        contentPane.add(btnHuy);
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setForeground(Color.white);
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(526, 622, 150, 31);
        btnThem.setIcon(them);
        contentPane.add(btnThem);

        txMaNV.setColumns(10);
        txMaNV.setBounds(166, 147, 510, 30);
        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(txMaNV);

        txNgayNhap.setColumns(10);
        txNgayNhap.setBounds(166, 187, 510, 30);
        txNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(txNgayNhap);


        cbTenNCC.setBounds(226, 107, 450, 30);
        contentPane.add(cbTenNCC);

        JLabel lblSLng = new JLabel("Số lượng:");
        lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSLng.setBounds(10, 311, 95, 30);
        contentPane.add(lblSLng);

        JLabel lbDonGia = new JLabel("Đơn giá:");
        lbDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDonGia.setBounds(200, 311, 95, 30);
        contentPane.add(lbDonGia);
        contentPane.add(txDonGia);
        txDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDonGia.setBounds(300, 311, 150, 30);

        lbTong.setBounds(10,550,200,30);
        lbTong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lbTong);


        txSoLuong.setColumns(10);
        txSoLuong.setBounds(95, 311, 50, 30);
        txSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(txSoLuong);
        txNgayNhap.setEditable(false);
        setData();
        setCBNhaCC();
        setCBSach();
        addDBToTable(lstNhap);

        cbMaNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbMaNCCSelectAction();
            }
        });
        cbTenNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbTenNCCSelectAction();
            }
        });
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
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaData();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themData();
            }
        });
    }
    private void setData(){
        txMaPhieu.setEditable(false);
        txMaNV.setEditable(false);
        CheckTool checkTool = new CheckTool();
        LoginBUS loginBUS = new LoginBUS();
        txMaNV.setText(loginBUS.getUsername());
        PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
        txMaPhieu.setText(String.valueOf(phieuNhapBUS.getLst().size() + 1));

        txNgayNhap.setText(checkTool.getStringDate(LocalDate.now()));

        txSoLuong.setText("0");
        txDonGia.setText("0");
    }
    private void setCBNhaCC(){
        NhaCungCapBUS nccBUS = new NhaCungCapBUS();
        for (NhaCungCap ncc: nccBUS.getLst()){
            cbMaNCC.addItem(ncc.getMaNCC());
            cbTenNCC.addItem(ncc.getTenNCC());
        }
    }
    private void setCBSach(){
        SachBUS sachBUS = new SachBUS();
        for (Sach sach: sachBUS.getLst()){
            cbMaSach.addItem(sach.getMaSach());
            cbTenSach.addItem(sach.getTenSach());
        }
    }
    private void cbTenSachSelectAction(){
        int i = cbTenSach.getSelectedIndex();
        cbMaSach.setSelectedIndex(i);
    }
    private void cbMaSachSelectAction(){
        int i = cbMaSach.getSelectedIndex();
        cbTenSach.setSelectedIndex(i);
    }
    private void cbMaNCCSelectAction(){
        int i = cbMaNCC.getSelectedIndex();
        cbTenNCC.setSelectedIndex(i);
    }
    private void cbTenNCCSelectAction(){
        int i = cbTenNCC.getSelectedIndex();
        cbMaNCC.setSelectedIndex(i);
    }

    private void addSachToTable(){
        CT_PhieuNhap ct_phieuNhap = new CT_PhieuNhap();
        int maSach = (Integer.parseInt(String.valueOf(cbMaSach.getSelectedItem())));
        int tong = 0;
        int sl =0;
        try{
            sl = Integer.parseInt(txSoLuong.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ!");
            return;
        }
        if (sl < 1){
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ!");
            return;
        }
        int dg = 0;
        try{
            dg = Integer.parseInt(txDonGia.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Đơn giá không hợp lệ!");
            return;
        }
        if (dg < 1){
            JOptionPane.showMessageDialog(null,"Đơn giá không hợp lệ!");
            return;
        }
        ct_phieuNhap.setMaPhieu(Integer.parseInt(txMaPhieu.getText()));
        ct_phieuNhap.setMaSach(maSach);
        ct_phieuNhap.setSoLuong(sl);
        ct_phieuNhap.setDonGia(dg);
        if (checkExist(ct_phieuNhap)){
            lstNhap.add(ct_phieuNhap);
            addDBToTable(lstNhap);
            for (int i = 0;i<table.getRowCount();i++){
                tong += Integer.parseInt(String.valueOf(table.getValueAt(i,4)));
            }
            lbTong.setText("Tổng: " + tong + " VND");
        }

    }
    private boolean checkExist(CT_PhieuNhap ct_phieuNhap){
        for (CT_PhieuNhap ct:lstNhap){
            if (ct_phieuNhap.getMaSach() == ct.getMaSach()){
                JOptionPane.showMessageDialog(null,"Sách đã tồn tại trong phiếu nhập!");
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
        int tong = 0;
        for (CT_PhieuNhap ct_phieuNhap:lstNhap){

            if (ct_phieuNhap.getMaSach() == maSach){
                lstNhap.remove(i);
                addDBToTable(lstNhap);
                for (int j = 0;j<table.getRowCount();j++){
                    tong += Integer.parseInt(String.valueOf(table.getValueAt(j,4)));
                }
                lbTong.setText("Tổng: " + tong + " VND");
                return;
            }
            i++;
        }
    }
    private void addDBToTable(ArrayList<CT_PhieuNhap> lstCTPN){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã sách");
        nModel.addColumn("Tên sách");
        nModel.addColumn("Số lượng");
        nModel.addColumn("Đơn giá");
        nModel.addColumn("Tổng");
        SachBUS sachBUS = new SachBUS();


        for (CT_PhieuNhap ct_phieuNhap:lstCTPN){
            Vector data = new Vector<>();
            data.add(ct_phieuNhap.getMaSach());
            data.add(sachBUS.getSachByID(ct_phieuNhap.getMaSach()).getTenSach());

            data.add(ct_phieuNhap.getSoLuong());
            data.add(ct_phieuNhap.getDonGia());
            data.add(String.valueOf(ct_phieuNhap.getDonGia()*ct_phieuNhap.getSoLuong()));

            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",0,15));
        table.setRowHeight(30);
    }
    private void xoaData(){
        lstNhap = new ArrayList<>();
        addDBToTable(lstNhap);
        lbTong.setText("Tổng: ");
    }
    private void huyData(){
        JOptionPane.showMessageDialog(null,"Đã hủy thêm phiếu nhập!");
        setVisible(false);
    }
    private void themData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm phiếu nhập?","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                PhieuNhapBUS phieuNhapBUS  = new PhieuNhapBUS();
                PhieuNhap pn = new PhieuNhap();
                pn.setPhieuNhap(Integer.parseInt(txMaPhieu.getText()));
                pn.setMaNCC(Integer.parseInt(String.valueOf(cbMaNCC.getSelectedItem())));
                pn.setMaNV(txMaNV.getText());
                pn.setNgayNhap(txNgayNhap.getText());
                phieuNhapBUS.insertLst(pn);

                CT_PhieuNhapBUS ct_phieuNhapBUS = new CT_PhieuNhapBUS();
                SachBUS sachBUS = new SachBUS();
                int maSach;
                int sl;
                for (int i =0;i<table.getRowCount();i++){
                    CT_PhieuNhap ct = new CT_PhieuNhap();
                    ct.setMaPhieu(Integer.parseInt(txMaPhieu.getText()));
                    maSach = Integer.parseInt(String.valueOf(table.getValueAt(i,0)));
                    sl = Integer.parseInt(String.valueOf(table.getValueAt(i,2)));
                    Sach sach = sachBUS.getSachByID(maSach);
                    sach.setSoLuong(sach.getSoLuong() + sl);
                    sachBUS.updateData(sach);
                    ct.setMaSach(maSach);
                    ct.setSoLuong(sl);
                    ct.setDonGia(Integer.parseInt(String.valueOf(table.getValueAt(i,3))));

                    ct_phieuNhapBUS.insertLst(ct);
                }
                JOptionPane.showMessageDialog(null,"Đã thêm phiếu nhập thành công!");
                setVisible(false);
            }
        }
    }
    private boolean checkData(){
        if (lstNhap.size()==0){
            JOptionPane.showMessageDialog(null,"Vui lòng thêm sách cần nhập!");
            return false;
        }
        return true;
    }
}
