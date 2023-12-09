package GUI;

import BUS.NhanVienBUS;
import CheckInfo.CheckTool;
import DTO.NhanVien;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FormThemNV extends JFrame {

    private JPanel contentPane;
    private JTextField txMaNV = new JTextField();
    private JTextField txMaViTri= new JTextField();
    private JTextField txHoLot= new JTextField();
    private JTextField txTen= new JTextField();
    private JTextField txDiaChi= new JTextField();
    private JTextField txSDT= new JTextField();
    private JTextField txEmail= new JTextField();
    private DatePicker txNgayLam= new DatePicker();
    private JComboBox cbViTri = new JComboBox();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormThemNV frame = new FormThemNV();
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
    public FormThemNV() {
        setBounds(600, 200, 599, 601);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        cbViTri.addItem("Thủ thư");
        cbViTri.addItem("Quản lý");
        cbViTri.addItem("Trực kho");
        cbViTri.addItem("Admin");
        cbViTri.setSelectedIndex(0);
        cbViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBackground(Color.yellow);
        btnXoa.setIcon(new ImageIcon("src/IMG/anh/xoa.png"));
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBounds(10, 522, 150, 31);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btnHuy.setBackground(Color.red);
        btnHuy.setBounds(223, 522, 150, 31);
        contentPane.add(btnHuy);

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(426, 522, 150, 31);
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThem.setForeground(Color.white);
        contentPane.add(btnThem);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 566, 42);
        contentPane.add(panel);

        JLabel lblThmNhnVin = new JLabel("THÊM NHÂN VIÊN");
        lblThmNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
        lblThmNhnVin.setForeground(Color.WHITE);
        lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThmNhnVin.setBackground(new Color(33, 115, 70));
        panel.add(lblThmNhnVin);

        JLabel lbMaNV = new JLabel("Mã NV:");
        lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNV.setBounds(10, 84, 76, 30);
        contentPane.add(lbMaNV);

        JLabel lbViTri = new JLabel("Vị trí:");
        lbViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbViTri.setBounds(10, 120, 76, 30);
        contentPane.add(lbViTri);

        JLabel lbHoLot = new JLabel("Họ lót:");
        lbHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbHoLot.setBounds(10, 160, 76, 30);
        contentPane.add(lbHoLot);

        JLabel lbTen = new JLabel("Tên:");
        lbTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTen.setBounds(10, 200, 76, 30);
        contentPane.add(lbTen);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(10, 356, 76, 30);
        contentPane.add(lbDiaChi);

        txMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNV.setColumns(10);
        txMaNV.setBounds(85, 84, 491, 29);
        contentPane.add(txMaNV);

        txMaViTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaViTri.setColumns(10);
        txMaViTri.setBounds(85, 121, 51, 29);
        contentPane.add(txMaViTri);

        txHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txHoLot.setColumns(10);
        txHoLot.setBounds(85, 160, 491, 29);
        contentPane.add(txHoLot);

        txTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTen.setColumns(10);
        txTen.setBounds(85, 200, 491, 29);
        contentPane.add(txTen);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(85, 357, 491, 29);
        contentPane.add(txDiaChi);

        JLabel lbSdt = new JLabel("SĐT:");
        lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSdt.setBounds(10, 240, 76, 30);
        contentPane.add(lbSdt);

        txSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSDT.setColumns(10);
        txSDT.setBounds(85, 241, 491, 29);
        contentPane.add(txSDT);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(10, 276, 76, 30);
        contentPane.add(lbEmail);

        txEmail = new JTextField();
        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(85, 277, 491, 29);
        contentPane.add(txEmail);

        JLabel lbNgayLam = new JLabel("Ngày làm:");
        lbNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayLam.setBounds(10, 316, 131, 30);
        contentPane.add(lbNgayLam);


        txNgayLam.setBounds(150, 316, 391, 29);
        contentPane.add(txNgayLam);

        cbViTri.setBounds(146, 120, 429, 30);
        contentPane.add(cbViTri);

        txMaViTri.setEditable(false);
        setTxMaVT();
        cbViTri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTxMaVT();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkData()) {
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm nhân viên?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        NhanVien nv = new NhanVien();
                        NhanVienBUS nhanVienBUS = new NhanVienBUS();
                        CheckTool checkTool = new CheckTool();
                        nv.setMaNV(txMaNV.getText());
                        nv.setMaViTri(Integer.parseInt(txMaViTri.getText()));
                        nv.setPassword("1");
                        nv.setHoLot(checkTool.formatName(txHoLot.getText()));
                        nv.setTen(checkTool.formatName(txTen.getText()));
                        nv.setSdt(txSDT.getText());
                        nv.setEmail(txEmail.getText());
                        nv.setDiaChi(checkTool.formatInfo(txDiaChi.getText()));
                        nv.setNgaylam(txNgayLam.getDate());
                        nv.setNgayNghi(null);
                        nhanVienBUS.insertData(nv);
                        JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công!");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đã hủy thêm!");
                    }
                }
            }
        });
    }
    public void setTxMaVT(){
        int i = cbViTri.getSelectedIndex();
        txMaViTri.setText(String.valueOf(i+1));
    }
    public boolean checkData(){
        CheckTool checkTool = new CheckTool();
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        if (!checkTool.isValidUsername(txMaNV.getText())){
            JOptionPane.showMessageDialog(null,"Mã nhân viên không hợp lệ (>=5 ký tự (a-z,A-Z,0-9) và không chứa dấu cách)");
            return false;
        }
        if (!nhanVienBUS.checkID(txMaNV.getText())){
            JOptionPane.showMessageDialog(null,"Mã nhân viên trùng, hãy thử mã khác!");
            return false;
        }
        if (!checkTool.checkName(txHoLot.getText())){
            JOptionPane.showMessageDialog(null,"Họ lót không hợp lệ!");
            return false;
        }
        if (!checkTool.checkName(txTen.getText())){
            JOptionPane.showMessageDialog(null,"Tên không hợp lệ!");
            return false;
        }
        if (!checkTool.isValidPhoneNum(txSDT.getText())){
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
            return false;
        }
        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
            return false;
        }

        String s = txNgayLam.getDate();
        LocalDate date = txNgayLam.getLocalDate(s);
        LocalDate dateNow = LocalDate.now();
        if (checkTool.compareDate(date,dateNow) ==-1){
            JOptionPane.showMessageDialog(null,"Ngày làm không được nhỏ hơn ngày hiện hành!");
            return false;

        }
        if (txDiaChi.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Địa chỉ không hợp lệ!");
            return false;
        }
        return true;
    }
}
