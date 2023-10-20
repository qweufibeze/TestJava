package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class ComplexWebPageTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        // Navigate to the login page
        driver.get("https://my.tretyakov.ru/app/login");

        // Enter the username and password
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");

        // Click the login button
        driver.findElement(By.id("login-button")).click();

        // Assert that the user is logged in
        assertTrue(driver.findElement(By.id("user-menu")).isDisplayed());
    }

    @Test
    public void testRegistration() {
        // Navigate to the registration page
        driver.get("https://my.tretyakov.ru/app/register");

        // Enter the user's information
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("password")).sendKeys("password");

        // Click the register button
        driver.findElement(By.id("register-button")).click();

        // Assert that the user is registered
        assertTrue(driver.findElement(By.id("user-menu")).isDisplayed());
    }

    @Test
    public void testBrowseCollection() {
        // Navigate to the collection page
        driver.get("https://my.tretyakov.ru/app/collection");

        // Verify that the collection is displayed
        assertTrue(driver.findElement(By.id("collection-list")).isDisplayed());

        // Filter the collection by artist
        driver.findElement(By.id("artist-filter")).sendKeys("Vasiliy Kandinsky");
        driver.findElement(By.id("filter-button")).click();

        // Verify that the collection is filtered
        assertTrue(driver.findElement(By.id("collection-list")).getText().contains("Wassily Kandinsky"));
    }

    @Test
    public void testAddToFavorites() {
        // Navigate to the collection page
        driver.get("https://my.tretyakov.ru/app/collection");

        // Add a painting to favorites
        driver.findElement(By.id("add-to-favorites-button")).click();

        // Verify that the painting is added to favorites
        assertTrue(driver.findElement(By.id("favorites-list")).getText().contains("Painting name"));
    }

    @Test
    public void testViewFavorites() {
        // Navigate to the favorites page
        driver.get("https://my.tretyakov.ru/app/favorites");

        // Verify that the favorites list is displayed
        assertTrue(driver.findElement(By.id("favorites-list")).isDisplayed());
    }
}


