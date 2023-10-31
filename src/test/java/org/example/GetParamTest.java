package org.example;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.example.GetAttributeParams.getParamsOfView;
import static org.junit.Assert.*;
import static org.example.CheckCSSStyle.*;

public class GetParamTest  {
    @Category(AuthorizationTests.class)
    @Test
    public void accessGetParam() {
        String param = getParamsOfView();

        if (param.contains("ОБЩАЯ СУММА ПОЖЕРТВОВАНИЙ В ПРОЕКТЕ")) {
            assertTrue(true);
        }else{
            fail();
        }
    }
}
