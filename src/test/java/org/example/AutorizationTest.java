package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.example.UserAuthorizationTest.*;

public class AutorizationTest {
    @Test
    public void accessAuth() throws InterruptedException {
        String[] urls = runTestAuthorization();
        Thread.sleep(3000);
        System.out.println("Icon Thread URL: " + urls[0]);
        System.out.println("Word Thread URL: " + urls[1]);

        // Проверка значений из массива
        if (urls[0].equals("https://my.tretyakov.ru/app/profile/detail") && urls[1].equals("https://my.tretyakov.ru/app/profile/detail")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}
