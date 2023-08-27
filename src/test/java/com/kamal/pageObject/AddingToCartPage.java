package com.kamal.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class AddingToCartPage extends BasePage{
    public AddingToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> itemList;

    public void clickOnRequiredItem(String itemName){
      Objects.requireNonNull(itemList.stream()
                      .filter(x -> x.findElement(By.cssSelector("b")).getText()
                      .equalsIgnoreCase(itemName)).findFirst()
                      .orElse(null)).
                      findElement(By.cssSelector(".card-body button:last-of-type")).click();
//      waitForElementToAppear(By.cssSelector("#toast-container"));
//      waitForElementToAppear(By.cssSelector(".ng-animating"));
    }



}
