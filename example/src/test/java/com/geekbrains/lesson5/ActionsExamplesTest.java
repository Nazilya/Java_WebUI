package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.TreeMap;

import static com.geekbrains.lesson5.CustomExpectedConditions.elementWithTextFirstInCollection;

public class ActionsExamplesTest {
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
    void dragAndDropTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://crm.geekbrains.space/dashboard");

        driver.findElement(By.xpath("//a[@title='Настройки представления']")).click();

        actions.clickAndHold(driver.findElement(By.xpath("//label[.='Наименование']//ancestor::tr//span[@title='Move column']")))
                .dragAndDrop(driver.findElement(By.xpath("//label[.='Наименование']//ancestor::tr")),
                        driver.findElement(By.xpath("//label[.='Владелец']//ancestor::tr")))
                .build()
                .perform();

        //Thread.sleep(1000);//TODO: заменить на хорошее ожидание
        //webDriverWait.until(driver -> driver.findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class,'sortable')]"))
        //        .get(0).getText().equals("ВЛАДЕЛЕЦ"));

        webDriverWait.until(elementWithTextFirstInCollection(By.xpath("//thead[@class='grid-header']//th[contains(@class,'sortable')]"),
                "ВЛАДЕЛЕЦ"));

        List<WebElement> headers = driver.findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class,'sortable')]"));

        Assertions.assertEquals("ВЛАДЕЛЕЦ", headers.get(0).getText());

        Thread.sleep(5000);
    }

    @Test
    void checkRowColorChangesAfterCheckBoxClickTest() {
        driver.get("https://crm.geekbrains.space/dashboard");
        driver.findElement(By.xpath("//thead[@class='grid-header']//input")).click();
        String elementColor = driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]")).getCssValue("background-color");
        Assertions.assertEquals(elementColor, "rgba(254, 250, 237, 1)");
    }

    @Test
    void iframeTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();

        driver.findElement(By.name("crm_project[name]")).sendKeys("test");

        Thread.sleep(5000);
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
