package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
 private final SelenideElement productNameInCart = $("a.product-name");
 private final SelenideElement quantityInputInCart = $("input.qty-input");
 private final SelenideElement productSubtotal =  $("span.product-subtotal");



 public CartPage verifyProductNameInCart(String productName){
     productNameInCart.shouldHave(text(productName));
     return this;
 }
 public String getQuantityInCart(){
     return quantityInputInCart.getAttribute("value");
 }
public String getSubtotal(){
     return productSubtotal.getText();
}
}
