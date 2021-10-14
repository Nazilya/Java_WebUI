package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BaseView {
    public ProjectsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//a[.='Создать проект']")
    public WebElement createProjectButton;

    @Step("Клик на кнопку создания проекта")
    public ProjectsPage createProjectButtonClick() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        createProjectButton.click();
        return new ProjectsPage(webDriver);
}
}
