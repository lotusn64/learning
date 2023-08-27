package com.kamal.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOut extends BasePage {
    public CheckOut(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul li button[type='button']")
    WebElement clickCheckOut;

    @FindBy(css = "input[class='input txt text-validated ng-valid ng-dirty ng-touched']")
    WebElement email;


    @FindBy(css = "input[placeholder='Select Country']")
    WebElement address;

    @FindBy(css = ".ta-item.list-group-item.ng-star-inserted")
    List<WebElement> resultCountry;


    @FindBy(css = "a[class='btnn action__submit ng-star-inserted']")
    WebElement submit;

    public void clickCheckOut(){
        clickCheckOut.click();
    }

    public void userEmail(String userEmail){
        Actions actions = new Actions(super.driver);
        actions.sendKeys(email, userEmail);
        System.out.println(userEmail);

    }

    public void selectAddress(String country){
        Actions actions = new Actions(super.driver);
        actions.sendKeys(address,country).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));

//
        for(WebElement element: resultCountry){
            if(element.getText().equalsIgnoreCase(country)){
                element.click();
            }
        }
        submit.click();



    }


}
