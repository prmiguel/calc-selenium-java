package io.prmiangel.calc.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AdditionTest {

    public WebDriver wd;

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() {
        wd.quit();
    }

    @Test
    public void addition() {
        wd.get("http://192.168.99.100:32768/");
        wd.findElement(By.id("one")).click();
        wd.findElement(By.id("add")).click();
        wd.findElement(By.id("two")).click();
        wd.findElement(By.id("equals")).click();
        Assert.assertEquals(wd.findElement(By.id("display")).getText(), "3");
    }
}
