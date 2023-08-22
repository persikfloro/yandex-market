package yandex.market.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class YandexMarketTest {
    private WebDriver driver;
    private MarketPage marketPage;
    private ComparisonPage comparisonPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru");
        marketPage = new MarketPage(driver);
        comparisonPage = new ComparisonPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testYandexMarketComparisonWithPageObject() {
        marketPage.goToCatalog();
        marketPage.navigateToCatTreats();

        // Добавление первого товара в сравнение
        // ...

        // Добавление второго товара в сравнение
        // ...

        // Переход на страницу сравнения
        // ...

        String comparedProductName1 = comparisonPage.getComparedProductName(0);
        String comparedProductName2 = comparisonPage.getComparedProductName(1);

        // Проверки, ассерты и другие действия
        // ...
    }


}