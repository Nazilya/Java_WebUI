package com.geekbrains.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Story("Заявка на расход")
public class Login2Test extends BaseTest {

    @BeforeEach
    void setupBrowser2() {
        webDriver.get("https://crm.geekbrains.space/");
    }

    @Test
    @Description("Тест создания заявки на расход")
    @TmsLink("234")
    void loginTest() {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Расходы");
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

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Заявка на расход сохранена']")).isDisplayed());

        Thread.sleep(3000);
        //webDriver.get("https://afisha.ru");
    }
}