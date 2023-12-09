package GUI;

import BUS.SachBUS;
import BUS.theLoai_bus;
import CheckInfo.CheckTool;
import DTO.Sach;
import DTO.TheLoai;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class FormThemSach extends JFrame {
    private JLabel lbTitle = new JLabel("                       THÊM SÁCH");
    private JLabel lbImgPath = new JLabel("Chọn ảnh:");
    private JLabel lbBookID2 = new JLabel("Mã sách: ");
    private JLabel lbBookName2 = new JLabel("Tên sách: ");
    private JLabel lbCategory2 = new JLabel("Thể loại: ");
    private JLabel lbAuthor2 = new JLabel("Tác giả: ");
    private JLabel lbNXB2 = new JLabel("Nhà XB: ");
    private JLabel lbNamXB2 = new JLabel("Năm XB: ");
    private JLabel lbSoLuong2 = new JLabel("SL: ");

    private JLabel[] labels = {lbTitle,lbImgPath,lbBookID2,lbBookName2,lbCategory2,lbAuthor2,lbNXB2,lbNamXB2,lbSoLuong2};

    public JTextField txMaSach = new JTextField();
    public JTextField txTheLoai = new JTextField();
    public JTextField txTenSach = new JTextField();
    public JTextField txTacGia = new JTextField();
    public JTextField txNhaXuatBan = new JTextField();
    public JTextField txNamXuatBan = new JTextField();
    public JTextField txSoLuong = new JTextField();
    public JTextField txImgPath = new JTextField();

    private JTextField[] textFields = {txMaSach,txTheLoai,txTenSach,txTacGia,txNhaXuatBan,txNamXuatBan,txSoLuong,txImgPath};

    private JComboBox cbTheLoai = new JComboBox();

    private JButton btXoa = new JButton("Xóa");
    private JButton btHuy = new JButton("Hủy");
    private JButton btThem = new JButton("Thêm");
    private JButton btHinh = new JButton("");

    private JButton[] buttons= {btXoa,btHuy,btThem,btHinh};

    private CheckTool checkTool = new CheckTool();

    public FormThemSach(){
        this.init();
    }
    public void init(){
        setLayout(new GridBagLayout());
        setBounds(600,200,600,600);
        setComps();
        getLstTheLoai();
        cbTheLoai.setSelectedIndex(0);
        setMaLoai();
        cbTheLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMaLoai();
            }
        });


        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaData();
            }
        });
        btHinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chonAnh();
            }
        });
        btHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                huyThem();
            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkData()){
                    addNewBook();
                }
            }
        });
    }

    public void getLstTheLoai(){
        ArrayList<String> lstTheLoai = new ArrayList<>();
        theLoai_bus tlbus = new theLoai_bus();
        for (TheLoai tl:theLoai_bus.getdsTheLoai()){
            cbTheLoai.addItem(String.valueOf(tl.getTenLoai()));
        }
    }
    public void setCompsFont(){
        for (JLabel label:labels){
            label.setFont(new Font("Tahoma",Font.PLAIN,20));
        }
        for (JButton bt: buttons){
            bt.setForeground(Color.white);
            bt.setFont(new Font("Tahoma",Font.PLAIN,20));
            bt.setBackground(new  Color(33, 115, 70));
        }
        for (JTextField tx:textFields){
            tx.setFont(new Font("Tahoma",Font.PLAIN,20));
        }
        cbTheLoai.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbTitle.setFont(new Font("Tahoma",Font.PLAIN,30));
        lbTitle.setOpaque(true);
        lbTitle.setBackground(new  Color(33, 115, 70));
        lbTitle.setForeground(Color.white);

        btXoa.setBackground(Color.yellow);
        btXoa.setIcon(new ImageIcon("src/IMG/anh/xoa.png"));
        btHuy.setBackground(Color.red);
        btHuy.setForeground(Color.black);
        btHuy.setIcon(new ImageIcon("src/IMG/anh/huy.png"));
        btXoa.setForeground(Color.black);

        txMaSach.setEditable(false);
        txImgPath.setEditable(false);
        txTheLoai.setEditable(false);
        txSoLuong.setText("0");
        txSoLuong.setEditable(false);

    }

    public void setNewID(){
        SachBUS sachBUS = new SachBUS();

        txMaSach.setText(String.valueOf(sachBUS.getLst().size()+1));
    }
    public void setMaLoai(){
        theLoai_bus tlbus = new theLoai_bus();

        for (TheLoai tl : theLoai_bus.getdsTheLoai()){
            if (tl.getTenLoai().equals(String.valueOf(cbTheLoai.getSelectedItem()))){
                txTheLoai.setText(String.valueOf(tl.getMaLoai()));
                return;
            }
        }
    }
    public void xoaData(){
        txTenSach.setText("");
        cbTheLoai.setSelectedIndex(0);
        txTacGia.setText("");
        txNhaXuatBan.setText("");
        txNamXuatBan.setText("");
        txImgPath.setText("");
    }
    public void chonAnh(){
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Chọn ảnh: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        String initialDirectoryPath ="src/IMG/BookIMG";
        File initialDirectory = new File(initialDirectoryPath);
        jfc.setCurrentDirectory(initialDirectory);

        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile() && jfc.getSelectedFile().getParent().contains("src\\IMG\\BookIMG")) {
                txImgPath.setText(jfc.getSelectedFile().getName());
            }else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn tệp trong thư mục BookIMG.");
            }
        }
    }
    public void huyThem(){
        setVisible(false);
    }

    public boolean checkData(){
        if (checkTool.formatInfo(txTenSach.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng điền tên sách!");
            txTenSach.requestFocus();
            return false;
        }
        if (checkTool.formatInfo(txTacGia.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng điền tên tác giả!");
            txTenSach.requestFocus();
            return false;
        }
        if (checkTool.formatInfo(txNhaXuatBan.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng điền nhà xuất bản!");
            txNhaXuatBan.requestFocus();
            return false;
        }
        if (checkTool.formatInfo(txNhaXuatBan.getText()).equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng điền năm xuất bản!");
            txNamXuatBan.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(txNamXuatBan.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Năm xuất bản không hợp lệ!");
            txNamXuatBan.requestFocus();
            return false;
        }
        if (Integer.parseInt(txNamXuatBan.getText()) < 0){
            JOptionPane.showMessageDialog(null,"Năm xuất bản không hợp lệ!");
            txNamXuatBan.requestFocus();
            return false;
        }
        if (txImgPath.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn ảnh!");
            return false;
        }
        return true;
    }
    public void setComps(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setCompsFont();
        setNewID();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lbTitle,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=0;
        add(lbBookID2,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=2;
        add(txMaSach,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        add(lbBookName2,gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=2;
        add(txTenSach,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        add(lbCategory2,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=1;
        add(txTheLoai,gbc);

        gbc.gridx=2;
        gbc.gridy=3;
        gbc.gridwidth=1;
        add(cbTheLoai,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        add(lbAuthor2,gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=2;
        add(txTacGia,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        add(lbNXB2,gbc);

        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=2;
        add(txNhaXuatBan,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        add(lbNamXB2,gbc);

        gbc.gridx=1;
        gbc.gridy=6;
        gbc.gridwidth=2;
        add(txNamXuatBan,gbc);

        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        add(lbSoLuong2,gbc);

        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=2;
        add(txSoLuong,gbc);

        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        add(lbImgPath,gbc);

        gbc.gridx=1;
        gbc.gridy=8;
        gbc.gridwidth=1;
        add(btHinh,gbc);

        btHinh.setIcon(new ImageIcon("src/IMG/anh/hinh.png"));

        gbc.gridx=2;
        gbc.gridy=8;
        gbc.gridwidth=1;
        add(txImgPath,gbc);

        gbc.gridx=0;
        gbc.gridy=9;
        gbc.gridwidth=1;
        add(btXoa,gbc);

        gbc.gridx=1;
        gbc.gridy=9;
        gbc.gridwidth=1;
        add(btHuy,gbc);

        gbc.gridx=2;
        gbc.gridy=9;
        gbc.gridwidth=1;
        add(btThem,gbc);

        btThem.setIcon(new ImageIcon("src/IMG/anh/them.png"));

    }
    public void addNewBook(){
        Sach sach = new Sach();
        sach.setMaSach(Integer.parseInt(txMaSach.getText()));
        sach.setTenSach(txTenSach.getText());
        sach.setTacGia(txTacGia.getText());
        sach.setMaLoai(Integer.parseInt(txTheLoai.getText()));
        sach.setImgPath(txImgPath.getText());
        sach.setNgayXuatBan(txNamXuatBan.getText());
        sach.setNhaXuatBan(txNhaXuatBan.getText());
        sach.setSoLuong(0);

        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm sách?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        // Xử lý sự lựa chọn của người dùng
        if (choice == JOptionPane.YES_OPTION) {
            SachBUS sachBUS = new SachBUS();
            sachBUS.insertLst(sach);
            JOptionPane.showMessageDialog(null, "Thêm sách thành công!");
            setVisible(false);
            return;

        } else {
            JOptionPane.showMessageDialog(null, "Đã hủy thêm sách!");
            return;
        }

    }
}
