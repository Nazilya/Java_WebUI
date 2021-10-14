package com.geekbrains.lesson6;

import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    EventFiringWebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new EventFiringWebDriver(new ChromeDriver());
        webDriver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get("https://crm.geekbrains.space/");
    }

    @Test
    @Disabled
    @Description("Тест создания заявки на расход")
    void createExpensesTest() throws InterruptedException {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin()
                .navigationMenu.openNavigationSubMenuItems("Расходы");
        new ExpensesSubMenu(webDriver)
                .expensesButtonClick()
                .createExpenseButtonClick();
        new CreateExpensePage(webDriver)
                .fillExpenseAppointment("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectCurrency("Доллар США")
                .fillSumPlanInput("100")
                .selectPlannedDate("15")
                .saveAndCloseButtonClick();
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Заявка на расход сохранена']")).isDisplayed());

    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}