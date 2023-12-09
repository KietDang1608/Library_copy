package GUI;

import BUS.SachBUS;
import BUS.theLoai_bus;
import DTO.Sach;
import DTO.TheLoai;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class SachGUI extends JFrame {
    private FormThemSach formThemSach = new FormThemSach();
    private int maSach=0;
    private Font font = new Font("Tahoma", Font.PLAIN, 15);
    private Font font2 = new Font("Tahoma", Font.PLAIN, 20);
    JPanel pnContent = new JPanel();
    //Cac thanh phan cua page tra cuu
    private JPanel pnDetail = new JPanel();
    private JPanel pnSearch = new JPanel();

    private JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
    JScrollPane scrollPane = new JScrollPane(buttonPanel);

    private JLabel lbBookImg = new JLabel();
    private JLabel lbBookID = new JLabel("Mã sách: ");
    private JLabel lbBookName = new JLabel("Tên sách: ");
    private JLabel lbCategory = new JLabel("Thể loại: ");
    private JLabel lbAuthor = new JLabel("Tác giả: ");
    private JLabel lbNXB = new JLabel("Nhà xuất bản: ");
    private JLabel lbNamXB = new JLabel("Năm xuất bản: ");
    private JLabel lbSoLuong = new JLabel("Số lượng: ");

    private int chosenBook;

    private JButton btnLapPhieuMuon = new JButton("Lập phiếu mượn");
    //Cac thanh phan cua tim kiem
    private JTextField txSearch = new JTextField();
    private JButton btnSearch = new JButton();
    private JComboBox<String> cbItem = new JComboBox<>();

    public JButton btnPageTraCuu = new JButton("Tra cứu");
    public JButton btnPageQuanLy = new JButton("Quản lý");


    private ArrayList<JButton> imgBtns = new ArrayList<>();

    private ImageResizing resizing = new ImageResizing();

    //Cac thanh phan cua page quan ly
    private JTable tableSach = new JTable();
    private JScrollPane scTable = new JScrollPane(tableSach);
    private JLabel lbBookImg2 = new JLabel();
    private JLabel lbImgPath = new JLabel("Tên ảnh:");
    private JLabel lbBookID2 = new JLabel("Mã sách: ");
    private JLabel lbBookName2 = new JLabel("Tên sách: ");
    private JLabel lbCategory2 = new JLabel("Thể loại: ");
    private JLabel lbAuthor2 = new JLabel("Tác giả: ");
    private JLabel lbNXB2 = new JLabel("Nhà xuất bản: ");
    private JLabel lbNamXB2 = new JLabel("Năm xuất bản: ");
    private JLabel lbSoLuong2 = new JLabel("Số lượng: ");

    private JTextField txMaSach = new JTextField();
    private JTextField txTheLoai = new JTextField();
    private JTextField txTenSach = new JTextField();
    private JLabel txIMG = new JLabel();
    private JTextField txTacGia = new JTextField();
    private JTextField txNhaXuatBan = new JTextField();
    private JTextField txNamXuatBan = new JTextField();
    private JTextField txSoLuong = new JTextField();
    private JTextField txImgPath = new JTextField();

    private JButton addIMG = new JButton("+");
    private JPanel pnQuanLy = new JPanel();

    public JButton btnThemSach = new JButton("Thêm sách");
    private JButton btnRefresh1 = new JButton("Refresh");
    private JButton btnRefresh2 = new JButton("Refresh");

    public SachGUI(){
        this.init();
    }

    //Tao lst sach
    SachBUS sachBUS = new SachBUS();
    public void init(){
        chosenBook = 0;
        setBounds(100,100,1300,750);
        setLayout(null);

        add(pnContent);
        pnContent.setBounds(0,0,1300,750);
        pnContent.setLayout(null);
        //Cac button chuyen trang
        btnPageTraCuu.setBounds(0,20,150,30);
        btnPageTraCuu.setBackground(Color.white);
        btnPageTraCuu.setIcon(new ImageIcon("src/IMG/anh/timKiem.png"));
        btnPageQuanLy.setBounds(150,20,150,30);
        btnPageQuanLy.setBackground(new Color(33, 115, 70));
        btnPageQuanLy.setIcon(new ImageIcon("src/IMG/anh/update.png"));
        btnPageQuanLy.setForeground(Color.white);
        pnContent.add(btnPageTraCuu);
        pnContent.add(btnPageQuanLy);
        pnContent.add(btnRefresh1);
        btnRefresh1.setBounds(350,20,150,30);
        btnRefresh1.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnRefresh1.setBackground(new Color(131, 162, 255));
        btnRefresh1.setForeground(Color.white);
        btnRefresh1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLstBook(sachBUS.getLst());
            }
        });
        //lenh chuyen trang
        switchToTraCuu();
        btnPageTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToTraCuu();
            }
        });
        btnPageQuanLy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToQuanLy();
            }
        });
        //Search
        cbItem.addItem("Mã sách");
        cbItem.addItem("Tên sách");
        cbItem.addItem("Tác giả");
        cbItem.addItem("Nhà xuất bản");

        pnContent.add(cbItem);
        pnContent.add(txSearch);
        pnContent.add(btnSearch);

        cbItem.setBounds(850,0,150,30);
        cbItem.setFont(font);
        cbItem.setBackground(new Color(33, 115, 70));
        cbItem.setForeground(Color.white);

        txSearch.setBounds(1000,0,250,30);
        txSearch.setFont(font);

        btnSearch.setIcon(new ImageIcon("src/IMG/MainIMG/search.png"));
        btnSearch.setBounds(1250,0,29,29);
        btnSearch.setBackground(Color.white);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Sach> sachs = sachBUS.timKiem(String.valueOf(cbItem.getSelectedItem()),txSearch.getText());
                showLstBook(sachs);
                addDBToTable(sachs);
            }
        });
        //Panel detail

        pnContent.add(pnDetail);
        pnDetail.setBounds(1000,50,300,700);
        pnDetail.setLayout(new  BoxLayout(pnDetail, BoxLayout.Y_AXIS));
        pnDetail.add(Box.createVerticalGlue());

        resizing.resizeImg("src/IMG/BookIMG/nothing.jpg",200,200);
        lbBookImg.setIcon(new ImageIcon("src/IMG/BookIMG/nothing.jpg"));
        lbBookImg.setBorder(new EmptyBorder(0, 40, 0, 0));
        pnDetail.add(lbBookImg);
        pnDetail.add(Box.createVerticalStrut(100));
        pnDetail.add(lbBookID);
        pnDetail.add(Box.createVerticalStrut(20));
        lbBookID.setFont(font);
        pnDetail.add(lbBookName);
        pnDetail.add(Box.createVerticalStrut(20));
        lbBookName.setFont(font);
        pnDetail.add(lbCategory);
        pnDetail.add(Box.createVerticalStrut(20));
        lbCategory.setFont(font);
        pnDetail.add(lbAuthor);
        pnDetail.add(Box.createVerticalStrut(20));
        lbAuthor.setFont(font);
        pnDetail.add(lbNXB);
        pnDetail.add(Box.createVerticalStrut(20));
        lbNXB.setFont(font);
        pnDetail.add(lbNamXB);
        pnDetail.add(Box.createVerticalStrut(20));
        lbNamXB.setFont(font);
        pnDetail.add(lbSoLuong);
        pnDetail.add(Box.createVerticalStrut(20));
        lbSoLuong.setFont(font);
        pnDetail.add(Box.createVerticalStrut(50));
        pnDetail.add(btnLapPhieuMuon);

        btnLapPhieuMuon.setBorder(new EmptyBorder(10, 40, 10, 40));
        btnLapPhieuMuon.setIcon(new ImageIcon("src/IMG/MainIMG/notepad.png"));
        btnLapPhieuMuon.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLapPhieuMuon.setBackground(new  Color(33, 115, 70));

        btnLapPhieuMuon.setForeground(Color.white);
        btnLapPhieuMuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maSach == 0){
                    JOptionPane.showMessageDialog(null,"Hãy chọn một sách để lập phiếu mượn!");
                }else {
                    FormPhieuMuon form = new FormPhieuMuon(maSach-1);
                    form.setVisible(true);
                }

            }
        });
        pnDetail.add(Box.createVerticalGlue());
        pnDetail.setBackground(Color.white);
        //Hien thi danh sach sach
        showLstBook(sachBUS.getLst());

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ArrayList<Sach> books = sachBUS.findBook(String.valueOf(cbItem.getSelectedItem()),txSearch.getText());
//                showLstBook(books);
            }
        });

        //Them cac thanh phan cua page quan ly
        pnContent.add(pnQuanLy);
        pnQuanLy.setLayout(null);
        pnQuanLy.setBounds(0,50,1300,700);

        pnQuanLy.add(lbBookID2);
        lbBookID2.setBounds(100,0,100,30);
        lbBookID2.setFont(font);
        pnQuanLy.add(txMaSach);
        txMaSach.setEditable(false);
        txMaSach.setBounds(200,0,100,30);
        pnQuanLy.add(lbCategory2);
        lbCategory2.setBounds(100,50,100,30);
        lbCategory2.setFont(font);
        pnQuanLy.add(txTheLoai);
        txTheLoai.setEditable(false);
        txTheLoai.setBounds(200,50,300,30);
        pnQuanLy.add(lbBookName2);
        lbBookName2.setBounds(100,100,100,30);
        lbBookName2.setFont(font);
        pnQuanLy.add(txTenSach);
        txTenSach.setBounds(200,100,300,30);
        txTenSach.setEditable(false);
        lbBookImg2.setBounds(900,0,200,200);
        lbBookImg2.setFont(font);
        lbBookImg2.setIcon(new ImageIcon("src/IMG/BookIMG/nothing.jpg"));
        pnQuanLy.add(lbBookImg2);
        pnQuanLy.add(lbAuthor2);
        lbAuthor2.setBounds(550,0,100,30);
        lbAuthor2.setFont(font);
        pnQuanLy.add(txTacGia);
        txTacGia.setBounds(650,0,200,30);
        txTacGia.setEditable(false);
        txTacGia.setFont(font);
        pnQuanLy.add(lbNXB2);
        lbNXB2.setBounds(550,50,100,30);
        lbNXB2.setFont(font);
        pnQuanLy.add(txNhaXuatBan);
        txNhaXuatBan.setBounds(650,50,200,30);
        txNhaXuatBan.setEditable(false);
        pnQuanLy.add(lbNamXB2);
        lbNamXB2.setFont(font);
        lbNamXB2.setBounds(540,100,110,30);
        pnQuanLy.add(txNamXuatBan);
        txNamXuatBan.setEditable(false);
        txNamXuatBan.setBounds(650,100,200,30);
        pnQuanLy.add(lbSoLuong2);
        lbSoLuong2.setBounds(300,0,100,30);
        lbSoLuong.setFont(font);
        pnQuanLy.add(txSoLuong);
        txSoLuong.setBounds(400,0,100,30);
        txSoLuong.setEditable(false);
        pnQuanLy.add(lbImgPath);
        lbImgPath.setBounds(550,150,100,30);
        lbImgPath.setFont(font);
        pnQuanLy.add(txImgPath);
        txImgPath.setBounds(650,150,200,30);
        txImgPath.setEditable(false);
        pnQuanLy.add(btnThemSach);
        btnThemSach.setBounds(1110,0,170,30);
        btnThemSach.setFont(font);
        btnThemSach.setIcon(new ImageIcon("src/IMG/anh/them.png"));
        btnThemSach.setBackground(new  Color(33, 115, 70));
        btnThemSach.setForeground(Color.white);

        pnQuanLy.add(btnRefresh2);
        btnRefresh2.setBounds(1110,50,170,30);
        btnRefresh2.setFont(font);
        btnRefresh2.setBackground(new  Color(131, 162, 255));
        btnRefresh2.setForeground(Color.white);
        btnRefresh2.setIcon(new ImageIcon("src/IMG/anh/refresh.png"));
        btnRefresh2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDBToTable(sachBUS.getLst());
            }
        });

        pnQuanLy.add(scTable);
        scTable.setBounds(10,200,1270,500);
        scTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        btnThemSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openThemSach();
            }
        });

        addDBToTable(sachBUS.getLst());


        tableSach.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableSach.getSelectedRow();
                Sach sach= sachBUS.getSachByID(Integer.parseInt(String.valueOf(tableSach.getValueAt(i,0))));
                txMaSach.setText(String.valueOf(sach.getMaSach()));
                setTenTheLoai(String.valueOf(sach.getMaLoai()));
                txTacGia.setText(sach.getTacGia());
                txNhaXuatBan.setText(sach.getNhaXuatBan());
                txNamXuatBan.setText(String.valueOf(sach.getNgayXuatBan()));
                txImgPath.setText(sach.getImgPath());
                txSoLuong.setText(String.valueOf(sach.getSoLuong()));
                txTenSach.setText(sach.getTenSach());
                lbBookImg2.setIcon(new ImageIcon("src/IMG/BookIMG/" + sach.getImgPath()));
            }
        });
    }


    private void showLstBook(ArrayList<Sach> arraySach){
        // Thêm một loạt các JButton vào JPanel

        buttonPanel.removeAll();
        buttonPanel.revalidate();
        buttonPanel.repaint();
        if (arraySach == null){
            return;
        }

        for (Sach sach:arraySach){
            JButton btn = new JButton();
            //Dat hinh anh cho cac button
//
            btn.setBackground(Color.white);
            resizing.resizeImg(sach.getSachPath(),200,200);
            btn.setIcon(new ImageIcon(sach.getSachPath()));

            //Dat id cho cac button
            btn.setName(String.valueOf(sach.getMaSach()));
            //Dat lenh cho button
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lbBookImg.setIcon(new ImageIcon(sach.getSachPath()));
                    lbBookID.setText("Mã sách: " + String.valueOf(sach.getMaSach()));
                    maSach = sach.getMaSach();
                    lbBookName.setText("Tên sách: " + sach.getTenSach());
                    lbAuthor.setText("Tác giả: " +sach.getTacGia());
                    lbNXB.setText("Nhà xuất bản: " +sach.getNhaXuatBan());
                    lbNamXB.setText("Năm xuất bản: " +sach.getNgayXuatBan());
                    lbSoLuong.setText("Số lượng: " +String.valueOf(sach.getSoLuong()));
                    setTheLoai();
                    chosenBook = sach.getMaSach();
                }
            });
            buttonPanel.add(btn);
        }

        scrollPane.setBounds(0,50,1000,700);
        // Đặt chế độ cuộn cho JScrollPane
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Thêm JScrollPane vào JFrame
        pnContent.add(scrollPane);
    }
    private void switchToTraCuu(){
        scrollPane.setVisible(true);
        pnDetail.setVisible(true);
        btnPageQuanLy.setBackground(new Color(33, 115, 70));
        btnPageTraCuu.setBackground(Color.white);
        btnPageQuanLy.setForeground(Color.white);
        btnPageTraCuu.setForeground(Color.black);
        btnRefresh1.setVisible(true);
        pnQuanLy.setVisible(false);
    }
    private void switchToQuanLy(){
        scrollPane.setVisible(false);
        pnDetail.setVisible(false);
        btnPageTraCuu.setBackground(new Color(33, 115, 70));
        btnPageQuanLy.setBackground(Color.white);
        btnPageQuanLy.setForeground(Color.black);
        btnPageTraCuu.setForeground(Color.white);
        btnRefresh1.setVisible(false);
        pnQuanLy.setVisible(true);
    }
    public void openThemSach(){
        formThemSach.setVisible(true);
    }

    public static void main(String[] args) {
        SachGUI sachGUI = new SachGUI();
        sachGUI.setVisible(true);
    }
    private void addDBToTable(ArrayList<Sach> listSach){
        DefaultTableModel nModel = new DefaultTableModel();
        nModel.addColumn("ID");
        nModel.addColumn("Mã loại");
        nModel.addColumn("Tên sách ");
        nModel.addColumn("Tác giả");
        nModel.addColumn("Nhà xuất bản");
        nModel.addColumn("Năm xuất bản");
        nModel.addColumn("Số lượng");
        nModel.addColumn("Hình");


        for (Sach sach : listSach){
            Vector data = new Vector();
            data.add(sach.getMaSach());
            data.add(sach.getMaLoai());
            data.add(sach.getTenSach());
            data.add(sach.getTacGia());
            data.add(sach.getNhaXuatBan());
            data.add(sach.getNgayXuatBan());
            data.add(sach.getSoLuong());
            data.add(sach.getImgPath());
            nModel.addRow(data);
        }
        tableSach.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableColumnModel columnModel = tableSach.getColumnModel();


        tableSach.setModel(nModel);

        TableColumn column = columnModel.getColumn(0);
        column.setPreferredWidth(5);
        column = columnModel.getColumn(1);
        column.setPreferredWidth(5);
        tableSach.setFont(new Font("Tahoma",Font.PLAIN,15));

        column = columnModel.getColumn(5);
        column.setPreferredWidth(5);
        column = columnModel.getColumn(6);
        column.setPreferredWidth(5);
        tableSach.setRowHeight(30);
    }
    public void setTenTheLoai(String id){
        theLoai_bus tlbus = new theLoai_bus();
        for (TheLoai tl : theLoai_bus.getdsTheLoai()){
            if (tl.getMaLoai()==Integer.parseInt(id)){
                txTheLoai.setText(tl.getTenLoai());
            }
        }
    }
    private void setTheLoai(){
        SachBUS sachBUS = new SachBUS();
        lbCategory.setText("Thể loại: " + sachBUS.getTenTL(maSach));
    }
}
