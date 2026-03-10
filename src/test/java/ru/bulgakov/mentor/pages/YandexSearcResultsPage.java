package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearcResultsPage {
    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearcResultsPage closeDefaultBrowserSelectWindow() {
        closeWindow.click();

        return this;
    }

    public YandexSearcResultsPage openLink(String webSiteName) {
        $(byText(webSiteName)).click();

        return this;
    }
}
