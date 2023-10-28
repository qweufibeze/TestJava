package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class testExample extends UserAuthorizationTest {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        setUp(chromeDriver, BASE_URL);




        tearDown(chromeDriver);
    }
}
