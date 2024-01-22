package com.webstaurantstore.pages;

import com.webstaurantstore.utils.PageUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends PageUtils {
    @FindBy(css = "div[class$='box--empty']")
    public WebElement cartEmptyCard;
    @FindBy(css = "button.emptyCartButton.btn.btn-mini.btn-ui.pull-right")
    public WebElement emptyCartButton;

    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public boolean isCartEmpty(WebDriver driver) {
        try {
           return cartEmptyCard.isDisplayed();
        }
        catch (NoSuchElementException e) {
            System.out.println("Cart contains items or Cart Empty card is not found.");
            return false;
        }
    }
    public void emptyCart() {
        emptyCartButton.click();
    }
}
