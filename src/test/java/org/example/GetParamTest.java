package org.example;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class GetParamTest extends TestExample {
    @Category(AuthorizationTests.class)
    @Test
    public  void accessGetParam() {
        String param = getParamsOfView();
        if (param != null && param.contains("ОБЩАЯ СУММА ПОЖЕРТВОВАНИЙ В ПРОЕКТЕ")){
            assertTrue(true);
        }else{
            fail();
        }
    }
}
