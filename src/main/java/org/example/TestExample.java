package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestExample {
    public static void main(String[] args) {
        UserAuthorizationTest.authorizationWayIcon(UserAuthorizationTest.driverChromeIcon);
//        WebElement textElement = UserAuthorizationTest.driverChromeIcon.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]"));
//        String par = textElement.getAttribute("textContent");
//        System.out.println(par);
    }
}
