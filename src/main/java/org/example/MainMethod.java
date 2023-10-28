package org.example;

import org.openqa.selenium.WebDriver;

class MainMethod {
    public static void setUp(WebDriver driverChrome, String baseURL){
        driverChrome.manage().window().maximize();
        driverChrome.get(baseURL);
    }

    public static void tearDown(WebDriver driverChrome) {
        driverChrome.quit();
    }
}
