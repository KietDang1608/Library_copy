package GUI;

import BUS.CT_PhanQuyenBUS;
import BUS.NhanVienBUS;
import BUS.ViTriBUS;
import DTO.NhanVien;
import DTO.Sach;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PhanQuyenGUI extends JFrame {


    private JPanel contentPane;
    private JTable tableQuyen = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tableQuyen);

    private JTable tablePhanViTri = new JTable();
    private JScrollPane scrollPane2 = new JScrollPane(tablePhanViTri);

    private JComboBox cbViTri = new JComboBox();

    private JTextField txMaNV;
    private JTextField txTenNV;
    private JTextField txMaVT;


    private JCheckBox checkSach = new JCheckBox("Quản lý sách");
    private JCheckBox checkTL = new JCheckBox("Quản lý thể loại sách");
    private JCheckBox checkQD = new JCheckBox("Quản lý quy định");
    private JCheckBox checkPhieuNhap = new JCheckBox("Quản lý phiếu nhập");
    private JCheckBox checkPhieuMuon = new JCheckBox("Quản lý phiếu mượn");
    private JCheckBox checkThanhVien = new JCheckBox("Quản lý thành viên");
    private JCheckBox checkPhieuPhat = new JCheckBox("Quản lý phiếu phạt");
    private JCheckBox checkNhanVien = new JCheckBox("Quản lý nhân viên");
    private JCheckBox checkTaiKhoan = new JCheckBox("Quản lý tài khoản");
    private JCheckBox checkNCC = new JCheckBox("Quản lý nhà cung cấp");
    private JCheckBox checkThongKe = new JCheckBox("Thống kê");
    private JCheckBox checkPhanQuyen = new JCheckBox("Phân quyền");

    private JCheckBox[] checkBoxes = {checkSach,checkTL,checkQD,checkPhieuNhap,checkPhieuMuon,checkThanhVien,checkPhieuPhat,checkPhanQuyen,checkNhanVien,checkTaiKhoan,checkThongKe,checkNCC};
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhanQuyenGUI frame = new PhanQuyenGUI();
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
    public PhanQuyenGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        addToTablePhanQuyen();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 1266, 62);
        contentPane.add(panel);

        JLabel lblPhnQuyn = new JLabel("PHÂN QUYỀN");
        lblPhnQuyn.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhnQuyn.setForeground(Color.WHITE);
        lblPhnQuyn.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblPhnQuyn.setBackground(new Color(33, 115, 70));
        lblPhnQuyn.setBounds(545, 10, 247, 37);
        panel.add(lblPhnQuyn);

        JPanel pnInfo = new JPanel();
        pnInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 735, 200);
        contentPane.add(pnInfo);


        checkSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkSach.setBounds(6, 6, 199, 27);
        pnInfo.add(checkSach);


        checkTL.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkTL.setBounds(6, 45, 241, 27);
        pnInfo.add(checkTL);


        checkQD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkQD.setBounds(6, 82, 199, 27);
        pnInfo.add(checkQD);


        checkPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPhieuNhap.setBounds(6, 122, 199, 27);
        pnInfo.add(checkPhieuNhap);


        checkPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPhieuMuon.setBounds(263, 6, 241, 27);
        pnInfo.add(checkPhieuMuon);


        checkThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkThanhVien.setBounds(263, 45, 199, 27);
        pnInfo.add(checkThanhVien);


        checkPhieuPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPhieuPhat.setBounds(263, 82, 199, 27);
        pnInfo.add(checkPhieuPhat);


        checkNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkNhanVien.setBounds(263, 122, 199, 27);
        pnInfo.add(checkNhanVien);


        checkTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkTaiKhoan.setBounds(506, 6, 199, 27);
        pnInfo.add(checkTaiKhoan);


        checkNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkNCC.setBounds(506, 45, 223, 27);
        pnInfo.add(checkNCC);

        checkThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkThongKe.setBounds(506, 82, 199, 27);
        pnInfo.add(checkThongKe);

        checkPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPhanQuyen.setBounds(506, 122, 199, 27);
        pnInfo.add(checkPhanQuyen);

        JButton btnSuaQuyen = new JButton("Sửa phân quyền");
        btnSuaQuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSuaQuyen.setBounds(500, 155, 226, 35);
        btnSuaQuyen.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        btnSuaQuyen.setBackground(new Color(242, 238, 157));
        pnInfo.add(btnSuaQuyen);


        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(755, 82, 521, 200);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lbNhanVien = new JLabel("Nhân viên:");
        lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNhanVien.setBounds(10, 10, 117, 30);
        panel_1.add(lbNhanVien);

        JLabel lbMaViTri2 = new JLabel("Vị trí:");
        lbMaViTri2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaViTri2.setBounds(10, 50, 73, 30);
        panel_1.add(lbMaViTri2);

        txMaNV = new JTextField();
        txMaNV.setEditable(false);
        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txMaNV.setColumns(10);
        txMaNV.setBounds(137, 11, 100, 29);
        panel_1.add(txMaNV);

        txTenNV = new JTextField();
        txTenNV.setEditable(false);
        txTenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txTenNV.setColumns(10);
        txTenNV.setBounds(260, 11, 260, 29);
        panel_1.add(txTenNV);

        txMaVT = new JTextField();
        txMaVT.setEditable(false);
        txMaVT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txMaVT.setColumns(10);
        txMaVT.setBounds(137, 50, 41, 29);
        panel_1.add(txMaVT);


        cbViTri.setBounds(193, 50, 318, 30);
        cbViTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_1.add(cbViTri);

        JButton btnNewButton_1 = new JButton("Sửa vị trí");
        btnNewButton_1.setBackground(new Color(242, 238, 157));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        btnNewButton_1.setBounds(348, 160, 163, 30);
        panel_1.add(btnNewButton_1);
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(10,160,163,30);
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRefresh.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        panel_1.add(btnRefresh);
        btnRefresh.setBackground(new Color(131, 162, 255));
        tablePhanViTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setBounds(444, 292, 832, 411);
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToTableViTri();
            }
        });
        contentPane.add(scrollPane2);


        contentPane.add(scrollPane);
        scrollPane.setBounds(10, 292, 424, 411);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        setCheckBoxID();
        tableQuyen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setSelectedFalse();
                int row = tableQuyen.getSelectedRow();
                ArrayList<Integer> lstQuyen = (ArrayList<Integer>) tableQuyen.getValueAt(row,2);
                for (JCheckBox checkBox:checkBoxes){
                    for(Integer i:lstQuyen){
                        if (Integer.parseInt(checkBox.getName()) == i){
                            checkBox.setSelected(true);
                            break;
                        }
                    }
                }
            }
        });
        btnSuaQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhanQuyen();
            }
        });
        addToTableViTri();
        cbViTri.addItem("Thủ thư");
        cbViTri.addItem("Quản lý");
        cbViTri.addItem("Trực kho");
        cbViTri.addItem("Admin");
        tablePhanViTri.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tablePhanViTri.getSelectedRow();
                String maNV = String.valueOf(tablePhanViTri.getValueAt(row,0));
                String ten = String.valueOf(tablePhanViTri.getValueAt(row,1) );
                String viTri = String.valueOf(tablePhanViTri.getValueAt(row,2));

                txMaNV.setText(maNV);
                txTenNV.setText(ten);
                txMaVT.setText(viTri);
                cbViTri.setSelectedIndex(Integer.parseInt(viTri)-1);
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhanViTri();
            }
        });
        cbViTri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTxMaVT();
            }
        });
    }
    public void addToTablePhanQuyen(){
        CT_PhanQuyenBUS ct_phanQuyenBUS = new CT_PhanQuyenBUS();
        ViTriBUS viTriBUS = new ViTriBUS();

        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã vị trí");
        nModel.addColumn("Tên vị trí");
        nModel.addColumn("Các quyền");


        for (int i = 1;i<=4;i++){
            Vector data = new Vector();
            data.add(i);
            data.add(viTriBUS.getdsViTri().get(i-1).getTenViTri());
            data.add(ct_phanQuyenBUS.getLstQuyen(i));

            nModel.addRow(data);
        }
        tableQuyen.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumnModel columnModel = tableQuyen.getColumnModel();


        tableQuyen.setModel(nModel);


        TableColumn column = columnModel.getColumn(0);
        column.setPreferredWidth(5);

        column = columnModel.getColumn(1);
        column.setPreferredWidth(5);

        column = columnModel.getColumn(2);
        column.setPreferredWidth(30);

        tableQuyen.setFont(new Font("Tahoma",Font.PLAIN,15));


        tableQuyen.setRowHeight(30);
    }
    public void setCheckBoxID(){
        int i=1;
        for (JCheckBox checkBox:checkBoxes){
            checkBox.setName(String.valueOf(i++));
        }
    }
    public void setSelectedFalse(){
        for (JCheckBox checkBox:checkBoxes){
            checkBox.setSelected(false);
        }
    }

    public ArrayList<Integer> getLstUpdate(){
        ArrayList<Integer> lstQuyen = new ArrayList<>();

        for (JCheckBox checkBox:checkBoxes){
            if (checkBox.isSelected()){
                lstQuyen.add(Integer.parseInt(checkBox.getName()));
            }
        }
        return lstQuyen;
    }

    public void updatePhanQuyen(){
        int row = tableQuyen.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn vị trí cần chỉnh sửa!");
            return;
        }
        int viTri = (Integer) tableQuyen.getValueAt(row,0);

        if (viTri == 4){
            checkPhanQuyen.setSelected(true);
        }

        ArrayList<Integer> lstQuyen = getLstUpdate();
        if(lstQuyen.size()==0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn ít nhất 1 quyền");
            return;
        }
        CT_PhanQuyenBUS ct_phanQuyenBUS = new CT_PhanQuyenBUS();
        ct_phanQuyenBUS.xoaPhanQuyenViTri(viTri);
        ct_phanQuyenBUS.resetPhanQuyen(viTri,lstQuyen);

        addToTablePhanQuyen();
    }
    public void addToTableViTri(){
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        ViTriBUS viTriBUS = new ViTriBUS();

        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã nhân viên");
        nModel.addColumn("Tên nhân viên");
        nModel.addColumn("Mã vị trí");
        nModel.addColumn("Tên vị trí");

        for (NhanVien nhanVien: nhanVienBUS.getLst()){
            Vector data = new Vector();
            data.add(nhanVien.getMaNV());
            data.add(nhanVien.getHoLot()+ " " + nhanVien.getTen());
            data.add(nhanVien.getMaViTri());
            data.add(nhanVienBUS.getTenViTri(nhanVien.getMaViTri()));

            nModel.addRow(data);
        }
        tablePhanViTri.setModel(nModel);
        tablePhanViTri.setFont(new Font("Tahoma",Font.PLAIN,15));
        tablePhanViTri.setRowHeight(30);
    }

    public void updatePhanViTri(){
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        if (txMaNV.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn nhân viên cần chỉnh sửa!");
            return;
        }
        if (txMaNV.getText().equals("admin")){
            JOptionPane.showMessageDialog(null,"Đây là tài khoản admin mặc định, không thể đổi!");
            return;
        }
        NhanVien nv = nhanVienBUS.getNVByID(txMaNV.getText());
        nv.setMaViTri(Integer.parseInt(txMaVT.getText()));
        nhanVienBUS.updateData(nv);
        addToTableViTri();
    }
    public void setTxMaVT(){
        int i = cbViTri.getSelectedIndex();
        txMaVT.setText(String.valueOf(i+1));
    }
}
