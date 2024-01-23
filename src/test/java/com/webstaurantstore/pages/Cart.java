package com.webstaurantstore.pages;

import com.webstaurantstore.utils.PageUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends PageUtils {
    @FindBy(xpath = "//div[@class='empty-cart__text']")
    public WebElement cartEmptyCard;
    @FindBy(xpath = "//button[contains(@class, 'emptyCartButton')]")
    public WebElement emptyCartButton;
    @FindBy(xpath = "//button[contains(@class, 'mr-2')]")
    public WebElement confirmEmptyCart;

    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public boolean isCartEmpty() throws InterruptedException {
        Thread.sleep(5000); // Sleeping here because we shouldn't know whether the cart container will load for any given test
        try {
            return cartEmptyCard.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    public void emptyCart(WebDriver driver) {
        emptyCartButton.click();
        waitFor(confirmEmptyCart, driver);
        confirmEmptyCart.click();
        waitFor(cartEmptyCard, driver);
    }
}
