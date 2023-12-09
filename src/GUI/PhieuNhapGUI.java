package GUI;

import BUS.CT_PhieuNhapBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SachBUS;
import DTO.*;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class PhieuNhapGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txTim = new JTextField();
    private JTextField txMaPhieu= new JTextField();
    private JTextField txMaNCC= new JTextField();
    private JTextField txTenNCC= new JTextField();
    private JTextField txMaNV= new JTextField();
    private JTextField txNgayNhap= new JTextField();
    private JTable table = new JTable();
    private JScrollPane scrollPane1 = new JScrollPane(table);
    private JTable tableChiTiet = new JTable();
    private JScrollPane scrollPane2 = new JScrollPane(tableChiTiet);


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhieuNhapGUI frame = new PhieuNhapGUI();
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
    public PhieuNhapGUI() {
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

        JLabel lbPhieuNhap = new JLabel("PHIẾU NHẬP");
        lbPhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
        lbPhieuNhap.setForeground(new Color(255, 255, 255));
        lbPhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(lbPhieuNhap, BorderLayout.CENTER);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);

        JLabel lbTim = new JLabel("Tìm theo:");
        lbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTim.setBounds(808, 10, 111, 30);
        pnInfo.add(lbTim);

        JComboBox cbTim = new JComboBox();
        cbTim.addItem("Mã phiếu");
        cbTim.addItem("Mã nhà cung cấp");
        cbTim.addItem("Mã nhân viên");
        cbTim.setSelectedIndex(0);

        cbTim.setBounds(907, 10, 349, 30);

        pnInfo.add(cbTim);

        txTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTim.setColumns(10);
        txTim.setBounds(808, 86, 397, 30);
        pnInfo.add(txTim);

        JButton btnTim = new JButton("");
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(1205, 86, 51, 30);
        btnTim.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        pnInfo.add(btnTim);

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(1137, 160, 119, 30);
        btnThem.setForeground(Color.white);
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        pnInfo.add(btnThem);

        JButton btnReload = new JButton("Refresh");
        btnReload.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnReload.setBackground(new Color(131, 162, 255));
        btnReload.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReload.setBounds(1008, 160, 119, 30);
        pnInfo.add(btnReload);

        JLabel lblMPhiuNhp = new JLabel("Mã phiếu nhập:");
        lblMPhiuNhp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMPhiuNhp.setBounds(10, 10, 160, 30);
        pnInfo.add(lblMPhiuNhp);

        JLabel lbNCC = new JLabel("Nhà cung cấp:");
        lbNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNCC.setBounds(10, 46, 160, 30);
        pnInfo.add(lbNCC);

        txMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaPhieu.setColumns(10);
        txMaPhieu.setBounds(180, 11, 69, 29);
        pnInfo.add(txMaPhieu);

        txMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNCC.setColumns(10);
        txMaNCC.setBounds(180, 47, 51, 29);
        pnInfo.add(txMaNCC);

        txTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenNCC.setColumns(10);
        txTenNCC.setBounds(241, 47, 450, 29);
        pnInfo.add(txTenNCC);

        JLabel lbNhanVien = new JLabel("Mã nhân viên:");
        lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNhanVien.setBounds(10, 86, 160, 30);
        pnInfo.add(lbNhanVien);

        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setColumns(10);
        txMaNV.setBounds(180, 86, 356, 29);
        pnInfo.add(txMaNV);

        JLabel lbNgaynhap = new JLabel("Ngày nhập:");
        lbNgaynhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgaynhap.setBounds(10, 126, 160, 30);
        pnInfo.add(lbNgaynhap);

        txNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayNhap.setColumns(10);
        txNgayNhap.setBounds(180, 127, 356, 29);
        pnInfo.add(txNgayNhap);

        scrollPane1.setBounds(10, 292, 457, 411);
        contentPane.add(scrollPane1);

        scrollPane2.setBounds(477, 292, 799, 411);
        contentPane.add(scrollPane2);

        PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
        addDBToTablePN(phieuNhapBUS.getLst());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setData();
                addDBToTableCT();
            }
        });
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhieuNhapBUS phieuNhapBUS1 = new PhieuNhapBUS();
                addDBToTablePN(phieuNhapBUS1.getLst());
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormNhapHang formNhapHang = new FormNhapHang();
                formNhapHang.setVisible(true);
            }
        });
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = String.valueOf(cbTim.getSelectedItem());
                String data = txTim.getText();
                PhieuNhapBUS phieuNhapBUS1 = new PhieuNhapBUS();
                addDBToTablePN(phieuNhapBUS1.timPN(item,data));
            }
        });
        turnOffText();

    }
    private void addDBToTablePN(ArrayList<PhieuNhap> lstPN){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã phiếu nhập");
        nModel.addColumn("Mã nhà cung cấp");
        nModel.addColumn("Mã nhân viên");
        nModel.addColumn("Ngày nhập");

        for (PhieuNhap pn:lstPN){
            Vector data = new Vector<>();
            data.add(pn.getPhieuNhap());
            data.add(pn.getMaNCC());
            data.add(pn.getMaNV());
            data.add(pn.getNgayNhap());
            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        table.setRowHeight(30);
    }
    private void addDBToTableCT(){
        int row = table.getSelectedRow();
        if (row >= 0){
            int maPhieu = Integer.parseInt(String.valueOf(table.getValueAt(row,0)));
            CT_PhieuNhapBUS ct_phieuNhapBUS = new CT_PhieuNhapBUS();
            SachBUS sachBUS = new SachBUS();
            DefaultTableModel nModel = new DefaultTableModel();
            nModel.addColumn("Mã phiếu");
            nModel.addColumn("Mã sách");
            nModel.addColumn("Tên sách");
            nModel.addColumn("Số lượng");
            nModel.addColumn("Đơn giá");

            for (CT_PhieuNhap ct : ct_phieuNhapBUS.getLst()) {
                if (ct.getMaPhieu() == maPhieu) {
                    Vector data = new Vector<>();
                    Sach sach = sachBUS.getSachByID(ct.getMaSach());
                    data.add(String.valueOf(maPhieu));
                    data.add(String.valueOf(sach.getMaSach()));
                    data.add(String.valueOf(sach.getTenSach()));
                    data.add(String.valueOf(ct.getSoLuong()));
                    data.add(String.valueOf(ct.getDonGia()));
                    nModel.addRow(data);
                }
            }
            tableChiTiet.setModel(nModel);
            tableChiTiet.setFont(new Font("Tahoma", 0, 15));
            tableChiTiet.setRowHeight(30);
        }
    }
    private void turnOffText(){
        txMaPhieu.setEditable(false);
        txMaNCC.setEditable(false);
        txTenNCC.setEditable(false);
        txNgayNhap.setEditable(false);
        txMaNV.setEditable(false);
    }
    private void setData(){
        int row = table.getSelectedRow();
        if (row >=0) {
            PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
            PhieuNhap pn = phieuNhapBUS.getPNByID(Integer.parseInt(String.valueOf(table.getValueAt(row, 0))));
            NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();

            txMaPhieu.setText(String.valueOf(pn.getPhieuNhap()));
            txMaNCC.setText(String.valueOf(pn.getMaNCC()));
            txNgayNhap.setText(pn.getNgayNhap());
            txMaNV.setText(pn.getMaNV());

            txTenNCC.setText(nhaCungCapBUS.getNCCByID(pn.getMaNCC()).getTenNCC());

        }
    }
}
