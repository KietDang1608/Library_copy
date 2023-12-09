package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePicker extends JPanel {
    private String[] years = {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010"};
    private final String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private final String[] days = new String[31];
    private JComboBox<String> yearComboBox = new JComboBox<>(years);
    private final JComboBox<String> monthComboBox = new JComboBox<>(months);
    private JComboBox<String> dayComboBox = new JComboBox<>(days);


    public DatePicker(){
        this.init();
    }
    public void init(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel lbNam = new JLabel("Năm:");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(lbNam,gbc);


        yearComboBox.setBackground(Color.white);
        monthComboBox.setBackground(Color.white);
        dayComboBox.setBackground(Color.white);
        yearComboBox.setForeground(Color.blue);
        monthComboBox.setForeground(Color.blue);
        dayComboBox.setForeground(Color.blue);

        //Tao action
        yearComboBox.addActionListener(e -> updateDays());
        monthComboBox.addActionListener(e -> updateDays());
        //dat nam va thang mac dinh theo nam thang hien hanh
        LocalDate currentDate = LocalDate.now();
        yearComboBox.setSelectedItem(String.valueOf(currentDate.getYear()));
        monthComboBox.setSelectedItem(currentDate.format(DateTimeFormatter.ofPattern("MM")));

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(yearComboBox,gbc);
        JLabel lbThang = new JLabel("Tháng:");
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(lbThang,gbc);

        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(monthComboBox,gbc);

        JLabel lbNgay = new JLabel("Ngày:");

        gbc.gridx=4;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(lbNgay,gbc);

        gbc.gridx=5;
        gbc.gridy=0;
        gbc.gridwidth=1;
        add(dayComboBox,gbc);



        Font font = new Font("Tahoma", Font.PLAIN, 15);

        lbNam.setFont(font);
        lbNgay.setFont(font);
        lbThang.setFont(font);
        yearComboBox.setFont(font);
        monthComboBox.setFont(font);
        dayComboBox.setFont(font);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                yearComboBox.setBackground(Color.white);
                monthComboBox.setBackground(Color.white);
                dayComboBox.setBackground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                yearComboBox.setBackground(Color.white);
                monthComboBox.setBackground(Color.white);
                dayComboBox.setBackground(Color.white);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                yearComboBox.setBackground(Color.white);
                monthComboBox.setBackground(Color.white);
                dayComboBox.setBackground(Color.white);

            }
        });

    }
    public void turnOffEdit(){
        dayComboBox.setEditable(false);
        yearComboBox.setEditable(false);
        monthComboBox.setEditable(false);
    }

    private  void updateDays() {
        String selectedYear = (String) yearComboBox.getSelectedItem();
        String selectedMonth = (String) monthComboBox.getSelectedItem();
        int numDays = LocalDate.of(Integer.parseInt(selectedYear), Integer.parseInt(selectedMonth), 1).lengthOfMonth();
        String[] days = new String[numDays];
        for (int i = 1; i <= numDays; i++) {
            days[i - 1] = String.format("%02d", i);
        }
        dayComboBox.setModel(new DefaultComboBoxModel<>(days));
    }
    public void RightNow()
    {
        LocalDate currentDate = LocalDate.now();
        dayComboBox.setSelectedItem(String.valueOf(currentDate.getDayOfMonth()));
    }
    //set null cho ngay thang nam
    public void setNull(){
//        try {
//            yearComboBox.setSelectedIndex(-1);
//        }catch (NumberFormatException e){}
//        try {
//            monthComboBox.setSelectedIndex(-1);
//        }catch (NumberFormatException e){}
//        try {
//            dayComboBox.setSelectedIndex(-1);
//        }catch (NumberFormatException e){}
    }
    //Ham tra ve chuoi ngay theo dinh dang yyyy-mm-dd
    public String getDate(){
        String year = String.valueOf(yearComboBox.getSelectedItem());
        String month = String.valueOf(monthComboBox.getSelectedItem());
        String day = String.valueOf(dayComboBox.getSelectedItem());
        return year+"-"+month+"-"+day;
    }
    //lay du lieu localdate tu chuoi nam-thang-ngay
    public LocalDate getLocalDate(String date){
        return LocalDate.parse(date);
    }
    //Ham thay doi danh sach nam trong combobox nam(tinh tu start den nam hien hanh)
    public void changedYears(int start){
        int year = LocalDate.now().getYear();
        String[] newyears = new String[year-start+1];
        int t = 0;
        for (int i = year;i>=start;i--){
            newyears[t++] = String.valueOf(i);
        }
        yearComboBox.setModel(new DefaultComboBoxModel<>(newyears));
    }
    //Ham set font,
    public void setCBFont(int fontSize){
        yearComboBox.setFont(new Font("arial",0,fontSize));
        monthComboBox.setFont(new Font("arial",0,fontSize));
        dayComboBox.setFont(new Font("arial",0,fontSize));
    }
    //Set gia tri cho Combobox
    public void setCB(String year, String month, String day){
        yearComboBox.setSelectedItem(year);
        monthComboBox.setSelectedItem(month);
        dayComboBox.setSelectedItem(day);
    }
    ////Set gia tri cho Combobox theo chuoi yyyy-mm-dd
    public void setCB(String date){
        String []s = date.split("-");
        yearComboBox.setSelectedItem(s[0]);
        monthComboBox.setSelectedItem(s[1]);
        dayComboBox.setSelectedItem(s[2]);

    }
    public void submit(){
        setVisible(false);
    }
}
/*
File gồm có các hàm sử dụng nhiều sau:
getDate(); Trả về chuỗi ngày tháng được lấy từ combobox có định dạng yyyy-mm-dd
changedYears(int start); Thay đổi danh sách các năm trong combobox năm(tính từ start đến năm hiện tại)
setCBFont(int fontSize); Thay đổi kích thước font
setCB(String year, String month, String day); set ngày tháng cho các combobox (giống setText)
setCB(String date); Chức năng giống trên nhưng khác tham số truyền vào(yyyy-mm-dd)

Cần thay đổi kích thước toàn bộ panel thì setbound như bình thường

 */
