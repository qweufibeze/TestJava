package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class testExample extends MainMethod {
    final static String BASE_URL = "https://my.tretyakov.ru/app/";
    public static void main(String[] args) {
        MainMethod mainMethod = new MainMethod();
        WebDriver chromeDriver = new ChromeDriver();
        setUp(chromeDriver, BASE_URL);


        setUp(chromeDriver, BASE_URL);
        tearDown(chromeDriver);
    }
}
