package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class UserAuthorizationTest extends MainMethod{
     final static MainMethod mainMethod = new MainMethod();
     final static WebDriver driverChromeIcon = new ChromeDriver();
     final static WebDriver driverChromeWord = new ChromeDriver();
     final static String BASE_URL = "https://my.tretyakov.ru/app/";
     final static String AUTH_URL = "https://my.tretyakov.ru/api/auth/";

    // Проверяем авторизацию по иконке и по слову на сайте "https://my.tretyakov.ru/app/" параллельно друг другу

    public static void main(String[] args) {
        runTestAuthorization();
    }

//        "status": false,
//            "error": {
//        "code": "FILL_REQUIRED_FIELDS",
//                "message": "Заполните обязательные поля."
//    }
//    @Test
//    public void testSuccessfulAuthorization() {
//        RestAssured.baseURI = "https://my.tretyakov.ru";
//
//        String email = "qweufibeze@gmail.com";
//        String password = "65ufibezedeZ+-";
//
//        String requestBody = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
//
//        given()
//                .contentType(ContentType.JSON)
//                .header(":authority", "https://my.tretyakov.ru")
//                .header(":method", "POST")
//                .header(":path", "/api/auth/")
//                .header(":scheme", "https")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Accept-Encoding", "gzip, deflate, br")
//                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .body(requestBody)
//                .when()
//                .post("https://my.tretyakov.ru/api/auth/")
//                .then().log().all()
//                .statusCode(200)
//                .body("status", equalTo("success"));
//    }
    public static void runTestAuthorization() {
         Runnable iconAuthorizationTask = () -> authorizationWayIcon();
         Runnable wordAuthorizationTask = () -> authorizationWayWord();

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

        mainMethod.setUp(driverChromeIcon,BASE_URL);
        WebElement secondIconButton = driverChromeIcon.findElement(By.xpath("/html/body/div/div/div/div[2]/header/div/div/div[2]/a[1]"));
        if(secondIconButton.isDisplayed()) {
            secondIconButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driverChromeIcon,Duration.ofMillis(3000L));
        WebElement exitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div/nav/ul/li[4]/a")));
        exitButton.click();
        mainMethod.tearDown(driverChromeIcon, driverChromeIcon.getCurrentUrl());
    }
    public static void authorizationWayWord(){
        mainMethod.setUp(driverChromeWord,BASE_URL);
        WebElement authorizationWord = driverChromeWord.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
        if(authorizationWord.isDisplayed()) {
            authorizationWord.click();
        }
        enterLogPass(driverChromeWord);

        mainMethod.setUp(driverChromeWord,BASE_URL);
        WebElement secondIconButton = driverChromeWord.findElement(By.xpath("/html/body/div/div/div/div[2]/header/div/div/div[2]/a[1]"));
        if(secondIconButton.isDisplayed()) {
            secondIconButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driverChromeWord,Duration.ofMillis(3000L));
        WebElement exitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div/nav/ul/li[4]/a")));
        exitButton.click();
        mainMethod.tearDown(driverChromeWord, driverChromeWord.getCurrentUrl());
    }
    public static void enterLogPass(WebDriver webDriver){
        WebElement loginInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label"));
        if(loginInput.isDisplayed()) {
            loginInput.click();
        }
        loginInput.sendKeys("qweufibeze@gmail.com");

        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label"));
        if(passwordInput.isDisplayed()) {
            passwordInput.click();
        }
        passwordInput.sendKeys("65ufibezedeZ+-");

        WebElement enterButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        if(enterButton.isDisplayed()) {
            enterButton.click();
        }
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofMillis(3000L));
        WebElement errorLogPass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/span")));
        if (errorLogPass.isDisplayed()) {
            System.out.println("test not ok");
        } else {
            System.out.println("test ok");
        }
    }
}