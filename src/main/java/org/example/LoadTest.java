package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadTest {

    public static void main(String[] args) {
        //System.setProperty("selenium-chrome-driver-4.10.0.jar", "/home/balobanov/selenium-java-4.10.0/selenium-chrome-driver-4.10.0.jar");
        // Запустить несколько потоков с тестами
        int threads = 5;
        for (int i = 1; i <= threads; i++) {
            Thread thread = new Thread(() -> runTest());
            thread.start();
        }
    }

    public static void runTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://protei.ru/");
            WebElement button = driver.findElement(By.id());
            String buttonProtei = button
            driver.
        } finally {
            driver.quit();
        }
    }
}