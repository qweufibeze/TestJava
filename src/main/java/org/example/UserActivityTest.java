package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class UserActivityTest {
    private  WebDriver driver;
    private static final String BASE_URL = "https://my.tretyakov.ru/app/";
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testLoginAndAddToCart() {
        //ищем определенный UI
        WebElement toEnterLogPassIcon = driver.findElement(By.className("header-round-btn"));
        WebElement toEnterLogPassIconText = driver.findElement(By.className("header-entrance link-default--white"));
        // проверяем наличие действия
        toEnterLogPassIcon.click();
    }
}

