package com.kamal.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".login-wrapper-footer-text")
    WebElement signup;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userMobile")
    WebElement phoneNumber;

    @FindBy(css = "select[formcontrolname='occupation']")
    WebElement occupationSelection;

    @FindBy(css = "input[value='Male']")
    WebElement genderMale;


    @FindBy(css = "input[value='Female']")
    WebElement genderFemale;

    @FindBy(id="userPassword")
    WebElement password;


    @FindBy(id = "confirmPassword")
    WebElement conformPassword;

    @FindBy(css = "input[type='checkbox']")
    WebElement checkBox;


    @FindBy(id = "login")
    WebElement register;

    @FindBy(css = ".headcolor")

    WebElement successfulMessage;

    public void startSignup(){
        signup.click();
    }



    public void setFirstName(String userFirstName){
        firstName.sendKeys(userFirstName);
    }


    public void setLastName(String userLastName){
        lastName.sendKeys(userLastName);
    }


    public void setEmail(String userEmail){
        email.sendKeys(userEmail);
    }

    public void setPhoneNumber(String userPoneNumber){
        phoneNumber.sendKeys(userPoneNumber);
    }

    public void setOccupationSelection(String userOccupation){
        Select select = new Select(occupationSelection);
        if(userOccupation.equalsIgnoreCase("doctor")){
            select.selectByIndex(1);
        }else if (userOccupation.equalsIgnoreCase("student")){
            select.selectByIndex(2);
        }else if (userOccupation.equalsIgnoreCase("engineer")){
            select.selectByIndex(3);
        }else {
            select.selectByIndex(4);
        }
    }


    public void setGender(String gender){
        if(gender.equalsIgnoreCase("male")){
            genderMale.click();
        }else {
            genderFemale.click();
        }
    }


    public void setPassword(String userPassword){
        password.sendKeys(userPassword);
        conformPassword.sendKeys(userPassword);
    }



    public void clickCheckBox(){
        checkBox.click();
    }

    public void clickSignUp(){
        register.click();
    }

    public String successfulMessage(){
      return   successfulMessage.getText();
    }

}
