package GUI;

import BUS.QuyDinhBUS;
import DTO.NhaCungCap;
import DTO.QuyDinh;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class QuyDinhGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txMaQD = new JTextField();
    private JTextField txPhanTram= new JTextField();
    private JTextField txNoiDung= new JTextField();

    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);

//    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnXacNhan = new JButton("");
    private JButton btnHuy = new JButton("");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuyDinhGUI frame = new QuyDinhGUI();
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
    public QuyDinhGUI() {
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
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblQuynh = new JLabel("QUY ĐỊNH");
        lblQuynh.setForeground(new Color(255, 255, 255));
        lblQuynh.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuynh.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(lblQuynh);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(null);
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);

        JLabel lblMQuynh = new JLabel("Mã quy định:");
        lblMQuynh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMQuynh.setBounds(10, 10, 142, 30);
        pnInfo.add(lblMQuynh);

        JLabel lblNiDung = new JLabel("Nội dung:");
        lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNiDung.setBounds(10, 65, 124, 30);
        pnInfo.add(lblNiDung);

        JLabel lblTinPht = new JLabel("% Tiền phạt theo giá sách:");
        lblTinPht.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTinPht.setBounds(283, 10, 256, 30);
        pnInfo.add(lblTinPht);

        txMaQD.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txMaQD.setColumns(10);
        txMaQD.setBounds(162, 11, 111, 29);
        pnInfo.add(txMaQD);

        txPhanTram.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txPhanTram.setColumns(10);
        txPhanTram.setBounds(537, 11, 189, 29);
        pnInfo.add(txPhanTram);

        txNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txNoiDung.setColumns(10);
        txNoiDung.setBounds(162, 66, 563, 29);
        pnInfo.add(txNoiDung);




//        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        btnThem.setBounds(1137, 160, 119, 30);
//        pnInfo.add(btnThem);


        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setIcon(new ImageIcon("src/IMG/anh/sua.png"));
        btnSua.setBackground(new Color(242, 238, 157));
        btnSua.setBounds(1008, 160, 119, 30);
        pnInfo.add(btnSua);


        btnXacNhan.setBounds(907, 160, 91, 30);
        btnXacNhan.setBackground(new Color(210, 224, 251));
        btnXacNhan.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        pnInfo.add(btnXacNhan);


        btnHuy.setBounds(808, 160, 89, 30);
        btnHuy.setBackground(new Color(140, 51, 51));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        pnInfo.add(btnHuy);

        scrollPane.setBounds(10, 292, 1266, 411);
        contentPane.add(scrollPane);

        QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
        addDBToTable(quyDinhBUS.getLst());

        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                huyData();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOnEdit();
            }
        });
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuyDinhBUS quyDinhBUS1 = new QuyDinhBUS();
                updateData();
                addDBToTable(quyDinhBUS1.getLst());
            }
        });
        turnOffEdit();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setData();
            }
        });
//        btnThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                FormThemQuyDinh form = new FormThemQuyDinh();
//                form.setVisible(true);
//            }
//        });
    }
    private void addDBToTable(ArrayList<QuyDinh> lstQD){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã quy định");
        nModel.addColumn("Nội dung");
        nModel.addColumn("Phần trăm phạt");


        for (QuyDinh quyDinh:lstQD){
            Vector data = new Vector<>();
            data.add(quyDinh.getMaQuyDinh());
            data.add(quyDinh.getTenQuyDinh());
            data.add(quyDinh.getTienPhat());

            nModel.addRow(data);
        }
        table.setModel(nModel);
        table.setFont(new Font("Tahoma",0,15));
        table.setRowHeight(30);
    }
    private void turnOffEdit(){
        txMaQD.setEditable(false);
        txPhanTram.setEditable(false);
        txNoiDung.setEditable(false);

        btnSua.setVisible(true);
        btnHuy.setVisible(false);
        btnXacNhan.setVisible(false);
    }
    private void turnOnEdit(){
        int row = table.getSelectedRow();
        if (row <0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn một quy định để sửa!");
            return;
        }
        txNoiDung.setEditable(true);
        txPhanTram.setEditable(true);
        btnHuy.setVisible(true);
        btnSua.setVisible(false);
        btnXacNhan.setVisible(true);
    }
    private void huyData(){
        btnSua.setVisible(true);
        btnXacNhan.setVisible(false);
        btnHuy.setVisible(false);

        turnOffEdit();
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
    private void updateData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn chỉnh sửa quy định!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                QuyDinhBUS quyDinhBUS = new QuyDinhBUS();
                QuyDinh quyDinh = new QuyDinh();
                quyDinh.setMaQuyDinh(Integer.parseInt(txMaQD.getText()));
                quyDinh.setTenQuyDinh(txNoiDung.getText());
                quyDinh.setTienPhat(Integer.parseInt(txPhanTram.getText()));
                quyDinhBUS.updateData(quyDinh);
                JOptionPane.showMessageDialog(null,"Đã cập nhật quy định thành công!");
                turnOffEdit();
            }
        }
    }
    private void setData(){
        int row = table.getSelectedRow();
        QuyDinhBUS quyDinhBUS = new QuyDinhBUS();

        QuyDinh quyDinh = quyDinhBUS.getLst().get(row);
        txMaQD.setText(String.valueOf(quyDinh.getMaQuyDinh()));
        txNoiDung.setText(quyDinh.getTenQuyDinh());
        txPhanTram.setText(String.valueOf(quyDinh.getTienPhat()));

    }
}
