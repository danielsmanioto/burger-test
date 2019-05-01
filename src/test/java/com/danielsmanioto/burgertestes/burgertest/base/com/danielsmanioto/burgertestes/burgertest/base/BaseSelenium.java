package com.danielsmanioto.burgertestes.burgertest.base.com.danielsmanioto.burgertestes.burgertest.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseSelenium {

    private static WebDriver driver = null;

    @BeforeClass
    public static void setup() {
        if(driver == null) {
            driver = getDriver(Browser.Chrome);
        }
        driver.manage().window().maximize();
    }

    @Before
    public void beforeCase() {
    }

    @After
    public void afterCase() {
       //driver.close();
    }

    @AfterClass
    public static void finishCases() {
     //   driver.quit();
    }

    private static WebDriver getDriver(Browser browser) {
        if(Browser.Chrome.equals(browser)) {
            final String pathDriverChrome = System.getProperty("user.dir") + "/drivers/chromedriver";
            System.setProperty("webdriver.chrome.driver", pathDriverChrome);
            driver = new ChromeDriver();
        } else if( Browser.Mozila.equals(browser)) {
            final String pathDriverMozila = System.getProperty("user.dir") + "/drivers/geckodriver";
            System.setProperty("webdriver.gecko.driver", pathDriverMozila);
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {}
    }

    public void openPage(final String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void selecionaSelectById(String id, String valor) {
        new Select(driver.findElement(By.id(id))).selectByValue(valor);
    }

    public void informarValorPorId(String id, String valor) {
        driver.findElement(By.id(id)).sendKeys(valor);
    }

    public void escolherOpcaoSim() {
        driver.switchTo().alert().accept();
    }

    public void clicarEmOK() {
        driver.switchTo().alert().accept();
    }

    public void clicarLink(String linkDescricao) {
        driver.findElement(By.linkText(linkDescricao)).click();
    }


}
