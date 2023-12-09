package GUI;

import BUS.NhanVienBUS;
import CheckInfo.CheckTool;
import DTO.NhanVien;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class NhanVienGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txTim = new JTextField();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JTextField txMaNV = new JTextField();
    private JTextField txMaViTri= new JTextField();
    private JTextField txTenViTri= new JTextField();
    private JTextField txHoLot= new JTextField();
    private JTextField txTen= new JTextField();
    private JTextField txDiaChi= new JTextField();
    private JTextField txSDT= new JTextField();
    private JTextField txEmail= new JTextField();
    private JTextField txNgayLam= new JTextField();
    private DatePicker txNgayNghi= new DatePicker();
    private JTextField txNgayNghi2 = new JTextField();
    private JButton btnChon = new JButton("");
    private JButton btnHuy = new JButton("");
    private JButton btnXacNhan = new JButton("");
    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");

    private boolean editFlag = false;

    private JComboBox cbTim = new JComboBox();

    private JTextField[] editTextFields = {txDiaChi,txSDT,txEmail};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NhanVienGUI frame = new NhanVienGUI();
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
    public NhanVienGUI() {
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
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
        panel.setLayout(null);

        JLabel lbtitle = new JLabel("NHÂN VIÊN");
        lbtitle.setForeground(new Color(255, 255, 255));
        lbtitle.setBounds(545, 10, 189, 37);
        lbtitle.setBackground(new Color(33, 115, 70));
        lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbtitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(lbtitle);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);

        JLabel lbTim = new JLabel("Tìm theo:");
        lbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTim.setBounds(850, 10, 111, 30);
        pnInfo.add(lbTim);

        cbTim.addItem("Mã nhân viên");
        cbTim.addItem("Tên nhân viên");
        cbTim.addItem("Mã vị trí");
        cbTim.setSelectedIndex(0);
        cbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbTim.setBounds(950, 10, 300, 30);
        pnInfo.add(cbTim);

        txTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTim.setColumns(10);
        txTim.setBounds(850, 86, 350, 30);
        pnInfo.add(txTim);

        JButton btnTim = new JButton("");
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(1205, 86, 51, 30);
        btnTim.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        pnInfo.add(btnTim);

        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBounds(1137, 160, 119, 30);
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setForeground(Color.white);

        pnInfo.add(btnThem);

        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        btnSua.setBackground(new Color(242, 238, 157));
        btnSua.setBounds(1008, 160, 119, 30);
        pnInfo.add(btnSua);

        btnXacNhan.setBounds(950, 160, 50, 30);
        btnXacNhan.setBackground(new Color(210, 224, 251));
        pnInfo.add(btnXacNhan);
        btnXacNhan.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        btnHuy.setBounds(890, 160, 50, 30);
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btnHuy.setBackground(new Color(140, 51, 51));
        pnInfo.add(btnHuy);

        JLabel lbMaNV = new JLabel("Mã NV:");
        lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNV.setBounds(10, 10, 76, 30);
        pnInfo.add(lbMaNV);

        JLabel lbViTri = new JLabel("Vị trí:");
        lbViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbViTri.setBounds(10, 46, 76, 30);
        pnInfo.add(lbViTri);

        JLabel lbHoLot = new JLabel("Họ lót:");
        lbHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbHoLot.setBounds(10, 86, 76, 30);
        pnInfo.add(lbHoLot);

        JLabel lbTen = new JLabel("Tên:");
        lbTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTen.setBounds(10, 126, 76, 30);
        pnInfo.add(lbTen);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(10, 160, 76, 30);
        pnInfo.add(lbDiaChi);

        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setBounds(85, 10, 273, 29);
        pnInfo.add(txMaNV);
        txMaNV.setColumns(10);

        txMaViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaViTri.setColumns(10);
        txMaViTri.setBounds(85, 47, 51, 29);
        pnInfo.add(txMaViTri);

        txTenViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenViTri.setColumns(10);
        txTenViTri.setBounds(146, 46, 212, 29);
        pnInfo.add(txTenViTri);

        txHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txHoLot.setColumns(10);
        txHoLot.setBounds(85, 86, 273, 29);
        pnInfo.add(txHoLot);

        txTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTen.setColumns(10);
        txTen.setBounds(85, 126, 273, 29);
        pnInfo.add(txTen);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(85, 161, 380, 29);
        pnInfo.add(txDiaChi);

        JLabel lbSdt = new JLabel("SĐT:");
        lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSdt.setBounds(368, 10, 76, 30);
        pnInfo.add(lbSdt);

        txSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSDT.setColumns(10);
        txSDT.setBounds(443, 10, 273, 29);
        pnInfo.add(txSDT);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(368, 46, 76, 30);
        pnInfo.add(lbEmail);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(443, 46, 273, 29);
        pnInfo.add(txEmail);

        JLabel lbNgayLam = new JLabel("Ngày làm:");
        lbNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayLam.setBounds(368, 86, 100, 30);
        pnInfo.add(lbNgayLam);

        txNgayLam.setBounds(480, 86, 300, 29);
        txNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnInfo.add(txNgayLam);

        JLabel lbNgayNghi = new JLabel("Ngày nghỉ:");
        lbNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayNghi.setBounds(368, 126, 100, 30);
        pnInfo.add(lbNgayNghi);

        txNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayNghi.setBounds(480, 126, 300, 29);
        pnInfo.add(txNgayNghi);

        scrollPane.setBounds(10, 292, 1266, 411);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        pnInfo.add(btnChon);
        pnInfo.add(txNgayNghi2);
        txNgayNghi2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayNghi2.setBounds(550,160,200,30);

        btnChon.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        btnChon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnChon.setBounds(780, 126, 50, 29);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFormThem();
            }
        });
        turnOffEdit();
        addDBToTable(nhanVienBUS.getLst());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showData();
            }
        });
        btnChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chonNgay();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editFlag = true;
                turnOnEdit();
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFlag=false;
                turnOffEdit();

            }
        });
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFlag=false;
                confirmUpdate();
                NhanVienBUS nhanVienBUS1 = new NhanVienBUS();
                addDBToTable(nhanVienBUS1.getLst());
            }
        });
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item =String.valueOf( cbTim.getSelectedItem());
                String data = txTim.getText();
                NhanVienBUS nhanVienBUS1 = new NhanVienBUS();
                ArrayList<NhanVien> lstFound = nhanVienBUS1.timNhanVien(item,data);
                addDBToTable(lstFound);
            }
        });
    }
    public void openFormThem(){
        FormThemNV formThemNV = new FormThemNV();
        formThemNV.setVisible(true);
    }
    public void addDBToTable(ArrayList<NhanVien> lsNV){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã nhân viên");
        nModel.addColumn("Mã vị trí");
        nModel.addColumn("Họ lót");
        nModel.addColumn("Tên");
        nModel.addColumn("Số điện thoại");
        nModel.addColumn("Email");
        nModel.addColumn("Địa chỉ");
        nModel.addColumn("Ngày làm");
        nModel.addColumn("Ngày nghỉ");

        for (NhanVien nv:lsNV){
            Vector data = new Vector<>();
            data.add(nv.getMaNV());
            data.add(nv.getMaViTri());
            data.add(nv.getHoLot());
            data.add(nv.getTen());
            data.add(nv.getSdt());
            data.add(nv.getEmail());
            data.add(nv.getDiaChi());
            data.add(nv.getNgaylam());
            data.add(nv.getNgayNghi());
            nModel.addRow(data);

        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        table.setRowHeight(30);
    }
    public void turnOffEdit(){
        txMaNV.setEditable(false);
        txMaViTri.setEditable(false);
        txTenViTri.setEditable(false);
        txSDT.setEditable(false);
        txNgayNghi.turnOffEdit();
        txNgayLam.setEditable(false);
        txNgayNghi2.setEditable(false);
        txDiaChi.setEditable(false);
        txEmail.setEditable(false);
        txHoLot.setEditable(false);
        txTen.setEditable(false);

        btnXacNhan.setVisible(false);
        btnHuy.setVisible(false);
        btnSua.setVisible(true);
    }
    public void showData(){
        int row = table.getSelectedRow();
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVien nv = nhanVienBUS.getNVByID(String.valueOf(table.getValueAt(row,0)));

        txMaNV.setText(nv.getMaNV());
        txMaViTri.setText(String.valueOf(nv.getMaViTri()));
        txTenViTri.setText(nhanVienBUS.getTenViTri(nv.getMaViTri()));
        txHoLot.setText(nv.getHoLot());
        txTen.setText(nv.getTen());
        txDiaChi.setText(nv.getDiaChi());
        txSDT.setText(nv.getSdt());
        txEmail.setText(nv.getEmail());
        txNgayLam.setText(nv.getNgaylam());
        txNgayNghi2.setText(nv.getNgayNghi());
    }
    public void chonNgay(){
        if (editFlag==true)
            txNgayNghi2.setText(txNgayNghi.getDate());
        else {
            JOptionPane.showMessageDialog(null,"Hãy chọn nút sửa trước khi sửa dữ liệu!");
        }
    }
    private void turnOnEdit(){
        if (table.getSelectedRow() <0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn một nhân viên để chỉnh sửa thông tin");
            return;
        }
        txDiaChi.setEditable(true);
        txEmail.setEditable(true);
        txSDT.setEditable(true);
        btnSua.setVisible(false);
        btnHuy.setVisible(true);
        btnXacNhan.setVisible(true);
    }
    private boolean checkData(){
        CheckTool checkTool = new CheckTool();

        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
            return false;
        }
        if(!checkTool.isValidPhoneNum(txSDT.getText())){
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
            return false;
        }
        if (txDiaChi.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền địa chỉ!");
            return false;
        }
        return true;
    }
    private void confirmUpdate(){
        CheckTool checkTool = new CheckTool();
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                NhanVienBUS nhanVienBUS = new NhanVienBUS();
                NhanVien nv= nhanVienBUS.getNVByID(txMaNV.getText());
                nv.setDiaChi(checkTool.formatInfo(txDiaChi.getText()));
                nv.setEmail(txEmail.getText());
                nv.setSdt(txSDT.getText());
                if (!txNgayNghi2.getText().equals("")){
                    nv.setNgayNghi(txNgayNghi2.getText());
                }

                nhanVienBUS.updateData(nv);

                JOptionPane.showMessageDialog(null,"Chỉnh sửa thông tin thành công!");
                turnOffEdit();
            }
        }
    }
}
