package GUI;

import BUS.QuyDinhBUS;
import DTO.QuyDinh;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormThemQuyDinh extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txMaQD = new JTextField();
    private JTextField txNoiDung= new JTextField();
    private JTextField txPhanTram= new JTextField();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormThemQuyDinh frame = new FormThemQuyDinh();
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
    public FormThemQuyDinh() {
        setBounds(600, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbMaQD = new JLabel("Mã quy định:");
        lbMaQD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaQD.setBounds(29, 101, 131, 34);
        contentPane.add(lbMaQD);

        JLabel lbNoiDung = new JLabel("Nội dung:");
        lbNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNoiDung.setBounds(29, 163, 131, 34);
        contentPane.add(lbNoiDung);

        JLabel lbTienPhat = new JLabel("Phần trăm tiền phạt theo giá sách:");
        lbTienPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTienPhat.setBounds(29, 227, 322, 34);
        contentPane.add(lbTienPhat);

        txMaQD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaQD.setColumns(10);
        txMaQD.setBounds(170, 103, 406, 31);
        contentPane.add(txMaQD);

        txNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNoiDung.setColumns(10);
        txNoiDung.setBounds(170, 163, 406, 31);
        contentPane.add(txNoiDung);

        txPhanTram.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txPhanTram.setColumns(10);
        txPhanTram.setBounds(376, 227, 200, 31);
        contentPane.add(txPhanTram);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBounds(10, 522, 150, 31);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBounds(223, 522, 150, 31);
        contentPane.add(btnHuy);

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(426, 522, 150, 31);
        contentPane.add(btnThem);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 566, 42);
        contentPane.add(panel);

        JLabel lblThmQuynh = new JLabel("THÊM QUY ĐỊNH");
        lblThmQuynh.setHorizontalAlignment(SwingConstants.CENTER);
        lblThmQuynh.setForeground(Color.WHITE);
        lblThmQuynh.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThmQuynh.setBackground(new Color(33, 115, 70));
        panel.add(lblThmQuynh);

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
        setMaQuyDinh();
        txMaQD.setEditable(false);
    }

    private void xoaData(){
        txNoiDung.setText("");
        txPhanTram.setText("");
    }
    private void huyData(){
        JOptionPane.showMessageDialog(null,"Đã hủy thêm quy định mới!");
        setVisible(false);
    }
    private void setMaQuyDinh(){
        QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
        int newIndex = quyDinhBUS.getLst().size()+1;
        txMaQD.setText(String.valueOf(newIndex));
    }
    private boolean checkData(){
        boolean checkNumber =false;
        try{
            int n = Integer.parseInt(txPhanTram.getText());
            checkNumber = true;
        }catch (NumberFormatException e){
            checkNumber = false;
        }
        if (!checkNumber){
            JOptionPane.showMessageDialog(null,"Phần trăm tiền phạt theo giá sách phải là số nguyên!");
            return false;
        }
        if (txNoiDung.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập nội dung quy định!");
            return false;
        }
        return true;
    }
    private void themData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm quy định!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
                QuyDinh quyDinh = new QuyDinh();
                quyDinh.setMaQuyDinh(Integer.parseInt(txMaQD.getText()));
                quyDinh.setTenQuyDinh(txNoiDung.getText());
                quyDinh.setTienPhat(Integer.parseInt(txPhanTram.getText()));
                quyDinhBUS.insertLst(quyDinh);
                JOptionPane.showMessageDialog(null,"Đã thêm quy định thành công!");
                setVisible(false);
            }
        }
    }
}
