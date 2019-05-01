package com.danielsmanioto.burgertestes.burgertest.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSelenium {

    private static WebDriver driver = null;
    private static final String PAGE_INITIAL = "http://localhost:83/index.html";

    @BeforeClass
    public static void setup() {
        if(driver == null) {
            driver = getDriver(Browser.Chrome);
        }
    }

    @AfterClass
    public static void finishCases() {
        //driver.close();
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

    public void openInitialPage() {
        driver.get(PAGE_INITIAL);
    }

}
