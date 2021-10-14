package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement createProjectButton;
    public ProjectsSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку Все проекты")
    public ProjectsPage projectsButtonClick() {
        createProjectButton.click();
        return new ProjectsPage(webDriver);
    }
}
