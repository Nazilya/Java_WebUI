package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsSubMenu {
    private SelenideElement createProjectButton = $(By.xpath("//span[.='Все проекты']"));


    @Step("Клик на кнопку Все проекты")
    public ProjectsPage projectsButtonClick() {
        createProjectButton.click();
        return page(ProjectsPage.class);
    }
}
