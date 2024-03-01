package org.example;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserAuthorization extends MainMethod {

    static WebDriver driverChromeIcon = new ChromeDriver();
    static WebDriver driverChromeWord = new ChromeDriver();

    @Test
    public void authorizationWayIcon() {
        setUp(driverChromeIcon, BASE_URL);
        WebElement authorizationIcon = driverChromeIcon.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/a"));
        if (authorizationIcon.isDisplayed()) {
            authorizationIcon.click();
        }
        enterLogPass(driverChromeIcon);
        WebDriverWait waitIcon = new WebDriverWait(driverChromeIcon, Duration.ofSeconds(15));
        waitIcon.until(ExpectedConditions.urlToBe(AUTH_URL));
        assert driverChromeIcon.getCurrentUrl().equals(AUTH_URL);
    }
    @Test
    public void authorizationWayWord() {
        setUp(driverChromeWord, BASE_URL);
        WebElement authorizationWord = driverChromeWord.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div/div[2]/div[1]"));
        if (authorizationWord.isDisplayed()) {
            authorizationWord.click();
        }
        enterLogPass(driverChromeWord);
        WebDriverWait waitWord = new WebDriverWait(driverChromeWord, Duration.ofSeconds(15));
        waitWord.until(ExpectedConditions.urlToBe(AUTH_URL));
        assert driverChromeWord.getCurrentUrl().equals(AUTH_URL);
    }
    public static void enterLogPass(WebDriver webDriver) {
        WebElement loginInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/label/input"));
        if (loginInput.isDisplayed()) {
            loginInput.click();
        }
        loginInput.sendKeys("alexandrobol@yandex.ru");

        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/label/input"));
        if (passwordInput.isDisplayed()) {
            passwordInput.click();
        }
        passwordInput.sendKeys("12345678910");

        WebElement enterButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div[2]/form/button"));
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
    }
}
