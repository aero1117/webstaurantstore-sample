package com.webstaurantstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    @FindBy(css = "div[class$='box--empty']")
    public WebElement cartEmptyCard;
    @FindBy(css = "button.emptyCartButton.btn.btn-mini.btn-ui.pull-right")
    public WebElement emptyCartButton;
    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public boolean isCartEmpty(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.emptyCartButton.btn.btn-mini.btn-ui.pull-right")));
        try {
           return cartEmptyCard.isDisplayed();
        }
        catch (NoSuchElementException e) {return false;}
    }
    public void emptyCart() {
        emptyCartButton.click();
    }
}
