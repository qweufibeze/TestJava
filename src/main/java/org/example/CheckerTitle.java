package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckerTitle extends MainMethod {
    static final WebDriver driverChrome = new ChromeDriver();
    static final String BASE_URL = "https://my.tretyakov.ru/app/";
    public static void main(String[] args) {
        MainMethod mainMethod = new MainMethod();
        mainMethod.setUp(driverChrome,BASE_URL);
        mainMethod.getTitleOfWebsite(driverChrome, "Моя Третьяковка");
        mainMethod.tearDown(driverChrome,BASE_URL);
    }
}