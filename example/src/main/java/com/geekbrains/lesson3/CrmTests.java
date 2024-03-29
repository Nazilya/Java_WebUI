package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmTests {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        driver.get(CRM_URL);
        login();
        //Thread.sleep(5000);

        List<WebElement> navMenuElements = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li/a"));
        WebElement expenceElement = navMenuElements.stream().filter(e -> e.getText().equals("Расходы")).findFirst().get();
        Actions actions = new Actions(driver);
        actions.moveToElement(expenceElement).build().perform();

        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать заявку на расход']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Создать заявку на расход']"))));
        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea")));
        driver.findElement(By.cssSelector("textarea")).sendKeys("test");

        Select businessUnitSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_expense_request[businessUnit]']")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_expense_request[expenditure]']")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        Select currencySelect = new Select(driver.findElement(By.xpath("//select[@name='crm_expense_request[currency]']")));
        currencySelect.selectByVisibleText("Доллар США");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        Thread.sleep(3000);
        driver.quit();

    }
    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}