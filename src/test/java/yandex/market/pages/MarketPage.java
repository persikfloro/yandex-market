package yandex.market.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

public class MarketPage {
        private WebDriver driver;
    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preConditions(String min, String max) {
        driver.get("https://market.yandex.ru");
        WebElement catalogButton = driver.findElement(By.cssSelector("[data-zone-name=catalog]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogButton).perform();
        WebElement zooItems = driver.findElement(By.linkText("Зоотовары"));
        WebElement catFood = driver.findElement(By.linkText("Лакомства"));
        actions.moveToElement(zooItems).perform();
        catFood.click();
        WebElement minPrice = driver.findElement(By.id("[range-filter-field-glprice_tkzkek8xmw_min] input"));
        WebElement maxPrice = driver.findElement(By.id("[range-filter-field-glprice_tkzkek8xmw_max] input"));
        WebElement delivery = driver.findElement(By.xpath("//data-filter-value-id=offer-shipping_delivery"));
        minPrice.sendKeys(min);
        maxPrice.sendKeys(max);
        delivery.click();
    }

    public void setMaker(String name) {
        WebElement showAll = driver.findElement(By.className("[_1KpjX _2T2ab]"));
        showAll.click();
        WebElement allMakers = driver.findElement(By.className("[_3qxDp] input"));
        allMakers.sendKeys(name);
        WebElement maker = driver.findElement(By.className("[_3-pGT]"));
        maker.click();
    }

    public void cleanMaker() {
        WebElement maker = driver.findElement(By.className("[_3-pGT]"));
        maker.click();
    }

    public void addToCompare(){
        WebElement add = driver.findElement(By.linkText("Сравнить"));
        add.click();
    }

    public String firstItem() {
        WebElement item = driver.findElement(By.cssSelector("[data-autotest-id = product-snippet]"));
        item.click();
        driver.switchTo().newWindow(WindowType.TAB);
        addToCompare();
        String name1 = item.getText();
        return name1;
    }

    public String secondItem() {
        WebElement item = driver.findElement(By.cssSelector("[data-autotest-id = product-snippet]"));
        WebElement compareButton = driver.findElement(By.linkText("Сравнить"));
        item.click();
        driver.switchTo().newWindow(WindowType.TAB);
        addToCompare();
        compareButton.click();
        String name2 = item.getText();
        return name2;
    }
}
