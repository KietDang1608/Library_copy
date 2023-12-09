package GUI;

import BUS.ThanhVienBUS;
import CheckInfo.CheckTool;
import DTO.ThanhVien;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FormThemTV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txMaTV = new JTextField();
    private JTextField txHoLot= new JTextField();
    private JTextField txTen= new JTextField();
    private JTextField txDiaChi= new JTextField();
    private JTextField txSDT= new JTextField();
    private JTextField txEmail= new JTextField();
    private JTextField txNgayLamTHe= new JTextField();
    private JTextField txNgayHetHan= new JTextField();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormThemTV frame = new FormThemTV();
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
    public FormThemTV() {
        setBounds(600, 100, 600, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnXoa.setBackground(Color.yellow);
        btnXoa.setIcon(new ImageIcon("src/IMG/anh/xoa.png"));
        btnXoa.setBounds(10, 522, 150, 31);
        contentPane.add(btnXoa);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btnHuy.setBackground(Color.red);
        btnHuy.setBounds(223, 522, 150, 31);
        contentPane.add(btnHuy);

        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.white);
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setBounds(426, 522, 150, 31);
        contentPane.add(btnThem);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(10, 10, 566, 42);
        contentPane.add(panel);

        JLabel lbTitle = new JLabel("THÊM THÀNH VIÊN");
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbTitle.setBackground(new Color(33, 115, 70));
        panel.add(lbTitle);

        JLabel lbMaTV = new JLabel("Mã TV:");
        lbMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaTV.setBounds(10, 84, 76, 30);
        contentPane.add(lbMaTV);

        JLabel lbHoLot = new JLabel("Họ lót:");
        lbHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbHoLot.setBounds(10, 124, 76, 30);
        contentPane.add(lbHoLot);

        JLabel lbTen = new JLabel("Tên:");
        lbTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTen.setBounds(10, 164, 76, 30);
        contentPane.add(lbTen);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(10, 356, 76, 30);
        contentPane.add(lbDiaChi);

        txMaTV.setEditable(false);
        txMaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaTV.setColumns(10);
        txMaTV.setBounds(85, 84, 491, 29);
        contentPane.add(txMaTV);

        txHoLot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txHoLot.setColumns(10);
        txHoLot.setBounds(85, 124, 491, 29);
        contentPane.add(txHoLot);

        txTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTen.setColumns(10);
        txTen.setBounds(85, 164, 491, 29);
        contentPane.add(txTen);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(85, 357, 491, 29);
        contentPane.add(txDiaChi);

        JLabel lbSdt = new JLabel("SĐT:");
        lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSdt.setBounds(10, 204, 76, 30);
        contentPane.add(lbSdt);

        txSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txSDT.setColumns(10);
        txSDT.setBounds(85, 205, 491, 29);
        contentPane.add(txSDT);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(10, 240, 76, 30);
        contentPane.add(lbEmail);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txEmail.setColumns(10);
        txEmail.setBounds(85, 241, 491, 29);
        contentPane.add(txEmail);

        JLabel lblNgyLmTh = new JLabel("Ngày làm thẻ:");
        lblNgyLmTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNgyLmTh.setBounds(10, 280, 131, 30);
        contentPane.add(lblNgyLmTh);

        txNgayLamTHe.setEditable(false);
        txNgayLamTHe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayLamTHe.setColumns(10);
        txNgayLamTHe.setBounds(185, 280, 391, 29);
        contentPane.add(txNgayLamTHe);

        JLabel lbNgayHetHan = new JLabel("Ngày hết hạn:");
        lbNgayHetHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgayHetHan.setBounds(10, 320, 131, 30);
        contentPane.add(lbNgayHetHan);

        txNgayHetHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNgayHetHan.setEditable(false);
        txNgayHetHan.setColumns(10);
        txNgayHetHan.setBounds(185, 320, 391, 29);
        contentPane.add(txNgayHetHan);

        setNgay();
        setMaTV();
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
                updateData();
            }
        });
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

    private void xoaData(){
        txHoLot.setText("");
        txDiaChi.setText("");
        txEmail.setText("");
        txTen.setText("");
        txSDT.setText("");
    }
    private void huyData(){
        JOptionPane.showMessageDialog(null,"Đã hủy thêm thành viên!");
        setVisible(false);
    }
    private void setNgay(){
        LocalDate ngayTao = LocalDate.now();
        LocalDate ngayHet = ngayTao.plusMonths(1);

        String dayTao = String.valueOf(ngayTao.getDayOfMonth());
        String monthTao = String.valueOf(ngayTao.getMonthValue());
        String yearTao = String.valueOf(ngayTao.getYear());

        String dayHet = String.valueOf(ngayHet.getDayOfMonth());
        String monthHet = String.valueOf(ngayHet.getMonthValue());
        String yearHet = String.valueOf(ngayHet.getYear());

        txNgayLamTHe.setText( yearTao+"-"+monthTao + "-"+dayTao);
        txNgayHetHan.setText( yearHet+"-"+monthHet + "-"+dayHet);
    }
    private void setMaTV(){
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        txMaTV.setText(String.valueOf(thanhVienBUS.getLst().size() + 1));
    }
    private void updateData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm thành viên!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
                ThanhVien tv = new ThanhVien();
                tv.setMaThanhVien(Integer.parseInt(txMaTV.getText()));
                tv.setEmail(txEmail.getText());
                tv.setDiaChi(txDiaChi.getText());
                tv.setHoLot(txHoLot.getText());
                tv.setTen(txTen.getText());
                tv.setNgayTao(txNgayLamTHe.getText());
                tv.setHanThe(txNgayHetHan.getText());
                tv.setSdt(txSDT.getText());

                thanhVienBUS.insertLst(tv);
                JOptionPane.showMessageDialog(null,"Đã thêm thành viên thành công!");
                setVisible(false);
            }
        }
    }
}
