package commons;

public class StringFormatUtil {
    private final static String CONCATENATION = "%s%s";
    private final static String SCREEN_RESOLUTION = "%sx%s";

    public static String concatenation(String first, String second) {
        return String.format(CONCATENATION, first, second);
    }

    public static String resolution(int screenWidth, int screenHeight) {
        return String.format(SCREEN_RESOLUTION, screenWidth, screenHeight);
    }
}