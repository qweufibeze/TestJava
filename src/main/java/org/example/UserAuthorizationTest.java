package org.example;

import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAuthorizationTest extends MainMethod{
    static final MainMethod mainMethod = new MainMethod();
    static final WebDriver driverChrome = new ChromeDriver();
    static final String BASE_URL = "https://my.tretyakov.ru/app/";
    @Test
    public static void main(String[] args) {
        authorizationWayIcon();
        getBackToMainMenu();
        authorizationWayWord();
        getBackToMainMenu();
    }
    @Test
    public static void authorizationWayIcon(){
        mainMethod.setUp(driverChrome,BASE_URL);
        //Нажимаем на иконку авторизации
        WebElement authorizationIcon = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/a"));
        if(authorizationIcon.isDisplayed()) {
            authorizationIcon.click();
        }
        enterLogPass();
    }
    @Test
    public static void authorizationWayWord(){
        mainMethod.setUp(driverChrome,BASE_URL);
        WebElement authorizationWord = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
        if(authorizationWord.isDisplayed()) {
            authorizationWord.click();
        }
        enterLogPass();
    }
    @Test
    public static void enterLogPass(){
        WebElement loginInput = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label"));
        if(loginInput.isDisplayed()) {
            loginInput.click();
        }
        loginInput.sendKeys("qweufibeze@gmail.com");

        WebElement passwordInput = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label"));
        if(passwordInput.isDisplayed()) {
            passwordInput.click();
        }
        passwordInput.sendKeys("65ufibezedeZ+-");

        WebElement enterButton = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        if(enterButton.isDisplayed()) {
            enterButton.click();
        }
    }
    @Test
    public static void getBackToMainMenu(){
        //Возвращение к MainMenu
        mainMethod.setUp(driverChrome,driverChrome.getCurrentUrl());
        WebElement secondIconButton = driverChrome.findElement(By.xpath("/html/body/div/div/div/div[2]/header/div/div/div[2]/a[1]"));
        if(secondIconButton.isDisplayed()) {
            secondIconButton.click();
        }

        WebDriverWait wait = new WebDriverWait(driverChrome,Duration.ofMillis(500L));
        WebElement exitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div/nav/ul/li[4]/a")));
        exitButton.click();
    }
}
