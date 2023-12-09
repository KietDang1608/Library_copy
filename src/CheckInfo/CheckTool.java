package CheckInfo;

import java.time.LocalDate;

public class CheckTool {
    public CheckTool(){}
    //Lấy ngày dạng local date
    public LocalDate getLocalDate(int nam, int thang, int ngay)
    {
        LocalDate local = LocalDate.of(nam, thang, ngay);
        return local;

    }
    public String getStringDate(LocalDate date){
        String day = String.valueOf(date.getDayOfMonth());
        String month = String.valueOf(date.getMonthValue());
        String year = String.valueOf(date.getYear());

        return year + "-" + month + "-" + day;
    }
    //Kiểm tra ngày được truyền vào có phải hôm nay
    public int isToday(LocalDate ngay) {
        LocalDate ngayHD = LocalDate.now();
        if (ngay.isAfter(ngayHD)) return 1;
        else if (ngay.isBefore(ngayHD)) return -1;
        else return 0;
    }
    //So sánh ngày 1 và ngày 2
    public int compareDate(LocalDate s1,LocalDate s2){

        if (s1.isAfter(s2)) return 1;
        else if (s1.isBefore(s2)) return -1;
        else return 0;
    }
    //Kiểm tra username hợp lệ
    public boolean isValidUsername(String username)
    {
        return username.length() >= 5 && username.matches("^[a-zA-Z0-9]+$");
    }
    //Kiểm tra password hợp lệ
    public boolean isValidPassword(String password)
    {
        return password.length()>0 && password.indexOf(" ") == -1;
    }
    //Kiểm tra tên hợp lệ
    public boolean checkName(String name) {
        return name.matches("^[\\p{L}\\s]+$");
    }
    //Format lại tên
    public String formatName(String name)
    {
        name = name.trim();
        name = name.replaceAll("\\s+", " ");
        String firstChar = name.substring(0, 1);
        String remainingChar = name.substring(1, name.length());
        firstChar = firstChar.toUpperCase();
        name = firstChar + remainingChar;
        return name;
    }
    //Kiểm tra mail hợp lệ
    public boolean isValidEmail(String email){
        return(email.matches("^[A-Za-z0-9+_.-]+@(.*\\.com|.*\\.mymaildomain)$"));

    }
    //Kiểm tra số điện thoại hợp lệ
    public boolean isValidPhoneNum(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0)=='0') {
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    //Format lại nội dung dài
    public String formatInfo(String Info){
        while (Info.contains("  ")) {
            Info = Info.replaceAll("  ", " ");
        }
        return Info;
    }
    //chuyen doi chuoi tieng viet co dau thanh khong dau

    public String convertVietnameseString(String vietnameseString) {
        char[] charArray = vietnameseString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            switch (ch) {
                case 'à':
                case 'á':
                case 'ả':
                case 'ã':
                case 'ạ':
                case 'â':
                case 'ầ':
                case 'ấ':
                case 'ẩ':
                case 'ẫ':
                case 'ậ':
                case 'ă':
                case 'ằ':
                case 'ắ':
                case 'ẳ':
                case 'ẵ':
                case 'ặ':
                    charArray[i] = 'a';
                    break;
                case 'è':
                case 'é':
                case 'ẻ':
                case 'ẽ':
                case 'ẹ':
                case 'ê':
                case 'ề':
                case 'ế':
                case 'ể':
                case 'ễ':
                case 'ệ':
                    charArray[i] = 'e';
                    break;
                case 'ì':
                case 'í':
                case 'ỉ':
                case 'ĩ':
                case 'ị':
                    charArray[i] = 'i';
                    break;
                case 'ò':
                case 'ó':
                case 'ỏ':
                case 'õ':
                case 'ọ':
                case 'ô':
                case 'ồ':
                case 'ố':
                case 'ổ':
                case 'ỗ':
                case 'ộ':
                case 'ơ':
                case 'ờ':
                case 'ớ':
                case 'ở':
                case 'ỡ':
                case 'ợ':
                    charArray[i] = 'o';
                    break;
                case 'ù':
                case 'ú':
                case 'ủ':
                case 'ũ':
                case 'ụ':
                case 'ư':
                case 'ừ':
                case 'ứ':
                case 'ử':
                case 'ữ':
                case 'ự':
                    charArray[i] = 'u';
                    break;
                case 'ỳ':
                case 'ý':
                case 'ỷ':
                case 'ỹ':
                case 'ỵ':
                    charArray[i] = 'y';
                    break;
                case 'À':
                case 'Á':
                case 'Ả':
                case 'Ã':
                case 'Ạ':
                case 'Â':
                case 'Ầ':
                case 'Ấ':
                case 'Ẩ':
                case 'Ẫ':
                case 'Ậ':
                case 'Ă':
                case 'Ằ':
                case 'Ắ':
                case 'Ẳ':
                case 'Ẵ':
                case 'Ặ':
                    charArray[i] = 'A';
                    break;
                case 'È':
                case 'É':
                case 'Ẻ':
                case 'Ẽ':
                case 'Ẹ':
                case 'Ê':
                case 'Ề':
                case 'Ế':
                case 'Ể':
                case 'Ễ':
                case 'Ệ':
                    charArray[i] = 'E';
                    break;
                case 'Ì':
                case 'Í':
                case 'Ỉ':
                case 'Ĩ':
                case 'Ị':
                    charArray[i] = 'I';
                    break;
                case 'Ò':
                case 'Ó':
                case 'Ỏ':
                case 'Õ':
                case 'Ọ':
                case 'Ô':
                case 'Ồ':
                case 'Ố':
                case 'Ổ':
                case 'Ỗ':
                case 'Ộ':
                case 'Ơ':
                case 'Ờ':
                case 'Ớ':
                case 'Ở':
                case 'Ỡ':
                case 'Ợ':
                    charArray[i] = 'O';
                    break;
                case 'Ù':
                case 'Ú':
                case 'Ủ':
                case 'Ũ':
                case 'Ụ':
                case 'Ư':
                case 'Ừ':
                case 'Ứ':
                case 'Ử':
                case 'Ữ':
                case 'Ự':
                    charArray[i] = 'U';
                    break;
                case 'Ỳ':
                case 'Ý':
                case 'Ỷ':
                case 'Ỹ':
                case 'Ỵ':
                    charArray[i] = 'Y';
                    break;
                case 'đ':
                    charArray[i] = 'd';
                    break;
                case 'Đ':
                    charArray[i] = 'D';
                    break;
            }
        }

        return new String(charArray);
    }
}
