package yandex.market.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketPage {
    private WebDriver driver;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCatalog() {
        open("https://market.yandex.ru/");
        WebElement catalogButton = driver.findElement(By.partialLinkText("Каталог"));
        catalogButton.click();
    }

    public void findZooItems() {
        WebElement zooItems = driver.findElement(By.linkText("Зоотовары"));
        WebElement catFood = driver.findElement(By.linkText("Лакомства"));
        Actions actions = new Actions(driver);
        actions.moveToElement(zooItems).perform();
        catFood.click();
    }

    public void setPriceAndDelivery() {
        WebElement setPrice = driver.findElement(By.name("Цена, ₽"));
        WebElement chooseDelivery = driver.findElement(By.name("Способ доставки"));
    }

    public void setMaker() {
        WebElement maker = driver.findElement(By.name("Бренд"));
        WebElement showAll = driver.findElement(By.linkText("Показать всё"));
        Actions actions = new Actions(driver);
        actions.moveToElement(showAll).click();
        WebElement findMaker = driver.findElement(By.cssSelector("[id = labeltextfield8304000101] input"));
    }

    public void chooseItem() {
        WebElement chooseItem = driver.findElement(By.cssSelector("[data-autotest-id = product-snippet]"))
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseItem).click();
    }

}
    public void checkBox() {
        WebElement chooseMaker = driver.findElement(By.cssSelector("[type = checkbox] click"))
        chooseMaker.click();
    }
}
