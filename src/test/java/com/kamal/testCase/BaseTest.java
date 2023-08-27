package com.kamal.testCase;

import com.kamal.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {
    protected static Logger log = LogManager.getLogger();
    public static WebDriver driver;



    public static WebDriver setUp() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//GlobalData.properties"));
        String browserName = prop.getProperty("browser");


        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if(browserName.equals("safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();

        }
        return driver;
    }


    public static void goTo() {
        driver.get("https://rahulshettyacademy.com/client");

    }

    @BeforeClass
    public static void lunchApplication() throws IOException{
        driver = setUp();
        goTo();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.setUserEmail("kneupan800@gmil.com");
        landingPage.setUserPassword("Kamal123@");
        landingPage.clickSubmit();

    }





    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomEmail(){
        return RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@gmail.com";
    }

    public String randomPassword(){
        return RandomStringUtils.randomAlphabetic(6) + "123A@";

    }

    public String randomPhoneNo(){
        return RandomStringUtils.randomNumeric(10);
    }


}
