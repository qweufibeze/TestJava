package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestGetAttributeParams extends TestUserAuthorization {
    public static void main(String[] args) {
        getParamsOfView();
    }
    public static void getParamsOfView(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement textElement = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]"));
        String params = textElement.getAttribute("innerText");
        System.out.println(params);
        TestUserAuthorization.tearDown(driver);
    }
}
