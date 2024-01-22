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


public class SearchAddClear {
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String baseURL = PropertiesLoader.get("HomePageURL");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void searchAddClearTest() {
        String searchString = TestDataLoader.getTestData("TC001", "searchString");
        HomePage home = new HomePage(driver);
        home.searchString(searchString);
    }
}
