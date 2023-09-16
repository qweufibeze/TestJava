package org.example;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserAuthorizationTest extends MainMethod{
     final static MainMethod mainMethod = new MainMethod();
     final static WebDriver driverChromeIcon = new ChromeDriver();
     final static WebDriver driverChromeWord = new ChromeDriver();
     final static String BASE_URL = "https://my.tretyakov.ru/app/";
     final static String AUTH_URL = "https://my.tretyakov.ru/app/profile/detail";

    // Проверяем авторизацию по иконке и по слову на сайте "https://my.tretyakov.ru/app/" параллельно друг другу

    public static void main(String[] args) {
        runTestAuthorization();
    }

    public static void runTestAuthorization() {
         Runnable iconAuthorizationTask = UserAuthorizationTest::authorizationWayIcon;
         Runnable wordAuthorizationTask = UserAuthorizationTest::authorizationWayWord;

         // Создаем два потока и запускаем методы в них
         Thread iconThread = new Thread(iconAuthorizationTask);
         iconThread.start();
         Thread wordThread = new Thread(wordAuthorizationTask);
         wordThread.start();
     }
    public static void authorizationWayIcon(){
        mainMethod.setUp(driverChromeIcon,BASE_URL);
        //Нажимаем на иконку авторизации
        WebElement authorizationIcon = driverChromeIcon.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/a"));
        if(authorizationIcon.isDisplayed()) {
            authorizationIcon.click();
        }
        enterLogPass(driverChromeIcon);
    }
    public static void authorizationWayWord(){
        mainMethod.setUp(driverChromeWord,BASE_URL);
        WebElement authorizationWord = driverChromeWord.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
        if(authorizationWord.isDisplayed()) {
            authorizationWord.click();
        }
        enterLogPass(driverChromeWord);
    }
    public static void enterLogPass(WebDriver webDriver){
        WebElement loginInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label"));
        if(loginInput.isDisplayed()) {
            loginInput.click();
        }
        loginInput.sendKeys("alexandrobol@yandex.ru");

        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label"));
        if(passwordInput.isDisplayed()) {
            passwordInput.click();
        }
        passwordInput.sendKeys("12345678910");

        WebElement enterButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        if(enterButton.isDisplayed()) {
            enterButton.click();
        }
    }
    @Test
    public void authorizationTest(){
        runTestAuthorization();
        if(driverChromeIcon.getCurrentUrl().contains(AUTH_URL) && driverChromeWord.getCurrentUrl().contains(AUTH_URL)){
            Assert.assertTrue(true);
            mainMethod.tearDown(driverChromeIcon, AUTH_URL);
            mainMethod.tearDown(driverChromeWord, AUTH_URL);
        }
    }
}