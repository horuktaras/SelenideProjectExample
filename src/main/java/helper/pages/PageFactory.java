package helper.pages;

public class PageFactory {
    public static <T extends IPage<T>> T init(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page instance", e);
        }
    }
}