package org.example;

import org.openqa.selenium.WebDriver;

class MainMethod {
    final static String BASE_URL = "https://my.tretyakov.ru/app/";
    final static String AUTH_URL = "https://my.tretyakov.ru/app/profile/detail";
    public static void setUp(WebDriver driverChrome, String baseURL){
        driverChrome.manage().window().maximize();
        driverChrome.get(baseURL);
    }
    public static void tearDown(WebDriver driverChrome) {
        driverChrome.quit();
    }
}
