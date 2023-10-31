package org.example;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;
import static org.example.CheckCSSStyle.*;

public class CheckCSSStyleTest  {
    @Category(AuthorizationTests.class)
    @Test
    public void accessGetParamCSS() {
        String param = getStyleCSS();

        if (param.contains("Montserrat, sans-serif")) {
            assertTrue(true);
        }else{
            fail();
        }
    }
}