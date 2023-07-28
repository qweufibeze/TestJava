package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserAuthorizationTest extends MainMethod{
    static final WebDriver driverChrome = new ChromeDriver();
    static final String BASE_URL = "https://my.tretyakov.ru/app/";

    public static void main(String[] args) {
        authorizationWayIcon();
    }


    public static void authorizationWayIcon(){
        MainMethod mainMethod = new MainMethod();
        mainMethod.setUp(driverChrome,BASE_URL);

        //Нажимаем на иконку авторизации
        WebElement authorizationIcon = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/a"));
        authorizationIcon.click();

        //Вводим логин и пароль
        WebElement loginInput = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label"));
        loginInput.click();
        loginInput.sendKeys("qweufibeze@gmail.com");
        WebElement passwordInput = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label"));
        passwordInput.click();
        passwordInput.sendKeys("65ufibezedeZ+-");

        //Нажимаем на кнопку "ВОЙТИ"
        WebElement enterButton = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        enterButton.click();

//
//        //Логинимся с помощью кнопки "Войти"
//        mainMethod.setUp(driverChrome,BASE_URL);
//        WebElement authorizationWord = driverChrome.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
//        authorizationWord.click();
//
//        //Вводим логин и пароль
//        loginInput.click();
//        loginInput.sendKeys("qweufibeze@gmail.com");
//        passwordInput.click();
//        passwordInput.sendKeys("65ufibezedeZ+-");
//
//        //Нажимаем на кнопку "ВОЙТИ"
//        enterButton.click();
//        mainMethod.tearDown(driverChrome,BASE_URL);
    }
}

