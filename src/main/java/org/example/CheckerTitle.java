package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckerTitle {
    public static void main(String[] args) {
        //System.setProperty("selenium-chrome-driver-4.10.0.jar", "/home/balobanov/selenium-java-4.10.0/selenium-chrome-driver-4.10.0.jar");
        WebDriver driver = new ChromeDriver();
        driver.get("https://my.tretyakov.ru/app/");
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Моя Третьяковка")) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");

        }
        driver.quit();
    }
}