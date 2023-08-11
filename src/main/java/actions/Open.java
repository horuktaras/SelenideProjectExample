package actions;

import helper.Params;
import helper.pages.IPage;
import helper.pages.PageFactory;
import helper.pages.Url;

import static com.codeborne.selenide.Selenide.open;

public class Open {

    public static Open browserOn() {
        return new Open();
    }

    public void the(String url, Params params) {
        String resolvedUrl = params.applyOn(url);
        open(resolvedUrl);
    }

    public void the(String url) {
        open(url);
    }

    public <T extends IPage<T>> T the(Class<T> pageObjectClass) {
        Url urlAnnotation = pageObjectClass.getAnnotation(Url.class);
        if (urlAnnotation == null) {
            throw new RuntimeException("Page object class must be annotated with @Url");
        }
        open(urlAnnotation.value());
        return PageFactory.init(pageObjectClass);
    }

    public <T extends IPage<T>> T the(Class<T> pageObjectClass, Params params) {
        Url urlAnnotation = pageObjectClass.getAnnotation(Url.class);
        if (urlAnnotation == null) {
            throw new RuntimeException("Page object class must be annotated with @Url");
        }
        String url = params.applyOn(urlAnnotation.value());
        open(url);
        return PageFactory.init(pageObjectClass);
    }
}