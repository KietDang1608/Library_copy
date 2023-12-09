package GUI;

import BUS.LoginBUS;
import BUS.NhanVienBUS;
import CheckInfo.CheckTool;
import DTO.NhanVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TKCaNhanGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txMaNV = new JTextField();
    private JTextField txMaViTri = new JTextField();
    private JTextField txTenViTri= new JTextField();
    private JTextField txPassword= new JTextField();
    private JTextField txSDT= new JTextField();
    private JTextField txHoLot= new JTextField();
    private JTextField txTen= new JTextField();
    private JTextField txEmail= new JTextField();
    private JTextField txDiaChi= new JTextField();
    private JTextField txNgayLam= new JTextField();
    private JTextField txNgayNghi= new JTextField();
    private JButton btnSua = new JButton("Sửa");
    private JButton btnHuy = new JButton("Hủy");
    private JButton btnXacNhan = new JButton("Xác nhận");


    private JTextField[] txFields ={txPassword,txSDT,txEmail,txDiaChi};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TKCaNhanGUI frame = new TKCaNhanGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public TKCaNhanGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 1266, 62);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(33, 115, 70));

        JLabel lbTitle = new JLabel("TÀI KHOẢN CÁ NHÂN");
        lbTitle.setBounds(460, 15, 342, 37);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbTitle.setForeground(Color.white);
        panel.add(lbTitle);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 103, 1266, 582);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lbinfo = new JLabel("Thông tin");
        lbinfo.setBounds(585, 5, 110, 25);
        lbinfo.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_1.add(lbinfo);

        JLabel lbMaNV = new JLabel("Mã nhân viên:");
        lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNV.setBounds(36, 94, 130, 35);
        panel_1.add(lbMaNV);

        JLabel lbViTri = new JLabel("Vị trí:");
        lbViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbViTri.setBounds(36, 169, 54, 35);
        panel_1.add(lbViTri);

        JLabel lbPassword = new JLabel("Mật khẩu:");
        lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbPassword.setBounds(36, 246, 95, 35);
        panel_1.add(lbPassword);

        JLabel lbSDT = new JLabel("Số điện thoại:");
        lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSDT.setBounds(36, 326, 130, 35);
        panel_1.add(lbSDT);

        JLabel lbHoLot = new JLabel("Họ lót:");
        lbHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbHoLot.setBounds(499, 94, 65, 35);
        panel_1.add(lbHoLot);

        JLabel lbTen = new JLabel("Tên:");
        lbTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTen.setBounds(499, 169, 54, 35);
        panel_1.add(lbTen);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(499, 326, 65, 35);
        panel_1.add(lbEmail);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(499, 246, 76, 35);
        panel_1.add(lbDiaChi);

        JLabel lbNgayLam = new JLabel("Ngày vào làm:");
        lbNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayLam.setBounds(879, 94, 136, 35);
        panel_1.add(lbNgayLam);

        JLabel lbNgayNghi = new JLabel("Ngày nghỉ:");
        lbNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayNghi.setBounds(879, 169, 103, 35);
        panel_1.add(lbNgayNghi);

        txMaNV.setEditable(false);
        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setBounds(176, 94, 122, 31);
        panel_1.add(txMaNV);
        txMaNV.setColumns(10);

        txMaViTri.setEditable(false);
        txMaViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaViTri.setColumns(10);
        txMaViTri.setBounds(92, 173, 65, 31);
        panel_1.add(txMaViTri);

        txTenViTri.setEditable(false);
        txTenViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenViTri.setColumns(10);
        txTenViTri.setBounds(176, 171, 263, 31);
        panel_1.add(txTenViTri);

        txPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txPassword.setColumns(10);
        txPassword.setBounds(176, 246, 263, 31);
        panel_1.add(txPassword);

        txSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSDT.setColumns(10);
        txSDT.setBounds(176, 330, 263, 31);
        panel_1.add(txSDT);

        txHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txHoLot.setColumns(10);
        txHoLot.setBounds(585, 94, 263, 31);
        panel_1.add(txHoLot);

        txTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTen.setColumns(10);
        txTen.setBounds(585, 171, 263, 31);
        panel_1.add(txTen);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(585, 330, 263, 31);
        panel_1.add(txEmail);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(585, 246, 671, 31);
        panel_1.add(txDiaChi);

        txNgayLam.setEditable(false);
        txNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayLam.setColumns(10);
        txNgayLam.setBounds(1018, 96, 238, 31);
        panel_1.add(txNgayLam);

        txNgayNghi.setEditable(false);
        txNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayNghi.setColumns(10);
        txNgayNghi.setBounds(1018, 169, 238, 31);
        panel_1.add(txNgayNghi);

        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setBounds(1075, 537, 181, 35);
        panel_1.add(btnSua);


        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(865, 537, 181, 35);
        panel_1.add(btnHuy);


        btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXacNhan.setBounds(653, 537, 181, 35);
        panel_1.add(btnXacNhan);
        btnSua.setBackground(new Color(33, 115, 70));
        btnXacNhan.setBackground(new Color(33, 115, 70));
        btnSua.setForeground(Color.white);
        btnXacNhan.setForeground(Color.white);
        btnHuy.setBackground(Color.red);

        btnXacNhan.setVisible(false);
        btnHuy.setVisible(false);

        txHoLot.setEditable(false);
        txTen.setEditable(false);

        turnOffTField();
        setData();
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editData();
            }
        });
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmData();
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                huyData();
            }
        });
    }

    public void turnOffTField(){
        for (JTextField textField:txFields){
            textField.setEditable(false);
        }
    }
    public void turnOnTField(){
        for (JTextField textField:txFields){
            textField.setEditable(true);
        }
    }

    public void setData(){
        LoginBUS loginBUS = new LoginBUS();
        String username = loginBUS.getUsername();
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVien nv = nhanVienBUS.getNVByID(username);

        txMaNV.setText(nv.getMaNV());
        txHoLot.setText(nv.getHoLot());
        txTen.setText(nv.getTen());
        txMaViTri.setText(String.valueOf(nv.getMaViTri()));
        txTenViTri.setText(nhanVienBUS.getTenViTri(nv.getMaViTri()));
        txEmail.setText(nv.getEmail());
        txPassword.setText(nv.getPassword());
        txDiaChi.setText(nv.getDiaChi());
        txNgayLam.setText(nv.getNgaylam());
        txNgayNghi.setText(nv.getNgayNghi());
        txSDT.setText(nv.getSdt());
    }
    public void editData(){
        btnSua.setVisible(false);
        btnXacNhan.setVisible(true);
        btnHuy.setVisible(true);
        turnOnTField();
    }
    public void confirmData(){

        if (checkData()) {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){

                NhanVienBUS nhanVienBUS = new NhanVienBUS();
                NhanVien nv = nhanVienBUS.getNVByID(txMaNV.getText());
                nv.setPassword(txPassword.getText());
                nv.setDiaChi(txDiaChi.getText());
                nv.setSdt(txSDT.getText());
                nv.setEmail(txEmail.getText());

                nhanVienBUS.updateData(nv);

                btnSua.setVisible(true);
                btnXacNhan.setVisible(false);
                btnHuy.setVisible(false);
                turnOffTField();
                JOptionPane.showMessageDialog(null,"Chỉnh sửa thông tin thành công!");

            }
            else {
                JOptionPane.showMessageDialog(null,"Đã hủy chỉnh sửa!");

            }
        }
    }
    public void huyData(){
        setData();
        btnSua.setVisible(true);
        btnXacNhan.setVisible(false);
        btnHuy.setVisible(false);
        turnOffTField();
    }
    public boolean checkData(){
        CheckTool checkTool = new CheckTool();

        if (!checkTool.isValidPassword(txPassword.getText())){
            JOptionPane.showMessageDialog(null,"Mật khẩu không đúng định dạng(không được để trống hoặc có dấu cách)");
            txPassword.requestFocus();
            return false;
        }
        if (!checkTool.isValidPhoneNum(txSDT.getText())){
            JOptionPane.showMessageDialog(null,"Số điện thoại không đúng định dạng!");
            txSDT.requestFocus();
            return false;
        }
        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không đúng định dạng!");
            txEmail.requestFocus();
            return false;
        }
        txDiaChi.setText(checkTool.formatInfo(txDiaChi.getText()));
        return true;
    }
}
