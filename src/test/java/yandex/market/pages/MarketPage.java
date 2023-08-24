package yandex.market.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MarketPage {
    private WebDriver driver;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preConditions(String min, String max) {
        Actions actions = new Actions(driver);
        driver.get("https://market.yandex.ru");
        WebElement catalogButton = driver.findElement(By.cssSelector("V9Xu6 _1KI8u Lfy7z _3iB1w _35Vhw"));
        WebElement catalog = driver.findElement(By.xpath("//data-zone-name=catalog-content"));
        WebElement zoo = driver.findElement(By.linkText("Зоотовары"));
        WebElement catFood = driver.findElements(By.cssSelector("[egKyN _1mqvV _1wg9X]")).get(3);
        WebElement minPrice = driver.findElement(By.id("[range-filter-field-glprice_tkzkek8xmw_min] input"));
        WebElement maxPrice = driver.findElement(By.id("[range-filter-field-glprice_tkzkek8xmw_max] input"));
        WebElement delivery = driver.findElement(By.xpath("//data-filter-value-id=offer-shipping_delivery"));
        actions.moveToElement(catalogButton).perform();
        catalog.isDisplayed();
        actions.moveToElement(zoo).click(catFood);
        minPrice.sendKeys(min);
        maxPrice.sendKeys(max);
        delivery.click();
    }

    public void setMaker(String name) {
        WebElement showAll = driver.findElement(By.xpath("//data-zone-name=LoadFilterValues"));
        WebElement search = driver.findElement(By.xpath("//data-zone-name=filterSearchValueField"));
        WebElement result = driver.findElement(By.xpath("//data-zone-name=FilterValue"));
        Select select = new Select(result);
        showAll.click();
        search.sendKeys(name);
        select.getFirstSelectedOption();
    }

    public void cleanMaker() {
        WebElement maker = driver.findElement(By.className("[_3-pGT]"));
        maker.click();
    }

    public void addToCompare() {
        WebElement add = driver.findElement(By.linkText("Сравнить"));
        add.click();
    }

    public String firstItem() {
        WebElement item = driver.findElement(By.xpath("//data-autotest-id=product-snippet"));
        item.click();
        driver.switchTo().newWindow(WindowType.TAB);
        addToCompare();
        String name1 = item.getText();
        return name1;
    }

    public String secondItem() {
        WebElement item = driver.findElement(By.xpath("//data-autotest-id=product-snippet"));
        WebElement compareButton = driver.findElement(By.linkText("Сравнить"));
        item.click();
        driver.switchTo().newWindow(WindowType.TAB);
        addToCompare();
        compareButton.click();
        String name2 = item.getText();
        return name2;
    }
}
