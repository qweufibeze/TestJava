package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestExample extends UserAuthorizationTest {
    public static void main(String[] args) {
        getParamsOfView();
    }

    public static String getParamsOfView(){
        String params;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        authorizationWayIcon(driver);
        WebElement textElement = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]"));
        params = textElement.getAttribute("innerText");
        System.out.println(params);
        UserAuthorizationTest.tearDown(driver);
        return params;
    }
}
