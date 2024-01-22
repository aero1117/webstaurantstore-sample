package com.webstaurantstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.webstaurantstore.com/search.html
public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}