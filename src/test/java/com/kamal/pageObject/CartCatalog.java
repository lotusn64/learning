package com.kamal.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartCatalog extends BasePage {

    public CartCatalog(WebDriver driver) {
        super(driver);
      
    }
    @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
    WebElement clickOnCart;

    @FindBy(css = ".cartSection h3")
    List<WebElement> itemsInCart;



    public void testItemInCart(String itemToCheckInCart){
        clickOnCart.click();
//        boolean b =  itemsInCart.stream()
//                .anyMatch(x->x.getText().equalsIgnoreCase(itemToCheckInCart));
//        Assert.assertTrue(b);

    }





}
