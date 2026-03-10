package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private final SelenideElement itemName = $("[itemprop=name]");
    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final SelenideElement firstOption = $$("dl dd ul li").get(0).$$("li input").get(0);
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement addToCardButton = $("input.add-to-cart-button");
    private final SelenideElement succesNotification = $("div.bar-notification.success");
    private final SelenideElement cartIconCounter = $("span.cart-qty");
    private final SelenideElement cartIconLink = $("a.ico-cart");




    public  String getProductName(){
        return itemName.getText();
    }
    public String getProductPrice(){

        return itemPrice.getText();
    }
    public String getDefaultQuantity(){
        return "2";
    }
public ProductPage selectFirstOptoin(){
        firstOption.click();
        return this;
}
public ProductPage setQuantity(String quantity){
    quantityInput.setValue(quantity);
        return this;
}
public ProductPage addToCard(){
    addToCardButton.click();
        return this;
}
public ProductPage verifyAddToCard(String expectedQuantity){
    succesNotification.shouldBe(visible);
    cartIconCounter.shouldHave(text("(" + expectedQuantity + ")"));
        return this;
}
public CartPage openCart(){
    cartIconLink.click();
    return new CartPage();
}
}
