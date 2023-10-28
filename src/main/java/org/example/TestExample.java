package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestExample extends UserAuthorizationTest {
    public void run() {
        WebDriver chromeDriver = new ChromeDriver();
        authorizationWayIcon(chromeDriver);
//        WebElement textElement = chromeDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]"));
//        String par = textElement.getAttribute("textContent");
//        System.out.println(par);
//        tearDown(chromeDriver);
    }


}
