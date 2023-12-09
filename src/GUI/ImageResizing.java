package GUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizing {
    public ImageResizing(){}

    public void resizeImg(String path,int newWidth, int newHeight){
        try {
            // Đọc hình ảnh từ tệp vào một BufferedImage
            File inputFile = new File(path);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // Kích thước mới mà bạn muốn

            // Tạo một BufferedImage mới với kích thước mới
            BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

            // Thay đổi kích thước hình ảnh bằng cách vẽ lại từ hình ảnh gốc
            outputImage.createGraphics().drawImage(inputImage, 0, 0, newWidth, newHeight, null);

            // Lưu hình ảnh đã thay đổi kích thước vào tệp mới
            File outputFile = new File(path);
            ImageIO.write(outputImage, "png", outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
