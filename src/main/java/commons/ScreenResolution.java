package commons;

import java.awt.*;

public class ScreenResolution {

    public static final String FULL_HD = StringFormatUtil.resolution(1920, 1080);

    public static String currentScreenResolution(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        return StringFormatUtil.resolution(screenWidth, screenHeight);
    }
}
