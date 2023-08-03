package org.example;

import org.testng.annotations.Test;
import org.testng.Assert;

public class UserAuthorizationTestNGTest {

    @Test
    public void testAuthorizationWayIcon() {
        UserAuthorizationTest.authorizationWayIcon();
        // Add assertions here to check the expected behavior of the method
        // For example, check that the user is successfully authorized using the icon
        // You can use Selenium WebDriver methods and assertions to verify the behavior
        // For instance:
        // Assert.assertEquals(driverChromeIcon.getCurrentUrl(), "EXPECTED_URL_AFTER_AUTH");
        // Assert.assertTrue(someElementOnThePage.isDisplayed());
    }

    @Test
    public void testAuthorizationWayWord() {
        UserAuthorizationTest.authorizationWayWord();
        // Add assertions here to check the expected behavior of the method
        // For example, check that the user is successfully authorized using the word
        // You can use Selenium WebDriver methods and assertions to verify the behavior
        // For instance:
        // Assert.assertEquals(driverChromeWord.getCurrentUrl(), "EXPECTED_URL_AFTER_AUTH");
        // Assert.assertTrue(someElementOnThePage.isDisplayed());
    }

}

