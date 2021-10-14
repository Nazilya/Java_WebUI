package com.geekbrains.lesson5.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateProjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
        login();
    }
    @Test
    void projectNameInUseTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//span[.='Проекты']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//span[.='Проекты']"))));
        driver.findElement(By.xpath("//a//span[.='Проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Все проекты']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Все проекты']"))));
        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Создать проект']"))));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'crm_project_name')]")));
        driver.findElement(By.xpath("//input[contains(@id,'crm_project_name')]")).sendKeys("testCreateProject");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select prioritySelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[priority]']")));
        prioritySelect.selectByVisibleText("Высокий");

        Select financeSourceSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")));
        financeSourceSelect.selectByVisibleText("Инвестиции");

        Select businessUnitSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curatorSelect.selectByVisibleText("Скоробогатова Юлия");

        Select rpSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        rpSelect.selectByVisibleText("Зайдуллин Рустам");

        Select administratorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        administratorSelect.selectByVisibleText("Горячев Алексей");

        Select managerSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        managerSelect.selectByVisibleText("Исаева Анастасия");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Планирование");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Требование");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_development')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@name='crm_project[configManagement]']")).sendKeys("Конфигурация");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Это значение уже используется.']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Это значение уже используется.']"))));
        String element = driver.findElement(By.xpath("//span[.='Это значение уже используется.']")).getText();
        Assertions.assertEquals("Это значение уже используется.", element);

        String elementColor = driver.findElement(By.xpath("//span[.='Это значение уже используется.']")).getCssValue("color");
        Assertions.assertEquals(elementColor, "rgba(200, 23, 23, 1)");

        Thread.sleep(5000);

    }
    @Test
    void checkNavbarLinkNameTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        List<WebElement> headers = driver.findElements(By.xpath("//ul[@class='nav']//li"));
        Assertions.assertEquals("Деньги", headers.get(5).getText());
        Thread.sleep(3000);
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
    public void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
