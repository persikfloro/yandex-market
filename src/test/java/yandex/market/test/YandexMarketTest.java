package yandex.market.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import yandex.market.pages.ComparisonPage;
import yandex.market.pages.MarketPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class YandexMarketTest {
    static WebDriver driver;
    private static MarketPage marketPage;
    private static ComparisonPage comparisonPage;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        marketPage = new MarketPage(driver);
        comparisonPage = new ComparisonPage(driver);
        driver.get("https://market.yandex.ru");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testYandexMarketComparison() {
        marketPage.preConditions("50", "150");
        marketPage.setMaker("Whiskas");
        marketPage.firstItem();
        driver.navigate().back();
        marketPage.cleanMaker();
        marketPage.setMaker("Мнямс");
        marketPage.secondItem();
        // Test 1: The product names in the comparison match the names of the added products
        assertEquals(comparisonPage.firstItem(), marketPage.firstItem());
        assertEquals(comparisonPage.secondItem(), marketPage.secondItem());
        // Test 2: The amount of the cost does not exceed three hundred rubles
        int totalPrice = comparisonPage.getSumPrices();
        assertTrue(totalPrice <= 300);
        // Test 3: Product Whiskas is not displayed after deletion
        comparisonPage.removeWhiskas();
        assertFalse(driver.getPageSource().contains("Whiskas"));
        // Test 4: Products not showing after deletion
        comparisonPage.deleteCompareList();
        WebElement emptyCompare = driver.findElement(By.linkText("Сравнивать пока нечего"));
        comparisonPage.emptyCompareList();
        assertTrue(emptyCompare.isDisplayed());
    }

}