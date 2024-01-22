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
import java.util.List;

public class SearchPage {
    @FindBy(xpath = "//*[@id=\"ProductBoxContainer\"]/div[1]/a/span")
    private List<WebElement> ItemDescriptions;
    @FindBy(css = "input.btn.btn-cart.btn-small")
    private List<WebElement> itemAddCart;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to check each and every item description for a specific string
    public boolean checkAllDescriptionsContain(String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search__wrap']")));
        if (ItemDescriptions.isEmpty()) {
            throw new NoSuchElementException("No items loaded on search results page.");
        }
        for (WebElement element : ItemDescriptions) {
            if (!element.getText().contains(text)) {
                return false;
            }

        }
        return true;
    }
    // Method to add all items on a page to the cart
    public void addAllToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (WebElement element : itemAddCart) {
            element.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-role='notification']")));
        }
    }


}

