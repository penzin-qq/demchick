package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage {
    private final SelenideElement clickPrice =  $$(".t-menu__list li").get(4);
    private final SelenideElement clickGetInto = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement clickRunningToPay =  $(byText("Бегу оплачивать"));


    public WelcomePage clickPrice() {

        clickPrice.click();

        return this;

    }
    public WelcomePage clickGetInto() {

        clickGetInto.click();

        return this;

    }
    public WelcomePage clickRunningToPay() {

        clickRunningToPay.click();

        return this;

    }

}
