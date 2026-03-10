package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private final SelenideElement priceLabel =  $(".styles_price__2lruq h2");

    public PaymentPage priceCheck(String price) {

        priceLabel.shouldHave(text(price));

        return this;

    }

}

