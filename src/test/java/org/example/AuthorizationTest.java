package org.example;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class AuthorizationTest extends UserAuthorizationTest{
    @Category(AuthorizationTests.class)
    @Test
    public void accessAuth() throws InterruptedException {
        String[] urls = runTestAuthorization();
        Thread.sleep(3000);
        System.out.println("Icon Thread URL: " + urls[0]);
        System.out.println("Word Thread URL: " + urls[1]);

        // Проверка значений из массива
        if (urls[0].equals(AUTH_URL) && urls[1].equals(AUTH_URL)) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}
