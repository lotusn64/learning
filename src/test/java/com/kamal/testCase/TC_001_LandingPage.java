package com.kamal.testCase;

import com.kamal.pageObject.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_LandingPage extends BaseTest  {

    @Test
    public void landingPageTest() throws InterruptedException, IOException {
      BaseTest.lunchApplication();

       // String message = landingPage.successFullMessage();

      //  Assert.assertEquals("Login Successfully", message);
        Thread.sleep(3000);
        AddingToCartPage add = new AddingToCartPage(super.driver);
        add.clickOnRequiredItem("ZARA COAT 3");

        Thread.sleep(3000);


        CartCatalog cartCatalog = new CartCatalog(super.driver);
        Thread.sleep(2000);
        cartCatalog.testItemInCart("ZARA COAT 3");

        CheckOut checkOut = new CheckOut(super.driver);
        Thread.sleep(1000);
        checkOut.clickCheckOut();
        Thread.sleep(1000);
        checkOut.userEmail(randomEmail());
        checkOut.selectAddress("india");



    }


    @Test
    public void registerAccount() throws InterruptedException{
        SignUpPage signUpPage = new SignUpPage(super.driver);
        signUpPage.startSignup();
        Thread.sleep(1000);
        signUpPage.setFirstName("xyz");
        signUpPage.setLastName("abc");
        signUpPage.setEmail(randomEmail());

        signUpPage.setPhoneNumber(randomPhoneNo());
        signUpPage.setOccupationSelection("doctor");
        signUpPage.setGender("male");
        signUpPage.setPassword(randomPassword());

        signUpPage.clickCheckBox();
        signUpPage.clickSignUp();
        Thread.sleep(1000);
        Assert.assertEquals("Account Created Successfully", signUpPage.successfulMessage());


    }
}
