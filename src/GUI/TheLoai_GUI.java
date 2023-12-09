package GUI;

import BUS.theLoai_bus;
import DTO.TheLoai;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TheLoai_GUI extends JFrame {
	theLoai_bus bus = new theLoai_bus();
	private JPanel contentPane;
	private JTable table;
	private JTextField timKiemText;
	private JTextField maLoaiText;
	private JTextField theLoaiText;
	private JTable table_ds = new JTable();
	private JScrollPane scrollPane = new JScrollPane(table_ds);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheLoai_GUI frame = new TheLoai_GUI();
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
	public TheLoai_GUI() {
		Icon them = new ImageIcon("src/IMG/anh/them.png");
		Icon timKiem = new ImageIcon("anh/timKiem.png");
		Color maincolor=new Color(33,115,70);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);



		JPanel pnThem = new JPanel();
		pnThem.setBounds(0, 0, 1286, 230);
		contentPane.add(pnThem);
		pnThem.setLayout(null);

		JLabel lbMaLoai = new JLabel("Mã Loại :");
		lbMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbMaLoai.setBounds(33, 83, 91, 33);
		pnThem.add(lbMaLoai);

		JLabel lbTenLoai = new JLabel("Tên Thể Loại");
		lbTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTenLoai.setBounds(33, 146, 133, 38);
		pnThem.add(lbTenLoai);

		maLoaiText = new JTextField();
		maLoaiText.setBounds(176, 91, 271, 26);
		pnThem.add(maLoaiText);
		maLoaiText.setEditable(false);
		maLoaiText.setColumns(10);

		theLoaiText = new JTextField();
		theLoaiText.setColumns(10);
		theLoaiText.setBounds(176, 157, 271, 26);
		pnThem.add(theLoaiText);


		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", 0,20));
		btnThem.setBounds(33, 190, 150, 33);

		btnThem.setIcon(them);
		btnThem.setBackground(maincolor);
		pnThem.add(btnThem);

		JScrollPane scrollPane = new JScrollPane(table_ds);
		getContentPane().add(scrollPane);
		JPanel pnTitle = new JPanel(new GridLayout());
		pnThem.add(pnTitle);
		pnTitle.setBackground(new Color(33,115,70));
		pnTitle.setBounds(0,0,1300,60);
		JLabel lbTheLoai = new JLabel("THỂ LOẠI");
		lbTheLoai.setForeground(Color.white);
		pnTitle.add(lbTheLoai);
		lbTheLoai.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTheLoai.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setBounds(0, 227, 1286, 476);
		contentPane.add(pnDanhSach);
		pnDanhSach.setLayout(null);


		JLabel lbDanhSach = new JLabel("DANH SÁCH");
		lbDanhSach.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbDanhSach.setBounds(38, 26, 149, 25);
		pnDanhSach.add(lbDanhSach);

		scrollPane.setBounds(10, 61, 1253, 415);
		table_ds.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_ds.setRowHeight(30);
		pnDanhSach.add(scrollPane);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addData();
			}
		});
		reloadTable();

		table_ds.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i=table_ds.getSelectedRow();

				maLoaiText.setText(String.valueOf(table_ds.getValueAt(i, 0)));
				theLoaiText.setText(String.valueOf(table_ds.getValueAt(i, 1)));
			}
		});
//				btnTimKiem.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						for(int i=0;i<bus.getdsTheLoai().size();i++)
//						{
//							if(bus.getdsTheLoai().get(i).getTenLoai().equals(theLoaiText.getText()))
//							{
//								reloadTable();
//							}
//						}
//					}
//				});


	}
	public void reloadTable() {
		addDBToTable(theLoai_bus.getdsTheLoai());
	}
	private void addDBToTable(ArrayList <TheLoai> lst){
		DefaultTableModel nModel = new DefaultTableModel();
		nModel.addColumn("Mã loại");
		nModel.addColumn("Tên thể loại");


		for (TheLoai theLoai : lst){
			Vector data = new Vector();
			data.add(theLoai.getMaLoai());
			data.add(theLoai.getTenLoai());

			nModel.addRow(data);
		}
		table_ds.setModel(nModel);
	}


	private void addData(){
		if(theLoaiText.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập tên thể loại!");
			return;
		}
		TheLoai theLoai = new TheLoai();

		theLoai.setMaLoai(bus.getdsTheLoai().size()+1);
		theLoai.setTenLoai(theLoaiText.getText());
		bus.addData(theLoai);
		reloadTable();
	}

}
