package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import CheckInfo.CheckTool;
import DTO.NhaCungCap;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class NhaCungCapGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txMaNCC = new JTextField();
    private JTextField txTenNCC= new JTextField();
    private JTextField txSdt= new JTextField();
    private JTextField txEmail= new JTextField();
    private JTextField txDiaChi= new JTextField();
    private JTextField txTim = new JTextField();
    private JTable tbNCC = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tbNCC);

    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnHuy = new JButton("");
    private JButton btnXacNhan = new JButton("");
    private JComboBox cbTim = new JComboBox();
    Icon them = new ImageIcon("src/IMG/anh/them.png");
    Icon sua = new ImageIcon("src/IMG/anh/sua.png");


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NhaCungCapGUI frame = new NhaCungCapGUI();
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
    public NhaCungCapGUI() {
        cbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        cbTim.addItem("Mã NCC");
        cbTim.addItem("Tên NCC");
        cbTim.addItem("SĐT");
        cbTim.addItem("Địa chỉ");
        cbTim.addItem("Email");

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 1266, 62);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lbTitle = new JLabel("NHÀ CUNG CẤP");
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbTitle.setForeground(Color.white);
        panel.add(lbTitle);
        panel.setBackground(new Color(33, 115, 70));

        JPanel pnInfo = new JPanel();
        pnInfo.setBounds(10, 82, 1266, 200);
        contentPane.add(pnInfo);
        pnInfo.setLayout(null);

        JLabel lbMaNCC = new JLabel("Mã NCC:");
        lbMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbMaNCC.setBounds(10, 10, 83, 30);
        pnInfo.add(lbMaNCC);

        JLabel lbTenNCC = new JLabel("Tên NCC:");
        lbTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTenNCC.setBounds(10, 86, 93, 30);
        pnInfo.add(lbTenNCC);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDiaChi.setBounds(10, 160, 83, 30);
        pnInfo.add(lbDiaChi);

        JLabel lbSDT = new JLabel("SĐT:");
        lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbSDT.setBounds(413, 10, 55, 30);
        pnInfo.add(lbSDT);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbEmail.setBounds(413, 86, 66, 30);
        pnInfo.add(lbEmail);

        txMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txMaNCC.setBounds(100, 10, 303, 29);
        pnInfo.add(txMaNCC);
        txMaNCC.setColumns(10);

        txTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txTenNCC.setColumns(10);
        txTenNCC.setBounds(100, 87, 303, 29);
        pnInfo.add(txTenNCC);

        txSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txSdt.setColumns(10);
        txSdt.setBounds(472, 11, 303, 29);
        pnInfo.add(txSdt);

        txEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txEmail.setColumns(10);
        txEmail.setBounds(472, 86, 303, 29);
        pnInfo.add(txEmail);

        txDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txDiaChi.setColumns(10);
        txDiaChi.setBounds(100, 161, 675, 29);
        pnInfo.add(txDiaChi);

        JLabel lbTim = new JLabel("Tìm theo:");
        lbTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbTim.setBounds(808, 10, 111, 30);
        pnInfo.add(lbTim);


        cbTim.setSelectedIndex(0);
        cbTim.setBounds(907, 10, 349, 30);
        pnInfo.add(cbTim);

        txTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txTim.setBounds(808, 86, 397, 30);
        pnInfo.add(txTim);
        txTim.setColumns(10);

        JButton btnTim = new JButton("");
        btnTim.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTim.setBounds(1205, 86, 51, 30);
        pnInfo.add(btnTim);

        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThem.setBackground(new Color(33, 115, 70));
        btnThem.setForeground(Color.white);
        btnThem.setBounds(1137, 160, 119, 30);
        btnThem.setIcon(them);
        pnInfo.add(btnThem);

        JButton btnRef = new JButton("Refresh");
        btnRef.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnRef.setBackground(new Color(131, 162, 255));
        btnRef.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnInfo.add(btnRef);
        btnRef.setBounds(1137, 120, 119, 30);
        btnRef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
                addDBToTable(nhaCungCapBUS.getLst());
            }
        });
        btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSua.setBounds(1008, 160, 119, 30);
        btnSua.setBackground(new Color(242, 238, 157));
        btnSua.setIcon(sua);
        pnInfo.add(btnSua);

        scrollPane.setBounds(10, 292, 1266, 411);
        contentPane.add(scrollPane);


        pnInfo.add(btnHuy);
        btnHuy.setBounds(950,160,50,30);
        btnHuy.setBackground(new Color(140, 51, 51));
        btnHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        pnInfo.add(btnXacNhan);
        btnXacNhan.setBounds(890,160,50,30);
        btnXacNhan.setIcon(new ImageIcon("src/IMG/anh/xacNhan.png"));
        btnXacNhan.setBackground(new Color(210, 224, 251));

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormThemNCC themNCC = new FormThemNCC();
                themNCC.setVisible(true);
            }
        });
        tbNCC.setFont(new Font("Tahoma",0,15));
        tbNCC.setRowHeight(30);
        NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();

        addDBToTable(nhaCungCapBUS.getLst());

        turnOffEdit();

        tbNCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setData();
            }
        });
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timNCC();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOnEdit();
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
                NhaCungCapBUS nhaCungCapBUS1 = new NhaCungCapBUS();
                addDBToTable(nhaCungCapBUS1.getLst());
            }
        });
    }
    public void turnOffEdit(){
        txMaNCC.setEditable(false);
        txTenNCC.setEditable(false);
        txDiaChi.setEditable(false);
        txEmail.setEditable(false);
        txSdt.setEditable(false);
        btnSua.setVisible(true);
        btnHuy.setVisible(false);
        btnXacNhan.setVisible(false);
    }
    public void addDBToTable(ArrayList<NhaCungCap> lstNCC){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("Mã NCC");
        nModel.addColumn("Tên NCC");
        nModel.addColumn("Địa chỉ");
        nModel.addColumn("Email");
        nModel.addColumn("Số điện thoại");

        for (NhaCungCap ncc:lstNCC){
            Vector data = new Vector<>();
            data.add(ncc.getMaNCC());
            data.add(ncc.getTenNCC());
            data.add(ncc.getDiaChi());
            data.add(ncc.getEmail());
            data.add(ncc.getSdt());
            nModel.addRow(data);
        }
        tbNCC.setModel(nModel);
        TableColumnModel columnModel = tbNCC.getColumnModel();

        TableColumn column = columnModel.getColumn(0);
        column.setPreferredWidth(5);

    }
    public void setData(){
        int row = tbNCC.getSelectedRow();
        NhaCungCapBUS nccBus = new NhaCungCapBUS();
        NhaCungCap ncc = nccBus.getLst().get(row);

        txMaNCC.setText(String.valueOf(ncc.getMaNCC()));
        txTenNCC.setText(ncc.getTenNCC());
        txDiaChi.setText(ncc.getDiaChi());
        txSdt.setText(ncc.getSdt());
        txEmail.setText(ncc.getEmail());
    }
    public void timNCC(){
        String data = txTim.getText();
        String item = String.valueOf(cbTim.getSelectedItem());
        NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
        ArrayList<NhaCungCap> lstFound = nhaCungCapBUS.timNCC(item,data);

        addDBToTable(lstFound);
    }
    public void huyData(){
        btnSua.setVisible(true);
        btnXacNhan.setVisible(false);
        btnHuy.setVisible(false);

        turnOffEdit();
    }
    public void turnOnEdit(){
        if (tbNCC.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn một nhà cung cấp để sửa thông tin!");
            return;
        }
        txTenNCC.setEditable(true);
        txEmail.setEditable(true);
        txSdt.setEditable(true);
        txDiaChi.setEditable(true);

        btnSua.setVisible(false);
        btnHuy.setVisible(true);
        btnXacNhan.setVisible(true);
    }

    public boolean checkData(){
        CheckTool checkTool = new CheckTool();
        if (!checkTool.isValidEmail(txEmail.getText())){
            JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
            return false;
        }
        if (!checkTool.isValidPhoneNum(txSdt.getText())){
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!");
            return false;
        }if (txTenNCC.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền tên nhà cung cấp!");
            return false;
        }
        if (txDiaChi.getText().length()<1){
            JOptionPane.showMessageDialog(null,"Vui lòng điền địa chỉ!");
            return false;

        }
        return true;
    }
    public void updateData(){
        if (checkData()){
            int choice = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn chỉnh sửa thông tin nhà cung cấp!","Xác nhận",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(Integer.parseInt(txMaNCC.getText()));
                ncc.setTenNCC(txTenNCC.getText());
                ncc.setDiaChi(txDiaChi.getText());
                ncc.setEmail(txEmail.getText());
                ncc.setSdt(txSdt.getText());
                nhaCungCapBUS.updateData(ncc);
                JOptionPane.showMessageDialog(null,"Chỉnh sửa thông tin nhà cung cấp thành công!");
                turnOffEdit();
            }

        }
    }
}
