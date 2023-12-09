package GUI;

import BUS.LoginBUS;
import BUS.NhanVienBUS;
import BUS.TrangChuBUS;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;

public class TrangChuGUI extends JFrame {
	public String username;
	private JPanel contentPane;
	private JPanel pnContent = new JPanel();
	//Cac page
	private JPanel pnSach = new JPanel();
	private JPanel pnTheLoai = new JPanel();
	private JPanel pnPhanQuyen = new JPanel();

	private JLabel lbDay = new JLabel("Thứ 4 ,18-10-2023");
	private JLabel lbTitle = new JLabel("Xin Chào");

	private Color maincolor=new Color(33,115,70);
	private Font mainFont = new Font("Tahoma", Font.PLAIN, 15);
	private JPanel menuPn = new JPanel();
	private JButton logoutBtn = new JButton("Đăng Xuất");
	private JButton btnHome = new JButton("Trang Chủ");
	private JButton btnSach = new JButton("Sách");
	private JButton btnTheLoai = new JButton("Thể Loại");
	private JButton btnMuon = new JButton("Phiếu Mượn");
	private JButton btnNhap = new JButton("Nhập Sách");
	private JButton btnNCC = new JButton("Nhà Cung Cấp");
	private JButton btnThanhVien = new JButton("Thành Viên");
	private JButton btnNhanVien = new JButton("Nhân Viên");
	private JButton btnQuyDinh = new JButton("Quy Định");
	private JButton btnMyAcc = new JButton("My Account");
	private JButton btnAccount = new JButton("Tài Khoản");
	private JButton btnPhanQuyen = new JButton("Phân Quyền");
	private JButton btnThongKe = new JButton("Thống Kê");
	private JButton btnPhat = new JButton("Phiếu Phạt");
	private JButton btnTraCuu = new JButton(" Tra Cứu Sách");
	private JButton btnPhieuMuon = new JButton("Lập Phiếu Mượn");
	private JLabel lblNewLabel = new JLabel("Truy Cập Nhanh");
	private JButton btnPhieuPhat = new JButton("Lập Phiếu Phạt");
	private JButton btnPhieuNhap = new JButton("Lập Phiếu Nhập");

	private JButton[] menuButtons = {btnSach,btnTheLoai,btnQuyDinh,btnNhap,btnMuon,btnThanhVien,btnPhat,btnPhanQuyen,btnNhanVien,btnAccount,btnThongKe,btnNCC,btnPhieuPhat,btnPhieuMuon,btnPhieuNhap};

	ArrayList<JButton> lstMenuBtn = new ArrayList<>();
	//Cac frame
	private LoginGUI loginGUI = new LoginGUI();
	private SachGUI sachGUI = new SachGUI();
	private TKCaNhanGUI tkCaNhanGUI = new TKCaNhanGUI();
	private ThanhVienGUI thanhVienGUI = new ThanhVienGUI();
	private NhanVienGUI nhanVienGUI = new NhanVienGUI();
	private PhanQuyenGUI phanQuyen_gui = new PhanQuyenGUI();
	private TheLoai_GUI theLoai_gui = new TheLoai_GUI();
	private NhaCungCapGUI nhaCungCapGUI = new NhaCungCapGUI();
	private QuyDinhGUI quyDinhGUI = new QuyDinhGUI();
	private TaiKhoanGUI taiKhoanGUI = new TaiKhoanGUI();
	private PhieuPhatGUI phieuPhatGUI = new PhieuPhatGUI();
	private PhieuNhapGUI phieuNhapGUI = new PhieuNhapGUI();
	private ThongKeGUI thongKeGUI = new ThongKeGUI();
	private PhieuMuonGUI phieuMuonGUI = new PhieuMuonGUI();
	private JFrame[] frames = {tkCaNhanGUI,thanhVienGUI,nhanVienGUI,phanQuyen_gui,theLoai_gui,nhaCungCapGUI,quyDinhGUI,taiKhoanGUI,phieuPhatGUI,thongKeGUI,phieuMuonGUI,phieuNhapGUI};
	//Cac lop bus su dung
	private NhanVienBUS nhanVienBUS = new NhanVienBUS();
	private LoginBUS loginBUS = new LoginBUS();

