package ru.bulgakov.webshop.test;

import com.codeborne.selenide.Configuration;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.CartPage;
import ru.bulgakov.webshop.pages.ProductPage;
import ru.bulgakov.webshop.pages.WsRegistrationPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
private final AuthSteps authSteps = new AuthSteps();
    @BeforeEach

    void beforeEach(){
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest(){
        Configuration.pageLoadTimeout = 100000;
        Configuration.timeout = 100000;
ProductPage productPage = open(WEB_SHOP_URL, WsWelcomePage.class)
        .hoverItemCategory(1)
                .itemChooseCategore("Desktops")
        .hoverSelectProduct(0);

        String itemName = productPage.getProductName();
        String itemPrice = productPage.getProductPrice();
        String itemQuantity = productPage.getDefaultQuantity();

        productPage.selectFirstOptoin()
                .setQuantity(itemQuantity)
                .addToCard()
                .verifyAddToCard(itemQuantity);

        CartPage cartPage = productPage.openCart()
                .verifyProductNameInCart(itemName);


        String itemQuantityInCart = cartPage.getQuantityInCart();
        assertEquals(itemQuantity, itemQuantityInCart);

        String expectedSubtotal = String.valueOf(
  Float.parseFloat(itemPrice)* Float.parseFloat(itemQuantity)
        );

    }
}
