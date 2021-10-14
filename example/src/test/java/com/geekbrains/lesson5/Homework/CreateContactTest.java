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

public class CreateContactTest {
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
    void createContactPositiveTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//span[text()='Контрагенты']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//span[text()='Контрагенты']"))));
        driver.findElement(By.xpath("//a//span[text()='Контрагенты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Контактные лица']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Контактные лица']"))));
        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать контактное лицо']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Создать контактное лицо']"))));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_contact[lastName]']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']"))));
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Фамилия");

        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_firstName-uid')]")).sendKeys("Имя");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Bins-Haley']")));
        driver.findElement(By.xpath("//div[text()='Bins-Haley']")).click();

        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Директор");

        driver.findElement(By.xpath("//a[.='Контактная информация']")).click();
        driver.findElement(By.xpath("//a[.='Добавить телефон']")).click();

        Select managerSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_contact[phones][1][type]']")));
        managerSelect.selectByVisibleText("Мобильный");
        driver.findElement(By.xpath("//input[@placeholder='Код'][2]")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='Номер']")).sendKeys("1234567");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='Контактное лицо сохранено']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.='Контактное лицо сохранено']"))));
        String element = driver.findElement(By.xpath("//div[.='Контактное лицо сохранено']")).getText();

        Assertions.assertEquals("Контактное лицо сохранено", element);

        Thread.sleep(3000);

        driver.quit();
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
