package com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.pages;

import com.danielsmanioto.burgertestes.burgertest.base.BaseSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendaIT extends BaseSelenium {

    private static final String URL = "http://localhost:83/index.html";
    private WebDriver driver = getDriver();

    private static final String X_BURGER = "1";
    private static final String INGREDIENT_BACON = "2";

    @Test
    public void validaPaginaInicial() {
        openPage(URL);
        Assert.assertEquals("Burger", driver.getTitle());
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    @Test
    public void realizarUmPedidoSimplesDeUmHamgerSemAdicionais() {
        openPage(URL);
        selecionarXBurger();
        finalizarClick();
        driver.switchTo().alert().accept();
        sleep(200);
        driver.switchTo().alert().accept();
    }

    @Test
    public void realizarUmPedidoSimplesDeUmHamgerComAdicionais() {
        openPage(URL);
        selecionarXBurger();

        selecionarIngredienteBacon();
        addIngredientsClick();
        sleep(200);
        driver.switchTo().alert().accept();
        sleep(200);

        finalizarClick();
        driver.switchTo().alert().accept();
        sleep(200);
        driver.switchTo().alert().accept();
    }

    private Select getBurgers() {
        return new Select(driver.findElement(By.id("burger")));
    }

    private Select getIngredients() {
        return new Select(driver.findElement(By.id("ingredients")));
    }

    private void selecionarXBurger() {
        getBurgers().selectByValue(X_BURGER);
    }

    private void selecionarIngredienteBacon() {
        getIngredients().selectByValue(INGREDIENT_BACON);
    }

    private void addIngredientsClick() {
        driver.findElement(By.id("add")).click();
    }

    private void finalizarClick() {
        driver.findElement(By.id("finish")).click();
    }

}
