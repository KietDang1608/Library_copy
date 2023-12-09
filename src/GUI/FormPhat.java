package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import BUS.CT_PhieuMuonBUS;
import BUS.PhieuMuonBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuPhatBUS;
import BUS.QuyDinhBUS;
import BUS.SachBUS;
import BUS.ThanhVienBUS;
import DTO.CT_PhieuMuon;
import DTO.NhaCungCap;
import DTO.PhieuMuon;
import DTO.PhieuNhap;
import DTO.PhieuPhat;
import DTO.QuyDinh;
import DTO.Sach;
import DTO.ThanhVien;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class FormPhat extends JFrame {

    private JPanel PanelPhat;
    private JTextField textField_MaPhieu;
    private JTextField textField_NgayPhat;
    private JTextField textField_MoTa;
    private Mybutton btnClear;

    /**
     * Launch the application.
     */
    PhieuPhatBUS busPP = new PhieuPhatBUS();
    SachBUS busSach = new SachBUS();
    ThanhVienBUS busTV = new ThanhVienBUS();
    QuyDinhBUS busQD = new QuyDinhBUS();
    PhieuMuonBUS busPM = new PhieuMuonBUS();
    CT_PhieuMuonBUS busCTPM = new CT_PhieuMuonBUS();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPhat frame = new FormPhat();
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
    public FormPhat() {
        setBounds(600, 100, 613, 453);
        PanelPhat = new JPanel();
        PanelPhat.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(PanelPhat);
        PanelPhat.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 115, 70));
        panel.setBounds(0, 0, 597, 66);
        PanelPhat.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập Thông Tin Phiếu");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(195, 11, 229, 40);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel Label_MaPhieuPhat = new JLabel("Mã Phiếu Phạt");
        Label_MaPhieuPhat.setForeground(new Color(33, 115, 70));
        Label_MaPhieuPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MaPhieuPhat.setBounds(24, 77, 141, 37);
        PanelPhat.add(Label_MaPhieuPhat);

        textField_MaPhieu = new JTextField();
        textField_MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_MaPhieu.setBounds(175, 77, 101, 37);
        PanelPhat.add(textField_MaPhieu);
        textField_MaPhieu.setColumns(10);
        textField_MaPhieu.setEditable(false);
        //Tự động lấy mã phiếu
        textField_MaPhieu.setText(Integer.toString(busPP.getLst().size()+1));

        JLabel Label_MaTV = new JLabel("Mã Thành Viên");
        Label_MaTV.setForeground(new Color(33, 115, 70));
        Label_MaTV.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MaTV.setBounds(24, 136, 141, 37);
        PanelPhat.add(Label_MaTV);

        JLabel Label_MaQD = new JLabel("Mã Quy Định");
        Label_MaQD.setForeground(new Color(33, 115, 70));
        Label_MaQD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MaQD.setBounds(24, 195, 141, 37);
        PanelPhat.add(Label_MaQD);

        JLabel Label_TrangThai = new JLabel("Trạng Thái");
        Label_TrangThai.setForeground(new Color(33, 115, 70));
        Label_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_TrangThai.setBounds(24, 254, 141, 37);
        PanelPhat.add(Label_TrangThai);

        JLabel Label_MaSach = new JLabel("Mã Sách");
        Label_MaSach.setForeground(new Color(33, 115, 70));
        Label_MaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MaSach.setBounds(308, 136, 141, 37);
        PanelPhat.add(Label_MaSach);

        JLabel Label_MaPhieuMuon = new JLabel("Mã Phiếu Mượn");
        Label_MaPhieuMuon.setForeground(new Color(33, 115, 70));
        Label_MaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MaPhieuMuon.setBounds(308, 77, 141, 37);
        PanelPhat.add(Label_MaPhieuMuon);

        JLabel Label_NgayPhat = new JLabel("Ngày Phạt");
        Label_NgayPhat.setForeground(new Color(33, 115, 70));
        Label_NgayPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_NgayPhat.setBounds(308, 195, 101, 37);
        PanelPhat.add(Label_NgayPhat);

        textField_NgayPhat = new JTextField();
        textField_NgayPhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_NgayPhat.setEditable(false);
        textField_NgayPhat.setColumns(10);
        textField_NgayPhat.setBounds(474, 195, 101, 37);
        PanelPhat.add(textField_NgayPhat);

        JLabel Label_MoTa = new JLabel("Mô Tả");
        Label_MoTa.setForeground(new Color(33, 115, 70));
        Label_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Label_MoTa.setBounds(24, 313, 141, 37);
        PanelPhat.add(Label_MoTa);

        JRadioButton rdbtn_true = new JRadioButton("Đã thu tiền phạt\r\n");
        rdbtn_true.setForeground(new Color(119, 119, 255));
        rdbtn_true.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtn_true.setBounds(175, 256, 178, 37);
        PanelPhat.add(rdbtn_true);
        rdbtn_true.setName("true false");

        JRadioButton rdbtn_false = new JRadioButton("Chưa thu tiền phạt");
        rdbtn_false.setForeground(new Color(119, 119, 255));
        rdbtn_false.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtn_false.setBounds(384, 256, 193, 37);
        PanelPhat.add(rdbtn_false);
        rdbtn_false.setName("true_false");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtn_true);
        buttonGroup.add(rdbtn_false);

        JButton btnCalender = new JButton("");
        btnCalender.setVisible(false);
        btnCalender.setBounds(424, 195, 40, 40);
        btnCalender.setIcon(new ImageIcon("src/IMG/anh/calendar.png"));
        btnCalender.setBorder(null);
        PanelPhat.add(btnCalender);

        textField_MoTa = new JTextField();
        textField_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_MoTa.setColumns(10);
        textField_MoTa.setBounds(175, 313, 303, 37);
        PanelPhat.add(textField_MoTa);

        JComboBox cb_MaThanhVien = new JComboBox();
        cb_MaThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cb_MaThanhVien.setBounds(175, 136, 101, 37);
        PanelPhat.add(cb_MaThanhVien);
        DefaultComboBoxModel<Integer> modelTV = new DefaultComboBoxModel<>();
        for(ThanhVien tv : busTV.getLst()) {
            modelTV.addElement(tv.getMaThanhVien());
        }
        cb_MaThanhVien.setModel(modelTV);


        JComboBox cb_MaQuyDinh = new JComboBox();
        cb_MaQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cb_MaQuyDinh.setBounds(175, 195, 101, 37);
        PanelPhat.add(cb_MaQuyDinh);
        DefaultComboBoxModel<Integer> modelQD = new DefaultComboBoxModel<>();
        for(QuyDinh qd : busQD.getLst()) {
            modelQD.addElement(qd.getMaQuyDinh());
        }
        cb_MaQuyDinh.setModel(modelQD);


        JComboBox cb_MaSach = new JComboBox();
        cb_MaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cb_MaSach.setBounds(474, 136, 101, 37);
        PanelPhat.add(cb_MaSach);
        DefaultComboBoxModel<Integer> modelSach = new DefaultComboBoxModel<>();

        JComboBox cb_MaPhieuMuon = new JComboBox();
        cb_MaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cb_MaPhieuMuon.setBounds(474, 77, 101, 37);
        PanelPhat.add(cb_MaPhieuMuon);
        DefaultComboBoxModel<Integer> modelPM = new DefaultComboBoxModel<>();
        for(PhieuMuon pm : busPM.getLst()) {
            modelPM.addElement(pm.getMaPhieu());
        }
        cb_MaPhieuMuon.setModel(modelPM);


        cb_MaPhieuMuon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                modelSach.removeAllElements();
                // TODO Auto-generated method stub
                for(CT_PhieuMuon ctpm : busCTPM.getLst()) {
                    if(String.valueOf(cb_MaPhieuMuon.getSelectedItem()).equals(String.valueOf(ctpm.getMaPhieu()))) {
                        modelSach.addElement(ctpm.getMaSach());
                    }
                }
                cb_MaSach.setModel(modelSach);
            }
        });






