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

    void getTitleOfWebsite(WebDriver driverChrome, String findWord){
        String pageTitle = driverChrome.getTitle();
        if (pageTitle.contains(findWord)) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }
}
