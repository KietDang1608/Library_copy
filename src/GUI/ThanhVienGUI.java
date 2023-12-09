package GUI;

import BUS.ThanhVienBUS;
import CheckInfo.CheckTool;
import DTO.NhanVien;
import DTO.ThanhVien;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;


public class ThanhVienGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txTim = new JTextField();
    private JTextField txMaTV = new JTextField();
    private JTextField txHoLot = new JTextField();
    private JTextField txTen = new JTextField();
    private JTextField txDiaChi = new JTextField();
    private JTextField txSDT = new JTextField();
    private JTextField txEmail = new JTextField();
    private JTextField txNgayLamThe = new JTextField();
    private JTextField txNgayHetHan = new JTextField();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);

    private JButton btnHuy = new JButton("");
    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnXacNhan = new JButton("");
    private JButton btnTim = new JButton("");
    private JButton btnGiaHan = new JButton("Gia hạn thẻ");
    private JButton btnReload = new JButton("Refresh");

    private JComboBox cbTim = new JComboBox();
    public ThanhVienGUI() {
        this.init();
        turnOffEdit();
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        addDBToTable(thanhVienBUS.getLst());

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setData();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() <0){
                    JOptionPane.showMessageDialog(null,"Hãy chọn một thành viên để sửa!");
                }else {
                    turnOnEdit();
                }
            }
        });
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
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThanhVienBUS tvBUS = new ThanhVienBUS();
                addDBToTable(tvBUS.getLst());
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormThemTV form = new FormThemTV();
                form.setVisible(true);
            }
        });
        btnGiaHan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaHan();
            }
        });
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timThanhVien();
            }
        });
    }
    private void init(){
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 1266, 62);
        contentPane.add(panel);

        JLabel lblThnhVin = new JLabel("THÀNH VIÊN");
        lblThnhVin.setHorizontalAlignment(SwingConstants.CENTER);
        lblThnhVin.setForeground(Color.WHITE);
        lblThnhVin.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThnhVin.setBackground(new Color(33, 115, 70));
        lblThnhVin.setBounds(531, 10, 229, 37);
        panel.add(lblThnhVin);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);

        JLabel lbTim = new JLabel("Tìm theo:");
        lbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTim.setBounds(808, 10, 111, 30);
        pnInfo.add(lbTim);


        cbTim.addItem("Mã thành viên");
        cbTim.addItem("Tên thành viên");
        cbTim.addItem("Số điện thoại");
        cbTim.addItem("Email");
        cbTim.addItem("Địa chỉ");
        cbTim.setSelectedIndex(0);
        cbTim.setBounds(907, 10, 349, 30);
        pnInfo.add(cbTim);

        txTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTim.setColumns(10);
        txTim.setBounds(808, 86, 397, 30);
        pnInfo.add(txTim);


        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        btnTim.setBounds(1205, 86, 51, 30);
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

        JLabel lbMaTV = new JLabel("Mã TV:");
        lbMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaTV.setBounds(10, 10, 76, 30);
        pnInfo.add(lbMaTV);

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

        txMaTV.setEditable(false);
        txMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaTV.setColumns(10);
        txMaTV.setBounds(85, 10, 273, 29);
        pnInfo.add(txMaTV);

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
        txDiaChi.setBounds(85, 161, 631, 29);
        pnInfo.add(txDiaChi);

        JLabel lbSdt = new JLabel("SĐT:");
        lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSdt.setBounds(10, 50, 76, 30);
        pnInfo.add(lbSdt);

        txSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSDT.setColumns(10);
        txSDT.setBounds(85, 47, 273, 29);
        pnInfo.add(txSDT);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(367, 10, 76, 30);
        pnInfo.add(lbEmail);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(443, 11, 273, 29);
        pnInfo.add(txEmail);

        JLabel lbNgayLapThe = new JLabel("Ngày làm thẻ:");
        lbNgayLapThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayLapThe.setBounds(368, 50, 131, 30);
        pnInfo.add(lbNgayLapThe);

        txNgayLamThe.setEditable(false);
        txNgayLamThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayLamThe.setColumns(10);
        txNgayLamThe.setBounds(509, 51, 207, 29);
        pnInfo.add(txNgayLamThe);

        JLabel lbNgayHetHan = new JLabel("Ngày hết hạn:");
        lbNgayHetHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayHetHan.setBounds(368, 90, 131, 30);
        pnInfo.add(lbNgayHetHan);

        txNgayHetHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayHetHan.setColumns(10);
        txNgayHetHan.setBounds(509, 91, 207, 29);
        pnInfo.add(txNgayHetHan);


        btnGiaHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnGiaHan.setBounds(368, 126, 348, 30);
        pnInfo.add(btnGiaHan);


        btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXacNhan.setBounds(879, 160, 119, 30);
        btnXacNhan.setBackground(new Color(210, 224, 251));
        btnXacNhan.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        pnInfo.add(btnXacNhan);


        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(750, 160, 119, 30);
        btnHuy.setBackground(new Color(140, 51, 51));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        pnInfo.add(btnHuy);


        btnReload.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReload.setBounds(1137, 126, 119, 30);
        btnReload.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnReload.setBackground(new Color(131, 162, 255));
        pnInfo.add(btnReload);

        scrollPane.setBounds(10, 292, 1266, 411);
        contentPane.add(scrollPane);



    }

    private void addDBToTable(ArrayList<ThanhVien> lstThanhVien){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã thành viên");
        nModel.addColumn("Họ lót");
        nModel.addColumn("Tên");
        nModel.addColumn("Số điện thoại");
        nModel.addColumn("Email");
        nModel.addColumn("Địa chỉ");
        nModel.addColumn("Ngày đăng ký");
        nModel.addColumn("Hạn sử dụng");

        for (ThanhVien tv:lstThanhVien){
            Vector data = new Vector<>();
            data.add(tv.getMaThanhVien());
            data.add(tv.getHoLot());
            data.add(tv.getTen());
            data.add(tv.getSdt());
            data.add(tv.getEmail());
            data.add(tv.getDiaChi());
            data.add(tv.getNgayTao());
            data.add(tv.getHanThe());
            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        table.setRowHeight(30);
    }
    private void setData(){
        int row = table.getSelectedRow();
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        ThanhVien tv = thanhVienBUS.getTVByID(Integer.parseInt(String.valueOf(table.getValueAt(row,0))));

        txMaTV.setText(String.valueOf(tv.getMaThanhVien()));
        txHoLot.setText(tv.getHoLot());
        txTen.setText(tv.getTen());
        txSDT.setText(tv.getSdt());
        txDiaChi.setText(tv.getDiaChi());
        txEmail.setText(tv.getEmail());
        txNgayLamThe.setText(tv.getNgayTao());
        txNgayHetHan.setText(tv.getHanThe());

    }
    private void turnOffEdit(){
        txMaTV.setEditable(false);
        txHoLot.setEditable(false);
        txTen.setEditable(false);
        txSDT.setEditable(false);
        txDiaChi.setEditable(false);
        txEmail.setEditable(false);
        txNgayLamThe.setEditable(false);
        txNgayHetHan.setEditable(false);

        btnHuy.setVisible(false);
        btnXacNhan.setVisible(false);
        btnGiaHan.setEnabled(false);
        btnSua.setVisible(true);
    }
    private void turnOnEdit(){
        txHoLot.setEditable(true);
        txTen.setEditable(true);
        txSDT.setEditable(true);
        txDiaChi.setEditable(true);
        txEmail.setEditable(true);

        btnHuy.setVisible(true);
        btnXacNhan.setVisible(true);
        btnGiaHan.setEnabled(true);
        btnSua.setVisible(false);
    }
    private void huyData(){
        turnOffEdit();
    }
    private boolean checkData(){
        CheckTool checkTool  = new CheckTool();
        if (!checkTool.checkName(txHoLot.getText())){
            JOptionPane.showMessageDialog(null,"Họ lót không hợp lệ !");
            return false;
        }
        if (!checkTool.checkName(txTen.getText())){
            JOptionPane.showMessageDialog(null,"Tên không lợp lệ!");
            return false;
        }
        if (!checkTool.isValidPhoneNum(txSDT.getText())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
            return false;
        }
        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
            return false;
        }
        if (txDiaChi.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền địa chỉ!");
            return false;
        }

        return true;
    }
    private void updateData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn sửa thông tin thành viên!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
                ThanhVien tv = thanhVienBUS.getTVByID(Integer.parseInt(txMaTV.getText()));
                tv.setEmail(txEmail.getText());
                tv.setDiaChi(txDiaChi.getText());
                tv.setHoLot(txHoLot.getText());
                tv.setTen(txTen.getText());
                tv.setNgayTao(txNgayLamThe.getText());
                tv.setHanThe(txNgayHetHan.getText());
                tv.setSdt(txSDT.getText());

                thanhVienBUS.updateData(tv);
                turnOffEdit();
                JOptionPane.showMessageDialog(null,"Đã chỉnh sửa thông tin của thành viên thành công!");
            }
        }
    }
    private void giaHan(){
        int choice = JOptionPane.showConfirmDialog(null,"Gia hạn sử dụng thẻ thành viên thêm 1 tháng?","Xác nhận",JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            LocalDate hanThe = LocalDate.parse(txNgayHetHan.getText());
            hanThe = hanThe.plusMonths(1);
            String ngayHetHan = String.valueOf(hanThe.getDayOfMonth());
            String thangHetHan = String.valueOf(hanThe.getMonthValue());
            String namHetHan = String.valueOf(hanThe.getYear());

            if (Integer.parseInt(ngayHetHan) <10){
                ngayHetHan = "0"+ngayHetHan;
            }
            if (Integer.parseInt(thangHetHan) <10){
                thangHetHan = "0"+thangHetHan;
            }
            txNgayHetHan.setText(namHetHan + "-" + thangHetHan + "-" + ngayHetHan);
        }
    }
    private void timThanhVien(){
        String item = String.valueOf(cbTim.getSelectedItem());
        String data = txTim.getText();

        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        addDBToTable(thanhVienBUS.timThanhVien(item,data));
    }
    public static void main(String[] args) {
        ThanhVienGUI thanhVienGUI = new ThanhVienGUI();
        thanhVienGUI.setVisible(true);
    }
}
