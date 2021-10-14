package com.geekbrains.lesson3.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createContact {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        driver.get(CRM_URL);
        login();

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

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
