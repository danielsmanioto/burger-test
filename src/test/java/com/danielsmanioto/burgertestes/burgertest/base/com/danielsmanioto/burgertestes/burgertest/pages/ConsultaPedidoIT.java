package com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.pages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.base.BaseSelenium;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultaPedidoIT extends BaseSelenium {

    private static final String URL = "http://localhost:83/requests.html";
    private WebDriver driver = getDriver();

    @Test
    public void validaPaginaInicial() {
        openPage(URL);

        Assert.assertEquals("Burger", driver.getTitle());
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

}
