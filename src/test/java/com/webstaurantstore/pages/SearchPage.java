package com.webstaurantstore.pages;

import com.webstaurantstore.utils.PageUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends PageUtils {
    @FindBy(xpath = "//*[@id=\"ProductBoxContainer\"]/div[1]/a/span")
    private List<WebElement> itemDescriptions;
    @FindBy(name = "addToCartButton")
    private List<WebElement> itemAddCart;
    @FindBy(xpath = "//div[@class='search__wrap']")
    private WebElement searchWrapper;


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Method to check each and every item description for a specific string
    public boolean checkAllDescriptionsContain(String text, WebDriver driver) {
        waitFor(searchWrapper, driver);
        if (itemDescriptions.isEmpty()) {
            throw new NoSuchElementException("No items loaded on search results page.");
        }
            for (WebElement element : itemDescriptions) {
                if (!element.getText().contains(text)) {
                    return false;
                }
            }
            return true;
    }
    // Method to add the last item on the page to the cart
    public void addLastItemToCart (WebDriver driver) {
        if (!itemAddCart.isEmpty()) {
            itemAddCart.getLast().click();
        }
        else {
            throw new NotFoundException("Unable to locate last item.");
        }
    }

    /*Method to add all items on a page to the cart - Deprecating since I interpreted the step wrong but will leave it here for reference.
    public void addAllToCart(WebDriver driver) {
        for (WebElement element : itemAddCart) {
            element.click();
            waitFor((WebElement) By.xpath("//div[@data-role='notification']"), driver);
        }
    } */


}

