package com.webstaurantstore.tests;
import com.webstaurantstore.utils.TestDataLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.webstaurantstore.pages.Cart;
import com.webstaurantstore.pages.HomePage;
import com.webstaurantstore.pages.SearchPage;
import com.webstaurantstore.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class SearchAddClearTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchAddClearTest() {
        // Set up test case with test data parameters, page objects, and configs
        String searchString = TestDataLoader.getTestData("TC001", "searchString");
        String validateString = TestDataLoader.getTestData("TC001", "validateString");
        HomePage home = new HomePage(driver);
        SearchPage results = new SearchPage(driver);
        Cart cart = new Cart(driver);
        String baseURL = PropertiesLoader.get("HomePageURL");
        driver.get(baseURL);
        // Step 1. Perform the search
        home.searchString(searchString, driver);
        home.initSearch();
        // Step 2. Assert that all results have the validate string
        Assert.assertTrue(results.checkAllDescriptionsContain(validateString, driver), "All descriptions contain the validation string");
        results.addAllToCart(driver);
        // Step 3. Assert the cart is filled
        Assert.assertFalse(cart.isCartEmpty(driver), "Cart contains items");
        // Step 4. Empty cart and assert emptiness
        cart.emptyCart();
        Assert.assertTrue(cart.isCartEmpty(driver), "Cart is empty");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
