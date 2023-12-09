
package GUI;
import BUS.LoginBUS;
import BUS.NhanVienBUS;
import DTO.NhanVien;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginGUI extends JFrame {
    private NhanVienBUS nhanVienBUS = new NhanVienBUS();
    private LoginBUS loginBUS = new LoginBUS();
    Color mainColor = new Color(33, 115, 70);
    private JLabel lbImg = new JLabel();
    private JLabel lbUsername = new JLabel("Tên tài khoản");
    private JLabel lbPassword = new JLabel("Mật khẩu");
    private JLabel lbDangNhap = new JLabel("ĐĂNG NHẬP");

    public JTextField txUsername = new JTextField();
    private JTextField txPassword = new JTextField();

    private JButton btnLogin = new JButton("ĐĂNG NHẬP");

    private Font mainFont = new Font("Tahoma", Font.PLAIN, 20);
    private JPanel pnInfo = new JPanel();
    JPanel pnContainer = new JPanel();

    String Username ="";
    String Password ="";

    public LoginGUI() {
        this.initComponents();
    }

    private void initComponents() {
        setBounds(300, 100, 1300, 750);
        setTitle("Đăng nhập");
        setLayout(null);

        setLogin();

        //Vao trang chu
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int login = checkLogin();
                switch (login) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Vui lòng điền tên tài khoản!");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu!");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác!");
                        break;
                    case 0:
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại!");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Nhân viên đã nghỉ làm!");
                        break;
                }

                if (login == 0){
                    loginBUS.setLogin(txUsername.getText());
                    TrangChuGUI mainGUI = new TrangChuGUI();
                    mainGUI.setVisible(true);
                    setVisible(false);
                }
            }
        });
        txUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }
            }
        });
        txPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }
            }
        });
    }

   

    public void setInfo() {
        Password = txPassword.getText();
        Username = txUsername.getText();
    }

    //tra ve 1 neu chua dien ten tai khoan
    //2 neu chua dien mat khau
    //3 neu mat khau khong chinh xac
    //4 neu tai khoan khong ton tai
    //5 neu nhan vien da nghi lam
    //0 neu dang nhap thanh cong
    public int checkLogin() {
        setInfo();
        System.out.println(Username + Password);

        if (Username.equals("")) {
            return 1;
        }
        if (Password.equals("")) {
            return 2;
        }
        if (!loginBUS.checkWorking(Username)) return 5;
        for (NhanVien nhanVien : nhanVienBUS.getLst()) {
            if (Username.equals(nhanVien.getMaNV())) {
                if (Password.equals(nhanVien.getPassword())) {
                    return 0;
                } else {
                    return 3;
                }
            }
        }

        return 4;
    }


    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    public void setLogin(){
        add(pnContainer);
        pnContainer.setLayout(null);
        pnContainer.setBounds(0, 0, 1300, 750);
        pnContainer.setBackground(mainColor);

        pnContainer.add(pnInfo);
        pnInfo.setBounds(100, 100, 400, 500);
        pnInfo.setBackground(mainColor);

        pnContainer.add(lbImg);
        lbImg.setIcon(new ImageIcon("src/IMG/MainIMG/loginIMG.jpg"));
        lbImg.setBounds(100 + 400 + 50, 100, 650, 500);

        Border infoBorder = BorderFactory.createLineBorder(Color.WHITE, 2);
        pnInfo.setBorder(infoBorder);
        pnInfo.setLayout(null);
        pnInfo.add(lbDangNhap);
        lbDangNhap.setBounds(0, 0, 400, 50);
        lbDangNhap.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        lbDangNhap.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa theo chiều ngang
        lbDangNhap.setVerticalAlignment(SwingConstants.CENTER);
        lbDangNhap.setFont(new Font("Tahoma", Font.BOLD, 35));
        lbDangNhap.setForeground(Color.white);
        pnInfo.add(lbUsername);
        lbUsername.setBounds(50, 100, 200, 30);
        lbUsername.setForeground(Color.white);
        lbUsername.setFont(mainFont);
        pnInfo.add(lbPassword);
        lbPassword.setBounds(50, 200, 200, 30);
        lbPassword.setFont(mainFont);
        lbPassword.setForeground(Color.white);
        pnInfo.add(txUsername);
        txUsername.setFont(mainFont);
        txUsername.setBounds(50, 150, 300, 30);
        pnInfo.add(txPassword);
        txPassword.setFont(mainFont);
        txPassword.setBounds(50, 250, 300, 30);
        pnInfo.add(btnLogin);
        btnLogin.setBackground(new Color(0, 102, 0));
        btnLogin.setFont(mainFont);
        btnLogin.setForeground(Color.white);
        btnLogin.setBounds(100, 350, 200, 50);
    }
}