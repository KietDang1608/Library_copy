package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import DTO.NhanVien;
import DTO.PhieuPhat;
import GUI.Mybutton;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class TaiKhoanGUI extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */

    NhanVienBUS bus = new NhanVienBUS();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TaiKhoanGUI frame = new TaiKhoanGUI();
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
    public TaiKhoanGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Quản Lý Tài Khoản");
        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(new Color(33, 115, 70));
        pnTitle.setBounds(0, 0, 1300, 60);
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        pnTitle.add(lblNewLabel);
        contentPane.add(pnTitle);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(25, 81, 1238, 111);
        contentPane.add(panel);
        panel.setLayout(null);

//		Mybutton btnThem = new Mybutton();
//		btnThem.setIcon(new ImageIcon("..\\eclipse-workspace\\CNPM\\src\\img\\Add-User.png"));
//		btnThem.setForeground(new Color(255, 255, 255));
//		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnThem.setColor(new Color(33, 115, 70));
//		btnThem.setText("Thêm Tài Khoản");
//		btnThem.setBounds(32, 22, 233, 64);
//		panel.add(btnThem);
//
//		btnThem.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				FormTaiKhoan formTaiKhoan=new FormTaiKhoan();
//				formTaiKhoan.setVisible(true);
//
//			}
//		});

        Mybutton btnRefresh = new Mybutton();
        btnRefresh.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnRefresh.setForeground(new Color(255, 255, 255));
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRefresh.setColor(new Color(33, 115, 70));
        btnRefresh.setText("Refresh");
        btnRefresh.setBounds(32, 22, 233, 64);//297
        panel.add(btnRefresh);
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadData();


            }
        });

        table = new JTable();
        table.setBounds(25, 251, 1238, 449);
        contentPane.add(table);

        JLabel lblNewLabel_1 = new JLabel("Bảng Thông Tin");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(35, 203, 176, 37);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 251, 1238, 449);
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
        table.setFont(new Font("Tahoma",0,20));
        table.setRowHeight(30);
    }


    public void loadData() {
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Tên Tài Khoản");
        nModel.addColumn("Mật Khẩu");
        table.setModel(nModel);


        for(NhanVien nhanvien : bus.getLst())
        {
            Vector data = new Vector();
            data.add(nhanvien.getMaNV());
            data.add(nhanvien.getPassword());
            nModel.addRow(data);
        }

        table.setModel(nModel);
    }
}