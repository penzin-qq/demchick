package ru.bulgakov.mentor;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.mentor.pages.PaymentPage;
import ru.bulgakov.mentor.pages.WelcomePage;
import ru.bulgakov.mentor.pages.YandexSearcResultsPage;
import ru.bulgakov.mentor.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
        Configuration.pageLoadTimeout = 10000; // таймаут прогрузки страницы
        Configuration.timeout = 10000; // таймаут прогрузки элементов
        Configuration.holdBrowserOpen = true;

        YandexSearchPage yaSearch = new YandexSearchPage();
        YandexSearcResultsPage yaSearchResults = new YandexSearcResultsPage();
        WelcomePage welcomePage = new WelcomePage();
        PaymentPage paymentPage = new PaymentPage();

        open("https://ya.ru/");
yaSearch
        .search("bulgakov qa")
        .submit();
yaSearchResults.closeDefaultBrowserSelectWindow()
        .openLink("ivanbulgakovqa.ru");
         switchTo().window(1);
welcomePage
        .clickPrice()
        .clickGetInto()
        .clickRunningToPay();
        switchTo().window(2);
        paymentPage
                .priceCheck(" ₽ 47 000 ");


    }
}

