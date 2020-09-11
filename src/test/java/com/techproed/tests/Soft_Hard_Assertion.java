package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Soft_Hard_Assertion {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test01(){
        driver.get("http://amazon.com");
        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();

        //softAssert.assertEquals("DVDs", title);
        softAssert.assertTrue(driver.getTitle().contains("Amazon"));

        softAssert.assertAll();


    }
    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertTrue(emailBox.getText().equals("testtechproed@gmail.com"));

        WebElement paasBox = driver.findElement(By.id("session_password"));
        paasBox.sendKeys("Test1234!");

        WebElement signOutButton = driver.findElement(By.xpath("//*[.='Sign out']"));
        boolean gorunuyorMu = signOutButton.isDisplayed();
        softAssert.assertAll();
        //boolean gorunuyorMu = signOutButton.isDisplayed();
        //Assert.assertTrue(gorunuyorMu);










    }
}
