package com.kamal.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {


    public LandingPage(WebDriver driver) {
        super(driver);

    }

  //pageFactory
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(id = "toast-container")
    WebElement successFullMessage;



    public void setUserEmail(String email){
        userEmail.sendKeys(email);
    }

    public void setUserPassword(String password){
      userPassword.sendKeys(password);
    }

    public void clickSubmit(){
        submit.click();
        waitForElementToAppear(By.id("toast-container"));
    }

    public String successFullMessage(){
       return successFullMessage.getText();
    }


}
