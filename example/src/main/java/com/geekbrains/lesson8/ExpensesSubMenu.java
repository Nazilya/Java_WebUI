package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ExpensesSubMenu {
    private SelenideElement createExpenseButton = $(By.xpath("//span[.='Заявки на расходы']"));

    @Step("Клик на кнопку Расходы")
    public ExpensesPage expensesButtonClick() {
        createExpenseButton.click();
        return page(ExpensesPage.class);
    }
}