package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void index(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

    }
    @Test
    public void idveyaName(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

    }
    @Test

    public void webelement(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

    }
    @Test
    public void iframeCikis(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();
    }

}
