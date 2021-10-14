package com.geekbrains.lesson3.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createProject {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        driver.get(CRM_URL);
        login();

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

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        //div[.='Проект сохранен']

        Thread.sleep(10000);
        driver.quit();

    }
    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
