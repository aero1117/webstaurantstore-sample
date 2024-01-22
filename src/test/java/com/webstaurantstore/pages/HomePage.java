package com.webstaurantstore.pages;

import com.webstaurantstore.utils.PageUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageUtils {
    // Locators
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div/div/form/div/div/div/input")
    public WebElement searchBox;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Method to wait for search box to load, then enter the search string
    public void searchString(String searchString, WebDriver driver) {
        waitFor(searchBox, driver);
        try {
            searchBox.sendKeys(searchString);
        }
        catch (Exception e) {
            System.out.println("Unable to locate search field.");
        }
    }
    // Method to initialize the search
    public void initSearch() {
        try {
            searchBox.sendKeys(Keys.ENTER);
        }
        catch (Exception e) {
            System.out.println("Exception occurred while searching String: " + e.getMessage());
        }
    }
}