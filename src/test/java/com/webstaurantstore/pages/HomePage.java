package com.webstaurantstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    // Locators
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div/div/form/div/div/div/input")
    public WebElement searchBox;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
// Method to wait for search box to load, then enter the search string
    public void searchString(String searchString, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div/div/form")));
        //searchBox.click();
        searchBox.sendKeys(searchString);
    }
    // Method to initialize the search
    public void initSearch() {
        searchBox.sendKeys(Keys.ENTER);
    }
}