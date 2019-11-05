package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {

    public WebDriver driver;

    public String startURL = "google.com";

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.opera.driver", "C:\\drivers\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\Adrian\\AppData\\Local\\Programs\\Opera\\launcher.exe");
        driver = new OperaDriver(options);
        driver.navigate().to(startURL);
    }

    @Test
    public void firstTest(){
        WebElement elem = driver.findElement(By.name("q"));
        elem.sendKeys("Transition Technologies");
        elem.submit();
    }

    @Test
    public void testTest(){
        String title = driver.getTitle();

        //Print page's title
        System.out.println("Page Title: " + title);

        //Assertion
        Assert.assertEquals(title, "Software Test Academy", "Title assertion is failed!");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
