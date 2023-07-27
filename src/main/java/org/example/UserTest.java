package org.example;

import org.junit.Test;

public class UserTest {
    @Test
    public void main() {
        UserActivityTest userActivityTest = new UserActivityTest();
        userActivityTest.setUp();
        userActivityTest.testLoginAndAddToCart();
    }
}
