package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckCSSStyle extends UserAuthorization {

    public static void main(String[] args) {
        getStyleCSS();
    }

    public static String getStyleCSS() {
        String params;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement textElement = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]"));
        params = textElement.getCssValue("font-family");
        System.out.println(params);
        Point point = textElement.getLocation();
        System.out.println(point);
        UserAuthorization.tearDown(driver);
        return params;
    }
}
