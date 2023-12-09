package GUI;

import BUS.NhaCungCapBUS;
import CheckInfo.CheckTool;
import DTO.NhaCungCap;


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormThemNCC extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txMaNCC = new JTextField();
    private JTextField txTenNCC = new JTextField();
    private JTextField txEmail = new JTextField();
    private JTextField txSdt = new JTextField();
    private JTextField txDiaChi = new JTextField();
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
                    FormThemNCC frame = new FormThemNCC();
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
    public FormThemNCC() {
        setBounds(600, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbMaNCC = new JLabel("Mã NCC:");
        lbMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNCC.setBounds(29, 101, 88, 34);
        contentPane.add(lbMaNCC);

        JLabel lbTenNCC = new JLabel("Tên NCC:");
        lbTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTenNCC.setBounds(29, 163, 88, 34);
        contentPane.add(lbTenNCC);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(29, 227, 88, 34);
        contentPane.add(lbEmail);

        JLabel lbSDT = new JLabel("SĐT:");
        lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSDT.setBounds(29, 291, 88, 34);
        contentPane.add(lbSDT);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(29, 358, 88, 34);
        contentPane.add(lbDiaChi);

        txMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaNCC.setBounds(148, 101, 428, 31);
        contentPane.add(txMaNCC);
        txMaNCC.setColumns(10);

        txTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTenNCC.setColumns(10);
        txTenNCC.setBounds(148, 163, 428, 31);
        contentPane.add(txTenNCC);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(148, 227, 428, 31);
        contentPane.add(txEmail);

        txSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSdt.setColumns(10);
        txSdt.setBounds(148, 291, 428, 31);
        contentPane.add(txSdt);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(148, 358, 428, 31);
        contentPane.add(txDiaChi);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBounds(10, 510, 150, 31);
        btnXoa.setIcon(xoa);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(223, 510, 150, 31);
        btnHuy.setIcon(huy);
        contentPane.add(btnHuy);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBounds(426, 510, 150, 31);
        btnThem.setForeground(Color.white);
        btnThem.setIcon(them);
        contentPane.add(btnThem);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 566, 42);
        contentPane.add(panel);

        JLabel lbTitle = new JLabel("THÊM NHÀ CUNG CẤP");
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbTitle.setBackground(new Color(33, 115, 70));
        panel.add(lbTitle);

        txMaNCC.setEditable(false);
        btnHuy.setBackground(Color.red);
        btnXoa.setBackground(Color.yellow);
        setMaNCC();
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaData();
            }
        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                huyData();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themData();
            }
        });

    }
    public void setMaNCC(){
        NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
        int newInDex = nhaCungCapBUS.getLst().size() +1;
        txMaNCC.setText(String.valueOf(newInDex));
    }
    public boolean checkData(){
        CheckTool checkTool = new CheckTool();

        if (txTenNCC.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền tên nhà cung cấp!");
            return false;
        }

        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
            return false;
        }
        if (!checkTool.isValidPhoneNum(txSdt.getText())){
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
            return false;
        }
        if(txDiaChi.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền địa chỉ!");
            return false;
        }
        return true;
    }

    public void xoaData(){
        txEmail.setText("");
        txTenNCC.setText("");
        txSdt.setText("");
        txDiaChi.setText("");
    }
    public void huyData(){
        JOptionPane.showMessageDialog(null,"Đã hủy thêm nhà cung cấp mới!");
        setVisible(false);
    }
    public void themData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm nhà cung cấp!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(Integer.parseInt(txMaNCC.getText()));
                ncc.setTenNCC(txTenNCC.getText());
                ncc.setDiaChi(txDiaChi.getText());
                ncc.setEmail(txEmail.getText());
                ncc.setSdt(txSdt.getText());
                nhaCungCapBUS.insertData(ncc);
                JOptionPane.showMessageDialog(null,"Thêm nhà cung cấp thành công!");
                setVisible(false);
            }
        }
    }
}