//		for(CT_PhieuMuon ctpm : busCTPM.getLst()) {
//			modelPM.addElement(ctpm.getMaPhieu());
//        }
//        cb_MaPhieuMuon.setModel(modelPM);


        Mybutton btnAdd = new Mybutton();
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdd.setColor(new Color(33, 115, 70));
        btnAdd.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnAdd.setText("Thêm");
        btnAdd.setBounds(400, 361, 94, 40);//
        btnAdd.setBorder(null);
        PanelPhat.add(btnAdd);

        btnClear = new Mybutton();
        btnClear.setText("Xóa");
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClear.setColor(Color.yellow);//
        btnClear.setIcon(new ImageIcon("src/IMG/anh/xoa.png"));
        btnClear.setBorder(null);
        btnClear.setBounds(111, 361, 94, 40);
        PanelPhat.add(btnClear);

        Mybutton btnCancel = new Mybutton();
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancel.setColor(Color.red);
        btnCancel.setText("Hủy");
        btnCancel.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btnCancel.setBounds(250,361,94,40);
        btnCancel.setBorder(null);
        PanelPhat.add(btnCancel);

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(isNotBlank(textField_MoTa.getText())==true && isNotBlank(textField_NgayPhat.getText())==true && (rdbtn_true.isSelected() || rdbtn_false.isSelected())) {
                    PhieuPhat pp = new PhieuPhat();
                    pp.setMaPhieuPhat(Integer.parseInt(textField_MaPhieu.getText()));
                    pp.setMaSach(Integer.parseInt(cb_MaSach.getSelectedItem().toString()));
                    pp.setMaThanhVien(Integer.parseInt(cb_MaThanhVien.getSelectedItem().toString()));
                    pp.setMaPhieuMuon(Integer.parseInt(cb_MaPhieuMuon.getSelectedItem().toString()));
                    pp.setMaQuyDinh(Integer.parseInt(cb_MaQuyDinh.getSelectedItem().toString()));
                    pp.setNgayPhat(textField_NgayPhat.getText());
                    if(rdbtn_true.isSelected()) {
                        pp.setTrangThai("true");
                    }
                    else {
                        pp.setTrangThai("false");
                    }
                    pp.setMoTa(textField_MoTa.getText());
                    busPP.insertLst(pp);
                    //Tự động lấy mã phiếu
                    textField_MaPhieu.setText(Integer.toString(busPP.getLst().size()+1));
                    textField_NgayPhat.setText("");
                    textField_MoTa.setText("");
                    buttonGroup.clearSelection();
                    JOptionPane.showMessageDialog(PanelPhat, "Thêm dữ liệu thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(PanelPhat, "Không được bỏ trống thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);				}
            }
        });

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                setVisible(false);
            }
        });

        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField_NgayPhat.setText("");
                textField_MoTa.setText("");
                buttonGroup.clearSelection();
            }
        });
        setNgayPhat();
        btnCalender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo khung lịch
                JCalendar calendar = new JCalendar();
                // Lấy ngày hiện tại
                Calendar currentDate = Calendar.getInstance();
                // Chuyển đổi đối tượng Calendar thành đối tượng Date
                Date date = currentDate.getTime();
                // Đặt ngày hiện tại cho khung lịch
                calendar.setDate(date);

                // Tạo dialog để hiển thị khung lịch

                // Tạo hộp thoại
                JDialog dialog = new JDialog();

                // Đặt mô hình cho hộp thoại
                dialog.setModal(true);
                dialog.getContentPane().add(calendar);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(PanelPhat);
                dialog.setVisible(true);

                // Lấy ngày tháng năm đã chọn
                int year = calendar.getCalendar().get(Calendar.YEAR);
                int month = calendar.getCalendar().get(Calendar.MONTH);
                int day = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);

                // Hiển thị ngày tháng năm đã chọn lên JTextField
                textField_NgayPhat.setText(String.format("%d-%d-%d", year, month + 1, day));
            }
        });





    }
    private boolean isNotBlank(String text) {
        // Kiểm tra xem text có dữ liệu không
        return !text.isEmpty();
    }
    private void setNgayPhat(){
        LocalDate date = LocalDate.now();
        String day = String.valueOf(date.getDayOfMonth());
        String month = String.valueOf(date.getMonthValue());
        String year = String.valueOf(date.getYear());
        textField_NgayPhat.setText(year + "-" + month + "-" + day);
    }
}