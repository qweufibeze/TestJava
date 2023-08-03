package org.example;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.example.UserAuthorizationTest.driverChromeIcon;

public class UserAuthorizationTestNGTest {

    @Test()
    public void testAuthorizationWayIcon() {
        UserAuthorizationTest.authorizationWayIcon();
            driverChromeIcon.getCurrentUrl().contains("https://my.tretyakov.ru/app/profile/detail");
            Assert.assertTrue(driverChromeIcon.getCurrentUrl().contains("https://my.tretyakov.ru/app/profile/detail"));
    }

    @Test
    public void testAuthorizationWayWord() {
        UserAuthorizationTest.authorizationWayWord();
        Assert.assertTrue(driverChromeIcon.getCurrentUrl().contains("https://my.tretyakov.ru/app/profile/detail"));
    }
}

