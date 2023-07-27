package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Установите путь к драйверу для вашего браузера (ChromeDriver, GeckoDriver и т. д.)
        System.setProperty("webdriver.chrome.driver", "путь_к_драйверу/chromedriver.exe");

        // Создание экземпляра WebDriver для работы с Google Chrome
        WebDriver driver = new ChromeDriver();

        // Открытие страницы в браузере
        driver.get("https://www.example.com"); // Замените на нужный URL

        // Получение заголовка страницы
        String pageTitle = driver.getTitle();

        // Проверка наличия текста в заголовке страницы
        if (pageTitle.contains("Example Domain")) {
            System.out.println("Тест пройден: заголовок страницы содержит 'Example Domain'.");
        } else {
            System.out.println("Тест не пройден: заголовок страницы не содержит 'Example Domain'.");
        }

        // Закрытие браузера и завершение работы WebDriver
        driver.quit();
    }
}