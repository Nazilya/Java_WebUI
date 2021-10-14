package com.geekbrains.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Story("Ссоздание проекта")
public class CreateProjectTest extends BaseTest {

    @BeforeEach
    void setupBrowser2() {
        webDriver.get("https://crm.geekbrains.space/");
    }
    @Test
    @Description("Тест создания проекта")
    void createProjectTest() throws InterruptedException {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin()
                .navigationMenu.openNavigationSubMenuItems("Проекты");
        //new ExpensesSubMenu(webDriver).expensesButtonClick().createExpenseButtonClick();
        new ProjectsSubMenu(webDriver).projectsButtonClick().createProjectButtonClick();
        new CreateProjectPage(webDriver)
                .fillprojectName("test")
                .organizationClick()
                .organizationTypeClick()
                .selectPriority("Высокий")
                .selectFinanceSource("Инвестиции")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Скоробогатова Юлия")
                .selectRp("Зайдуллин Рустам")
                .selectAdministrator("Горячев Алексей")
                .selectManager("Исаева Анастасия")
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Это значение уже используется.']")));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//span[.='Это значение уже используется.']")).isDisplayed());

        Thread.sleep(3000);
    }
}
