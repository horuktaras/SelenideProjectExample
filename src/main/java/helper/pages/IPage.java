package helper.pages;

import com.codeborne.selenide.Selenide;

public interface IPage<T> {
    default String getTitle() {
        return Selenide.title();
    }

    default void refresh() {
        Selenide.refresh();
    }
}
