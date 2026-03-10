package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest{
    
    @Test
    void findRepositoryTest(){
        /*
         * Тест-кейс перейти по ссылке на сайт и найти репозиторий с которого мы копировали код
         * 1. открыть ссылку https://github.com/java-automation-qa/getting-started/wiki/
         * 2. нажать на кнопку 1.Устновка Java
         * 3. нажать кнопку code
         * 4. нажать на кнопку src/test/java
         * 5. нажать на кнопку StudyTest.java
         * проверить что репозиторий называется StudyTest.java
         */

        Configuration.pageLoadTimeout = 10000; // таймаут прогрузки страницы
        Configuration.timeout = 10000; // таймаут прогрузки элементов
        Configuration.holdBrowserOpen = true;


 open("https://github.com/java-automation-qa/getting-started/wiki/");
     $(byText("1. Установка Java")).click();
        $(byText("Code")).click();
        $x("//*[@id=\"folder-row-0\"]/td[2]/div/div").click();
        sleep(3000);
        $$(".Link--primary").get(1).click();
        $("a[data-testid='breadcrumbs-repo-link']").shouldHave(text("getting-started"));

    }
}
