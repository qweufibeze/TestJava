package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class ComplexWebPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://example.com");
            WebElement loginLink = driver.findElement(By.linkText("Войти"));
            loginLink.click();

            WebElement usernameInput = driver.findElement(By.id("username"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            usernameInput.sendKeys("your_username");
            passwordInput.sendKeys("your_password");
            loginButton.click();

            /
            WebElement shopLink = driver.findElement(By.linkText("Магазин"));
            shopLink.click();

            String category = "Электроника";
            String keyword = "телефон";

            WebElement categoryDropdown = driver.findElement(By.id("category-dropdown"));
            categoryDropdown.sendKeys(category);

            WebElement searchInput = driver.findElement(By.id("search-input"));
            searchInput.sendKeys(keyword);

            WebElement searchButton = driver.findElement(By.id("search-button"));
            searchButton.click();


            WebElement product = driver.findElement(By.xpath("//div[contains(text(), 'телефон')]"));
            WebElement addToCartButton = product.findElement(By.xpath(".//button[contains(text(), 'Добавить в корзину')]"));
            addToCartButton.click();


            WebElement cartLink = driver.findElement(By.id("cart-link"));
            cartLink.click();

            WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart-item'][1]"));
            assertTrue(cartItem.isDisplayed());


            WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(), 'Оформить заказ')]"));
            checkoutButton.click();


            WebElement orderConfirmationMessage = driver.findElement(By.className("order-confirmation-message"));
            assertTrue(orderConfirmationMessage.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

