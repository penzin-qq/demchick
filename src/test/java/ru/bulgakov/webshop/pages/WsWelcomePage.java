package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ru.bulgakov.mentor.pages.WsLoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginButton = $("a.ico-login");
    private final ElementsCollection checkEmail = $$("div.header-links ul li a");
    private final ElementsCollection itemCategories = $$("ul.top-menu li a");
    private final SelenideElement chooseCategory = $(byText("Desktops"));
    private final ElementsCollection selectProduct = $$("div.product-grid div");



    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return new WsRegistrationPage();
    }
    public WsLoginPage openLogin() {
        loginButton.click();
        return new WsLoginPage();
    }
    public WsWelcomePage verifyEmail(String email) {
        checkEmail.get(0).shouldHave(text(email));
        return this;

    }
    public WsWelcomePage hoverItemCategory(int index) {
        itemCategories.get(index).hover();
        return this;
    }
    public WsWelcomePage itemChooseCategore(String categoryName){
        $(byText(categoryName)).click();
        return this;
    }
    public ProductPage hoverSelectProduct(int index ){
        selectProduct.get(index).click();
        return new ProductPage();
    }
}
