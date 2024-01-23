package com.webstaurantstore.tests;

import com.webstaurantstore.pages.Cart;
import com.webstaurantstore.pages.HomePage;
import com.webstaurantstore.pages.SearchPage;
import com.webstaurantstore.utils.PageUtils;
import com.webstaurantstore.utils.PropertiesLoader;
import com.webstaurantstore.utils.TestDataLoader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchAddClearTest extends PageUtils {
    WebDriver driver;
    HomePage home;
    SearchPage results;
    Cart cart;
    String baseURL;
    String cartURL;
    @BeforeMethod
    public void setUp() {
        driver = getDriverChrome();
        home = new HomePage(driver);
        results = new SearchPage(driver);
        cart = new Cart(driver);
        baseURL = PropertiesLoader.get("HomePageURL");
        cartURL = PropertiesLoader.get("CartPageURL");
    }

    @Test
    public void searchAddClearTest() throws InterruptedException {
        // Set up test case with test data parameters, page objects, and configs
        String searchString = TestDataLoader.getTestData("TC001", "searchString");
        String validateString = TestDataLoader.getTestData("TC001", "validateString");
        driver.get(baseURL);

        // Step 1. Perform the search
        home.searchString(searchString, driver);
        home.initSearch();
        // Step 2. Assert that all results have the validate string
        Assert.assertTrue(results.checkAllDescriptionsContain(validateString, driver), "All descriptions contain the validation string");
        results.addLastItemToCart(driver);
        driver.get(cartURL);
        // Step 3. Assert the cart is filled
        Assert.assertTrue(!cart.isCartEmpty(), "Cart contains items");
        // Step 4. Empty cart and assert emptiness
        cart.emptyCart(driver);
        Assert.assertTrue(cart.isCartEmpty(), "Cart is empty");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
