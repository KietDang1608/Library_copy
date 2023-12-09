package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.PhieuPhatBUS;
import BUS.SachBUS;
import BUS.ThanhVienBUS;
import BUS.QuyDinhBUS;
import DTO.PhieuNhap;
import DTO.PhieuPhat;
import DTO.QuyDinh;
import DTO.Sach;
import DTO.ThanhVien;
import GUI.Mybutton;

public class PhieuPhatGUI extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    PhieuPhatBUS bus = new PhieuPhatBUS();
    SachBUS bussach = new SachBUS();
    ThanhVienBUS busTV = new ThanhVienBUS();
    QuyDinhBUS busQD = new QuyDinhBUS();
    PhieuPhat pp = new PhieuPhat();
    private JTextField tx_TimKiem;
    private JTextField tx_MaSach;
    private JTextField tx_MaPhieuPhat;
    private JTextField tx_TenSach;
    private JTextField tx_MaThanhVien;
    private JTextField tx_TenThanhVien;
    private JTextField tx_MaPhieuMuon;
    private JTextField tx_MaQuyDinh;
    private JTextField tx_TenQuyDinh;
    private JTextField tx_NgayPhat;
    private JTextField tx_MoTa;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhieuPhatGUI frame = new PhieuPhatGUI();
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
    public PhieuPhatGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(25, 96, 1238, 216);
        contentPane.add(panel);
        panel.setLayout(null);

        Mybutton btnThem = new Mybutton();
        btnThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setColor(new Color(33, 115, 70));
        btnThem.setText("Thêm");
        btnThem.setBounds(819, 116, 184, 40);
        panel.add(btnThem);

        btnThem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                FormPhat formPhat=new FormPhat();
                formPhat.setVisible(true);

            }
        });

        Mybutton btnRefresh = new Mybutton();
        btnRefresh.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnRefresh.setBackground(new Color(131, 162, 255));
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRefresh.setText("Refresh");
        btnRefresh.setBounds(1027, 116, 184, 40);
        panel.add(btnRefresh);

        JButton btnPDF = new JButton("In PDF");
        btnPDF.setIcon(new ImageIcon("src/IMG/anh/update.png"));
        btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPDF.setBounds(1027, 170, 184, 40);
        btnPDF.setBackground(Color.orange);
        panel.add(btnPDF);

        btnPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row <0){
                    JOptionPane.showMessageDialog(null,"Hãy chọn một phiếu phạt để in PDF");
                }else {
                    PhieuPhatBUS phieuPhatBUS = new PhieuPhatBUS();
                    PhieuPhat pp = phieuPhatBUS.getPPByID(Integer.parseInt(String.valueOf(table.getValueAt(row,0))));
                    phieuPhatBUS.inPhieuPhat(pp);
                }
            }
        });
        JLabel lb_MaPhieuPhat = new JLabel("Mã Phiếu Phạt:");
        lb_MaPhieuPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MaPhieuPhat.setBounds(10, 11, 134, 29);
        panel.add(lb_MaPhieuPhat);

        JLabel lb_MaSach = new JLabel("Mã Sách:");
        lb_MaSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MaSach.setBounds(10, 54, 86, 29);
        panel.add(lb_MaSach);

        tx_MaSach = new JTextField();
        tx_MaSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MaSach.setBounds(106, 51, 48, 29);
        panel.add(tx_MaSach);
        tx_MaSach.setColumns(10);
        tx_MaSach.setEditable(false);

        tx_MaPhieuPhat = new JTextField();
        tx_MaPhieuPhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MaPhieuPhat.setBounds(164, 11, 223, 29);
        panel.add(tx_MaPhieuPhat);
        tx_MaPhieuPhat.setColumns(10);
        tx_MaPhieuPhat.setEditable(false);

        tx_TenSach = new JTextField();
        tx_TenSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_TenSach.setBounds(164, 51, 223, 29);
        panel.add(tx_TenSach);
        tx_TenSach.setColumns(10);
        tx_TenSach.setEditable(false);

        JLabel lb_MaThanhVien = new JLabel("Mã Thành Viên:");
        lb_MaThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MaThanhVien.setBounds(10, 94, 145, 29);
        panel.add(lb_MaThanhVien);

        tx_MaThanhVien = new JTextField();
        tx_MaThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MaThanhVien.setBounds(164, 94, 223, 29);
        panel.add(tx_MaThanhVien);
        tx_MaThanhVien.setColumns(10);
        tx_MaThanhVien.setEditable(false);

        JLabel lb_TenThanhVien = new JLabel("Tên Thành Viên:");
        lb_TenThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_TenThanhVien.setBounds(10, 134, 151, 29);
        panel.add(lb_TenThanhVien);

        tx_TenThanhVien = new JTextField();
        tx_TenThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_TenThanhVien.setBounds(164, 134, 223, 29);
        panel.add(tx_TenThanhVien);
        tx_TenThanhVien.setColumns(10);
        tx_TenThanhVien.setEditable(false);

        JLabel lb_MaPhieuMuon = new JLabel("Mã Phiếu Mượn:");
        lb_MaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MaPhieuMuon.setBounds(10, 174, 145, 31);
        panel.add(lb_MaPhieuMuon);

        tx_MaPhieuMuon = new JTextField();
        tx_MaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MaPhieuMuon.setBounds(164, 174, 223, 31);
        panel.add(tx_MaPhieuMuon);
        tx_MaPhieuMuon.setColumns(10);
        tx_MaPhieuMuon.setEditable(false);

        JLabel lb_MaQuyDinh = new JLabel("Mã Quy Định:");
        lb_MaQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MaQuyDinh.setBounds(419, 11, 134, 29);
        panel.add(lb_MaQuyDinh);

        JLabel lb_TenQuyDinh = new JLabel("Tên Quy Định:");
        lb_TenQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_TenQuyDinh.setBounds(419, 54, 134, 29);
        panel.add(lb_TenQuyDinh);

        JLabel lb_NgayPhat = new JLabel("Ngày Phạt:");
        lb_NgayPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_NgayPhat.setBounds(419, 94, 134, 29);
        panel.add(lb_NgayPhat);

        JLabel lb_TrangThai = new JLabel("Trạng Thái:");
        lb_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_TrangThai.setBounds(419, 134, 127, 29);
        panel.add(lb_TrangThai);

        JLabel lb_MoTa = new JLabel("Mô Tả:");
        lb_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_MoTa.setBounds(419, 174, 127, 29);
        panel.add(lb_MoTa);

        tx_MaQuyDinh = new JTextField();
        tx_MaQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MaQuyDinh.setColumns(10);
        tx_MaQuyDinh.setBounds(553, 11, 224, 29);
        panel.add(tx_MaQuyDinh);
        tx_MaQuyDinh.setEditable(false);

        tx_TenQuyDinh = new JTextField();
        tx_TenQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_TenQuyDinh.setColumns(10);
        tx_TenQuyDinh.setBounds(553, 51, 224, 29);
        panel.add(tx_TenQuyDinh);
        tx_TenQuyDinh.setEditable(false);

        tx_NgayPhat = new JTextField();
        tx_NgayPhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_NgayPhat.setColumns(10);
        tx_NgayPhat.setBounds(553, 94, 224, 29);
        panel.add(tx_NgayPhat);
        tx_NgayPhat.setEditable(false);

        JComboBox cb_TrangThai = new JComboBox();
        cb_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cb_TrangThai.setBounds(553, 134, 224, 29);
        cb_TrangThai.addItem("Đã nộp tiền phạt");
        cb_TrangThai.addItem("Chưa nộp tiền phạt");
        panel.add(cb_TrangThai);

        tx_MoTa = new JTextField();
        tx_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tx_MoTa.setColumns(10);
        tx_MoTa.setBounds(553, 174, 224, 31);
        panel.add(tx_MoTa);
        tx_MoTa.setEditable(false);

        Mybutton btnSua = new Mybutton();
        btnSua.setText("Sửa");
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setColor(new Color(242, 238, 157));
        btnSua.setBounds(1027, 36, 184, 40);
        btnSua.setForeground(Color.black);
        btnSua.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        panel.add(btnSua);

        JButton btnSua_nho = new JButton("Sửa");
        btnSua_nho.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua_nho.setBounds(819, 36, 86, 40);
        btnSua_nho.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        panel.add(btnSua_nho);
        btnSua_nho.setVisible(false);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHuy.setBackground(new Color(140, 51, 51));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btnHuy.setBounds(917, 36, 86, 40);
        panel.add(btnHuy);
        btnHuy.setVisible(false);

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() <0){
                    JOptionPane.showMessageDialog(null,"Hãy chọn một phiếu phạt để sửa thông tin!");
                }
                else {
                    if (cb_TrangThai.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null,"Thành viên đã nộp phạt, không thể sửa thông tin!");
                    }
                    else {
                        btnSua.setVisible(false);
                        btnSua_nho.setVisible(true);
                        btnHuy.setVisible(true);
                    }
                }
            }
        });


        btnSua_nho.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for(PhieuPhat pp : bus.getLst()) {
                    if(Integer.parseInt(tx_MaPhieuPhat.getText()) == pp.getMaPhieuPhat()) {
                        if(cb_TrangThai.getSelectedItem().equals("Đã nộp tiền phạt")) {
                            pp.setTrangThai("true");
                        }
                        else {
                            pp.setTrangThai("false");
                        }
                        bus.updatedata(pp);
                    }
                }


            }
        });

        btnHuy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btnSua_nho.setVisible(false);
                btnHuy.setVisible(false);
                btnSua.setVisible(true);

            }
        });
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadData();


            }
        });

        JLabel lblNewLabel_1 = new JLabel("Bảng Thông Tin");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(35, 323, 176, 37);
        contentPane.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(33, 115, 70));
        panel_1.setBounds(25, 25, 1238, 60);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("PHIẾU PHẠT");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(522, 11, 215, 45);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

        tx_TimKiem = new JTextField();
        tx_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tx_TimKiem.setBounds(993, 323, 176, 37);
        contentPane.add(tx_TimKiem);
        tx_TimKiem.setColumns(10);

        JComboBox cb_TimKiem = new JComboBox();
        cb_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cb_TimKiem.setBounds(812, 323, 171, 37);
        contentPane.add(cb_TimKiem);
        cb_TimKiem.addItem("Mã Phiếu Phạt");
        cb_TimKiem.addItem("Mã Thành Viên");
        cb_TimKiem.addItem("Mã Phiếu Mượn");

        JButton btn_TimKiem = new JButton("");
        btn_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_TimKiem.setBounds(1179, 323, 84, 37);
        btn_TimKiem.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        contentPane.add(btn_TimKiem);
        btn_TimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cb =cb_TimKiem.getSelectedItem().toString();
                int txnhap = Integer.parseInt(tx_TimKiem.getText());
                ArrayList<PhieuPhat> phieuphatlist = bus.find(cb,txnhap);
                setTableData(phieuphatlist);
            }
        });


        JLabel lb_TimKiem = new JLabel("Tìm Kiếm:");
        lb_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lb_TimKiem.setBounds(700, 323, 102, 37);
        contentPane.add(lb_TimKiem);

        table = new JTable();
        table.setBounds(25, 371, 1238, 449);//1238 449
        table.setRowHeight(30);
        table.setAutoscrolls(true);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int rowIndex = table.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                tx_MaPhieuPhat.setText(model.getValueAt(rowIndex, 0).toString());
                tx_MaSach.setText(model.getValueAt(rowIndex, 1).toString());

                for(Sach sach : bussach.getLst()) {
                    if(sach.getMaSach()==Integer.parseInt(tx_MaSach.getText().toString())) {
                        tx_TenSach.setText(sach.getTenSach());
                    }
                }
                tx_MaThanhVien.setText(model.getValueAt(rowIndex, 2).toString());
                for(ThanhVien thanhvien : busTV.getLst()) {
                    if(thanhvien.getMaThanhVien()==Integer.parseInt(tx_MaThanhVien.getText().toString())) {
                        tx_TenThanhVien.setText(thanhvien.getHoLot() + " " +thanhvien.getTen());
                    }
                }
                tx_MaPhieuMuon.setText(model.getValueAt(rowIndex, 3).toString());
                tx_MaQuyDinh.setText(model.getValueAt(rowIndex, 4).toString());
                for(QuyDinh quydinh : busQD.getLst()) {
                    if(quydinh.getMaQuyDinh()==Integer.parseInt(tx_MaQuyDinh.getText().toString())) {
                        tx_TenQuyDinh.setText(quydinh.getTenQuyDinh());
                    }
                }
                tx_NgayPhat.setText(model.getValueAt(rowIndex, 5).toString());
                String status = model.getValueAt(rowIndex, 6).toString();
                switch(status) {
                    case "Đã nộp tiền phạt":
                        cb_TrangThai.setSelectedIndex(0);
                        break;
                    case "Chưa nộp tiền phạt":
                        cb_TrangThai.setSelectedIndex(1);
                        break;
                }
                tx_MoTa.setText(model.getValueAt(rowIndex, 7).toString());
                System.out.println(bus.getTienPhat(Integer.parseInt(tx_MaSach.getText()),Integer.parseInt(tx_MaQuyDinh.getText())));
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 371, 1238, 449);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Thêm JScrollPane vào frame
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Tạo thanh cuộn bên phải
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(0, 0, contentPane.getWidth(), 17);
        contentPane.add(scrollBar, BorderLayout.EAST);
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Cập nhật vị trí của jtable
                table.scrollRectToVisible(new Rectangle(0, e.getValue(), table.getWidth(), table.getHeight()));
            }
        });

        loadData();
    }

    public void loadData() {
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã Phiếu Phạt");
        nModel.addColumn("Mã Sách");
        nModel.addColumn("Mã Thành Viên");
        nModel.addColumn("Mã Phiếu Mượn");
        nModel.addColumn("Mã Quy Định");
        nModel.addColumn("Ngày Phạt");
        nModel.addColumn("Trạng Thái");
        nModel.addColumn("Mô Tả");
        table.setModel(nModel);


        for(PhieuPhat phieuphat : bus.getLst())
        {
            Vector data = new Vector();
            data.add(phieuphat.getMaPhieuPhat());
            data.add(phieuphat.getMaSach());
            data.add(phieuphat.getMaThanhVien());
            data.add(phieuphat.getMaPhieuMuon());
            data.add(phieuphat.getMaQuyDinh());
            data.add(phieuphat.getNgayPhat());
            if(phieuphat.getTrangThai().toLowerCase().equals("true")) {
                data.add("Đã nộp tiền phạt");
            }
            else {
                data.add("Chưa nộp tiền phạt");
            }

            data.add(phieuphat.getMoTa());

            nModel.addRow(data);
        }

        table.setModel(nModel);
    }
    public void setTableData(ArrayList<PhieuPhat> lpp) {
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã Phiếu Phạt");
        nModel.addColumn("Mã Sách");
        nModel.addColumn("Mã Thành Viên");
        nModel.addColumn("Mã Phiếu Mượn");
        nModel.addColumn("Mã Quy Định");
        nModel.addColumn("Ngày Phạt");
        nModel.addColumn("Trạng Thái");
        nModel.addColumn("Mô Tả");
        table.setModel(nModel);


        for(PhieuPhat phieuphat : lpp)
        {
            Vector data = new Vector();
            data.add(phieuphat.getMaPhieuPhat());
            data.add(phieuphat.getMaSach());
            data.add(phieuphat.getMaThanhVien());
            data.add(phieuphat.getMaPhieuMuon());
            data.add(phieuphat.getMaQuyDinh());
            data.add(phieuphat.getNgayPhat());
            if(phieuphat.getTrangThai().toLowerCase().equals("true")) {
                data.add("Đã nộp tiền phạt");
            }
            else {
                data.add("Chưa nộp tiền phạt");
            }

            data.add(phieuphat.getMoTa());

            nModel.addRow(data);
        }

        table.setModel(nModel);
    }

}