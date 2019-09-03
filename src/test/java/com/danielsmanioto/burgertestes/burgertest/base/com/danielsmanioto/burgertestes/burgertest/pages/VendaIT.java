package com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.pages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.base.BaseSelenium;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendaIT extends BaseSelenium {

    private static final String URL = "http://localhost:83/index.html";
    private WebDriver driver = getDriver();

    private static final String X_BURGER = "1";

    private static final String INGREDIENT_ALFACE = "1";
    private static final String INGREDIENT_BACON = "2";
    private static final String INGREDIENT_OVO = "5";

    @Test
    public void validaPaginaVenda() {
        openPage(URL);

        Assert.assertEquals("Burger", driver.getTitle());
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    @Test
    public void adicionarIngredientesSemFinalizarPedido() {
        openPage(URL);

        escolherIngrediente(INGREDIENT_BACON);
        clicarAdicionarIngredientes();
        sleep(200);
        clicarEmOK();
        sleep(200);

        escolherIngrediente(INGREDIENT_ALFACE);
        informarQuantidadeIngredientes("2");
        clicarAdicionarIngredientes();
        sleep(200);
        clicarEmOK();
        sleep(200);

        escolherIngrediente(INGREDIENT_OVO);
        clicarAdicionarIngredientes();
        sleep(200);
        clicarEmOK();
        sleep(200);
    }

    @Test
    public void realizarUmPedidoSimplesDeUmHamgerSemAdicionais() {
        openPage(URL);

        escolherLanche(X_BURGER);

        clicarFinalizarPedido();
        escolherOpcaoSim();
        sleep(200);
        clicarEmOK();
    }

    @Test
    public void realizarUmPedidoSimplesDeUmHamburgerComAdicionais() {
        openPage(URL);

        escolherLanche(X_BURGER);

        escolherIngrediente(INGREDIENT_BACON);
        clicarAdicionarIngredientes();
        sleep(200);
        clicarEmOK();

        clicarFinalizarPedido();
        escolherOpcaoSim();
        sleep(200);
        clicarEmOK();
    }

    @Test
    public void irParaPaginaPedidosEVoltarParaPaginaDeVenda() {
        openPage(URL);

        clicarLink("Pedidos");
        clicarLink("Venda");
    }

    private void escolherLanche(String valor) {
        selecionaSelectById("burger", valor);
    }

    private void escolherIngrediente(String valor) {
        selecionaSelectById("ingredients", valor);
    }

    private void informarQuantidadeIngredientes(String quantidade) {
        driver.findElement(By.id("ingredientsQtty")).getAttribute("value").split(quantidade);
    }

    private void clicarAdicionarIngredientes() {
        driver.findElement(By.id("add")).click();
    }

    private void clicarFinalizarPedido() {
        driver.findElement(By.id("finish")).click();
    }

}
