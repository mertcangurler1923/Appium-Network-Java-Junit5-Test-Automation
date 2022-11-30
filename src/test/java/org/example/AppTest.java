package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class AppTest extends BaseTest {
    @Test
    @Order(0)
    public void deneme() throws FileNotFoundException {
        App app=new App(driver);
        List<String>data=app.test();
        String boxDiscountMoneyValue=data.get(4).replace(".","").replace(",",".");
        String boxNotDiscountMoneyValue=data.get(6).replace(".","").replace(",",".");
        Assertions.assertEquals("true",data.get(0));
        Assertions.assertEquals(data.get(1),data.get(2));
        Assertions.assertEquals(data.get(3),boxDiscountMoneyValue);
        Assertions.assertEquals(data.get(5),boxNotDiscountMoneyValue);
    }

}
