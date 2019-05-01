package com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.externall;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.base.BaseSelenium;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GooglePageIT extends BaseSelenium {

    private static final String PAGE = "http://www.google.com";
    private WebDriver driver = getDriver();

    @Test
    public void pesquisarMeuNomeNOGoogle() {
        openPage(PAGE);

        driver.findElement(By.name("q")).sendKeys("DANIEL AUGUSTO SMANIOTO");
        driver.findElement(By.name("q")).submit();
    }

}
