package org.example;

import org.openqa.selenium.WebDriver;

public class MainMethod {
    public void setUp(WebDriver driverChrome, String baseURL){
        driverChrome.manage().window().maximize();
        driverChrome.get(baseURL);
    }

    public void tearDown(WebDriver driverChrome, String baseURL) {
        driverChrome.quit();
    }
}