	/**
	 * Create the frame.
	 */
	public TrangChuGUI() {
		this.init();
	}
	public void init(){


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1500, 810);
		setLoginName();
		setComponents();
		addComponents();
		toTrangChu();
		//Trang chu
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toTrangChu();
			}
		});
		//Dang xuat
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toLogin();
			}
		});
		//Sach
		btnSach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toSach();
			}
		});
		//Phan quyen
		btnPhanQuyen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toPhanQuyen();
			}
		});
		//The loai
		btnTheLoai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toTheLoai();
			}
		});
		//Thanh vien
		btnThanhVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toThanhVien();
			}
		});
		//Nhan vien
		btnNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toNhanVien();
			}
		});
		//Tai khoan ca nhan
		btnMyAcc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toMyAccount();
			}
		});
		//Nha cung cap
		btnNCC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toNhaCungCap();
			}
		});
		btnQuyDinh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toQuyDinh();
			}
		});
		btnAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toTaiKhoan();
			}
		});
		btnPhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toPhieuPhat();
			}
		});
		btnNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toPhieuNhap();
			}
		});
		btnThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toThongKe();
			}
		});
		btnMuon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toPhieuMuon();
			}
		});
		btnNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toPhieuNhap();
			}
		});
		tatQuickAccess();
		setQuickAccess();
		btnTraCuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toSach();
			}
		});
		btnPhieuMuon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormPhieuMuon form = new FormPhieuMuon();
				form.setVisible(true);
			}
		});
		btnPhieuPhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormPhat form = new FormPhat();
				form.setVisible(true);
			}
		});
		btnPhieuNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormNhapHang form = new FormNhapHang();
				form.setVisible(true);
			}
		});
	}
	public void setBtnID(){
		int i = 1;
		for (JButton btn: lstMenuBtn){
			btn.setName(String.valueOf(i++));
		}
	}
	//test
	public void turnOffBtns(){
		for (JButton btn: lstMenuBtn){
			btn.setVisible(false);
		}
	}
	//tét
	public void turnOnBtns(){
		ArrayList <String> btns = getPermissions();

		for (String btn:btns){
			for (JButton button: lstMenuBtn){
				if (btn.equals(button.getName())) {
					button.setVisible(true);
					break;
				}
			}
		}
	}
	public void setButtonPosition(){
		ArrayList <String> btns = getPermissions();
		int i = 0;
		for (String btn:btns){
			i++;
			for (JButton button:lstMenuBtn){
				if (btn.equals(button.getName())){
					button.setBounds(0, 122 + (i)*32, 175, 32);
					break;
				}
			}
		}
	}
	public void setDate(){
		LocalDate date = LocalDate.now();
		String dayOfWeek = String.valueOf(date.getDayOfWeek().getValue());
		String day = String.valueOf(date.getDayOfMonth());
		String month = String.valueOf(date.getMonth().getValue());
		String year = String.valueOf(date.getYear());

		String formatedDate = "Thứ " + (Integer.parseInt(dayOfWeek) + 1) + ", Ngày "+day + " tháng " + (Integer.parseInt(month)) + " năm " + year;
		lbDay.setText(formatedDate);

	}
	public void setComponents(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Cho cac button vao arraylist
		for (JButton button:menuButtons){
			lstMenuBtn.add(button);
		}
		//setID cho cac button
		setBtnID();
		//Hien thi cac button theo phan quyen
		turnOffBtns();

		turnOnBtns();


		menuPn.setBackground(maincolor);
		menuPn.setBounds(0, 0, 175, 778);
		contentPane.add(menuPn);
		menuPn.setLayout(null);
		ImageIcon icon = new ImageIcon("src/IMG/MainIMG/library.png");
		JLabel lbIcon = new JLabel(icon);
		lbIcon.setLocation(26, 10);
		menuPn.add(lbIcon);
		lbIcon.setSize(128,91);


		logoutBtn.setFont(mainFont);
		logoutBtn.setForeground(new Color(255, 255, 255));
		logoutBtn.setIcon(new ImageIcon("src/IMG/MainIMG/logout.png"));
		logoutBtn.setBounds(0, 726, 175, 42);
		logoutBtn.setBackground(maincolor);
		logoutBtn.setBorderPainted(false);
		menuPn.add(logoutBtn);

		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setIcon(new ImageIcon("src/IMG/MainIMG/home.png"));
		btnHome.setBounds(0, 122, 175, 32);
		btnHome.setBorderPainted(false);
		btnHome.setBackground(maincolor);
		menuPn.add(btnHome);


		btnSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSach.setIcon(new ImageIcon("src/IMG/MainIMG/books.png"));
		btnSach.setForeground(Color.WHITE);
		btnSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSach.setBorderPainted(false);
		btnSach.setBackground(new Color(33, 115, 70));
		btnSach.setBounds(0, 164, 175, 32);
		menuPn.add(btnSach);

		btnTheLoai.setHorizontalAlignment(SwingConstants.LEFT);
		btnTheLoai.setIcon(new ImageIcon("src/IMG/MainIMG/list.png"));
		btnTheLoai.setForeground(Color.WHITE);
		btnTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTheLoai.setBorderPainted(false);
		btnTheLoai.setBackground(new Color(33, 115, 70));
		btnTheLoai.setBounds(0, 206, 175, 32);
		menuPn.add(btnTheLoai);


		btnMuon.setIcon(new ImageIcon("src/IMG/MainIMG/give_book.png"));
		btnMuon.setHorizontalAlignment(SwingConstants.LEFT);
		btnMuon.setForeground(Color.WHITE);
		btnMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMuon.setBorderPainted(false);
		btnMuon.setBackground(new Color(33, 115, 70));
		btnMuon.setBounds(0, 248, 175, 32);
		menuPn.add(btnMuon);


		btnNhap.setIcon(new ImageIcon("src/IMG/MainIMG/truck.png"));
		btnNhap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhap.setForeground(Color.WHITE);
		btnNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhap.setBorderPainted(false);
		btnNhap.setBackground(new Color(33, 115, 70));
		btnNhap.setBounds(0, 290, 175, 32);
		menuPn.add(btnNhap);


		btnNCC.setIcon(new ImageIcon("src/IMG/MainIMG/company.png"));
		btnNCC.setHorizontalAlignment(SwingConstants.LEFT);
		btnNCC.setForeground(Color.WHITE);
		btnNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNCC.setBorderPainted(false);
		btnNCC.setBackground(new Color(33, 115, 70));
		btnNCC.setBounds(0, 332, 175, 32);
		menuPn.add(btnNCC);


		btnThanhVien.setIcon(new ImageIcon("src/IMG/MainIMG/customer.png"));
		btnThanhVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhVien.setForeground(Color.WHITE);
		btnThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhVien.setBorderPainted(false);
		btnThanhVien.setBackground(new Color(33, 115, 70));
		btnThanhVien.setBounds(0, 458, 175, 32);
		menuPn.add(btnThanhVien);


		btnNhanVien.setIcon(new ImageIcon("src/IMG/MainIMG/employee.png"));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setBackground(new Color(33, 115, 70));
		btnNhanVien.setBounds(0, 416, 175, 32);
		menuPn.add(btnNhanVien);


		btnQuyDinh.setIcon(new ImageIcon("src/IMG/MainIMG/ban.png"));
		btnQuyDinh.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuyDinh.setForeground(Color.WHITE);
		btnQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuyDinh.setBorderPainted(false);
		btnQuyDinh.setBackground(new Color(33, 115, 70));
		btnQuyDinh.setBounds(0, 584, 175, 32);
		menuPn.add(btnQuyDinh);


		btnMyAcc.setForeground(Color.WHITE);
		btnMyAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMyAcc.setBorderPainted(false);
		btnMyAcc.setBackground(new Color(33, 115, 70));
		btnMyAcc.setBounds(0, 684, 175, 32);
		menuPn.add(btnMyAcc);


		btnAccount.setIcon(new ImageIcon("src/IMG/MainIMG/account.png"));
		btnAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAccount.setBorderPainted(false);
		btnAccount.setBackground(new Color(33, 115, 70));
		btnAccount.setBounds(0, 500, 175, 32);
		menuPn.add(btnAccount);


		btnPhanQuyen.setIcon(new ImageIcon("src/IMG/MainIMG/permission.png"));
		btnPhanQuyen.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhanQuyen.setForeground(Color.WHITE);
		btnPhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPhanQuyen.setBorderPainted(false);
		btnPhanQuyen.setBackground(new Color(33, 115, 70));
		btnPhanQuyen.setBounds(0, 542, 175, 32);
		menuPn.add(btnPhanQuyen);


		btnThongKe.setIcon(new ImageIcon("src/IMG/MainIMG/statistic.png"));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(33, 115, 70));
		btnThongKe.setBounds(0, 626, 175, 32);
		menuPn.add(btnThongKe);


		btnPhat.setIcon(new ImageIcon("src/IMG/MainIMG/fineSheet.png"));
		btnPhat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhat.setForeground(Color.WHITE);
		btnPhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPhat.setBorderPainted(false);
		btnPhat.setBackground(new Color(33, 115, 70));
		btnPhat.setBounds(0, 374, 175, 32);
		menuPn.add(btnPhat);

		pnContent.setBounds(185,10,1300,750);
		pnContent.setLayout(null);

		JPanel pnHead = new JPanel();
		pnHead.setBounds(10, 10, 1270, 55);
		pnContent.add(pnHead);
		JLabel lbHead = new JLabel("QUẢN LÝ THƯ VIỆN");
		pnHead.add(lbHead);
		lbHead.setForeground(Color.white);
		lbHead.setFont(new Font("Tahoma",Font.BOLD,30));
		pnHead.setBackground(new Color(33, 115, 70));

		JPanel titlePn = new JPanel();
		titlePn.setBounds(10, 100, 1270, 55);
		pnContent.add(titlePn);
		titlePn.setLayout(null);


		lbDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbDay.setBounds(900, 10, 500, 39);
		titlePn.add(lbDay);


		lbTitle.setBounds(10, 10, 269, 39);
		titlePn.add(lbTitle);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 20));

		JPanel quickAccessPn = new JPanel();
		quickAccessPn.setBounds(10, 170, 1270, 102);
		pnContent.add(quickAccessPn);
		quickAccessPn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		quickAccessPn.setLayout(null);


		btnTraCuu.setForeground(new Color(255, 255, 255));
		btnTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTraCuu.setBounds(121, 37, 206, 46);
		quickAccessPn.add(btnTraCuu);
		btnTraCuu.setIcon(new ImageIcon("src/IMG/MainIMG/search.png"));
		btnTraCuu.setBackground(maincolor);


		btnPhieuMuon.setForeground(new Color(255, 255, 255));
		btnPhieuMuon.setIcon(new ImageIcon("src/IMG/MainIMG/notepad.png"));
		btnPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPhieuMuon.setBounds(408, 37, 218, 46);
		quickAccessPn.add(btnPhieuMuon);
		btnPhieuMuon.setBackground(maincolor);


		btnPhieuPhat.setForeground(new Color(255, 255, 255));
		btnPhieuPhat.setIcon(new ImageIcon("src/IMG/MainIMG/fine.png"));
		btnPhieuPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPhieuPhat.setBounds(736, 37, 206, 46);
		quickAccessPn.add(btnPhieuPhat);
		btnPhieuPhat.setBackground(maincolor);


		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 206, 25);
		quickAccessPn.add(lblNewLabel);


		btnPhieuNhap.setForeground(new Color(255, 255, 255));
		btnPhieuNhap.setIcon(new ImageIcon("src/IMG/MainIMG/import.png"));
		btnPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPhieuNhap.setBounds(1041, 37, 218, 46);
		quickAccessPn.add(btnPhieuNhap);
		btnPhieuNhap.setBackground(maincolor);

		Panel pnQuyDinh = new Panel();
		pnQuyDinh.setBounds(0, 0, 1290, 800);
		pnContent.add(pnQuyDinh);
		pnQuyDinh.setLayout(null);

		JLabel lbBG = new JLabel();
		lbBG.setBounds(0, 0, 1300, 800 );
		lbBG.setIcon(new ImageIcon("src/IMG/MainIMG/mainPage.jpg"));
		pnQuyDinh.add(lbBG);

		//Dat lai vi tri cho cac button
		setButtonPosition();
		//Dat lai ngay thang hien hanh
		setDate();
	}
	//
	//login
	public void toLogin(){
		loginGUI.setVisible(true);
		setVisible(false);
	}
	//Sach
	public void toSach(){
		tatMenu();

		pnSach.setVisible(true);
	}
	public void toTrangChu(){
		tatMenu();

		pnContent.setVisible(true);
	}
	public void toPhanQuyen(){
		tatMenu();

		phanQuyen_gui.getContentPane().setVisible(true);

	}
	public void toTheLoai(){
		tatMenu();

		theLoai_gui.getContentPane().setVisible(true);
	}
	public void toNhanVien(){
		tatMenu();

		nhanVienGUI.getContentPane().setVisible(true);
	}
	public void toThanhVien(){
		tatMenu();

		thanhVienGUI.getContentPane().setVisible(true);
	}
	public void toMyAccount(){
		tatMenu();

		tkCaNhanGUI.getContentPane().setVisible(true);
	}
	public void toNhaCungCap(){
		tatMenu();
		nhaCungCapGUI.getContentPane().setVisible(true);
	}
	public void toQuyDinh(){
		tatMenu();
		quyDinhGUI.getContentPane().setVisible(true);
	}
	public void toTaiKhoan(){
		tatMenu();
		taiKhoanGUI.getContentPane().setVisible(true);
	}
	public void toPhieuPhat(){
		tatMenu();
		phieuPhatGUI.getContentPane().setVisible(true);
	}

	public void toPhieuMuon(){
		tatMenu();
		phieuMuonGUI.getContentPane().setVisible(true);
	}
	public void toThongKe(){
		tatMenu();

		thongKeGUI.getContentPane().setVisible(true);
	}
	public void toPhieuNhap(){
		tatMenu();
		phieuNhapGUI.getContentPane().setVisible(true);
	}
	public void addComponents(){
		contentPane.add(pnContent);

		contentPane.add(pnSach);
		pnSach.add(sachGUI.pnContent);
		pnSach.setBounds(185,10,1310,760);
		pnSach.setLayout(null);

		for (JFrame frame:frames){
			contentPane.add(frame.getContentPane());
			frame.getContentPane().setBounds(185,10,1310,760);
		}

	}
	public void setLoginName(){
		lbTitle.setText("Xin chào " + loginBUS.getLoginName());
	}
	public ArrayList<String> getPermissions(){
		TrangChuBUS trangChuBUS = new TrangChuBUS();
		ArrayList<String> permissions = trangChuBUS.getLstPermisson(loginBUS.getUsername());
		return permissions;
	}
	public void tatMenu(){
		pnSach.setVisible(false);
		pnContent.setVisible(false);
		for (JFrame frame:frames){
			frame.getContentPane().setVisible(false);
		}
	}
	public void tatQuickAccess(){
		btnTraCuu.setVisible(false);
		btnPhieuMuon.setVisible(false);
		btnPhieuNhap.setVisible(false);
		btnPhieuPhat.setVisible(false);
	}
	public void setQuickAccess(){
		ArrayList<String> phanquyen = getPermissions();
		for (String s : phanquyen){
			if (s.equals("1")){
				btnTraCuu.setVisible(true);
			}
			if (s.equals("4")){
				btnPhieuNhap.setVisible(true);
			}
			if (s.equals("5")){
				btnPhieuMuon.setVisible(true);
			}
			if (s.equals("7")){
				btnPhieuPhat.setVisible(true);
			}
		}
	}
}
