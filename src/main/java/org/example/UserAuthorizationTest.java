package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.test.mainMethod;


public class UserAuthorizationTest {
    final static String BASE_URL = "https://my.tretyakov.ru/app/";
    final static String AUTH_URL = "https://my.tretyakov.ru/app/profile/detail";

    static String iconThreadUrl;
    static String wordThreadUrl;

    final static WebDriver driverChromeIcon = new ChromeDriver();
    final static WebDriver driverChromeWord = new ChromeDriver();

    static WebDriverWait waitIcon = new WebDriverWait(driverChromeIcon, Duration.ofSeconds(15));
    static WebDriverWait waitWord = new WebDriverWait(driverChromeWord, Duration.ofSeconds(15));

    public static void main(String[] args) throws InterruptedException {
        String[] urls = runTestAuthorization();
        System.out.println("Icon Thread URL: " + urls[0]);
        System.out.println("Word Thread URL: " + urls[1]);
    }

    public static String[] runTestAuthorization() throws InterruptedException {

        driverChromeIcon.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driverChromeWord.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Создаем два потока и запускаем методы в них
        Thread iconThread = new Thread(() -> authorizationWayIcon(driverChromeIcon));
        Thread wordThread = new Thread(() -> authorizationWayWord(driverChromeWord));

        iconThread.start();
        wordThread.start();

        iconThread.join();
        wordThread.join();

        iconThreadUrl = driverChromeIcon.getCurrentUrl();
        wordThreadUrl = driverChromeIcon.getCurrentUrl();

        return new String[]{iconThreadUrl, wordThreadUrl};
    }

    public static void authorizationWayIcon(WebDriver driver) {
        driver.get(BASE_URL);
        // Нажимаем на иконку авторизации
        WebElement authorizationIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/a"));
        if (authorizationIcon.isDisplayed()) {
            authorizationIcon.click();
        }
        enterLogPass(driver);
        waitIcon.until(ExpectedConditions.urlToBe(AUTH_URL));
    }

    public static void authorizationWayWord(WebDriver driver) {
        driver.get(BASE_URL);
        WebElement authorizationWord = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
        if (authorizationWord.isDisplayed()) {
            authorizationWord.click();
        }
        enterLogPass(driver);
        waitWord.until(ExpectedConditions.urlToBe(AUTH_URL));
    }

    public static void enterLogPass(WebDriver webDriver) {
        WebElement loginInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label/input"));
        if (loginInput.isDisplayed()) {
            loginInput.click();
        }
        loginInput.sendKeys("alexandrobol@yandex.ru");

        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label/input"));
        if (passwordInput.isDisplayed()) {
            passwordInput.click();
        }
        passwordInput.sendKeys("12345678910");

        WebElement enterButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
    }
}
