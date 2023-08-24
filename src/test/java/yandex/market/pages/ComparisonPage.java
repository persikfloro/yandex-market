package yandex.market.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparisonPage {
    private WebDriver driver;

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    public String firstItem() {
        WebElement firstItem = driver.findElement(By.cssSelector("a._2f75n.PzFNv.cia-cs"));
        String name1 = firstItem.getText();
        return name1;
    }

    public String secondItem() {
        WebElement secondItem = driver.findElements(By.cssSelector("a._2f75n.PzFNv.cia-cs")).get(1);
        String name2 = secondItem.getText();
        return name2;
    }

    public int firstPrice() {
        WebElement firstPrice = driver.findElement(By.cssSelector("span[data-auto='mainPrice']"));
        String price = firstPrice.getText();
        int price1 = Integer.parseInt(price);
        return price1;
    }

    public int secondPrice() {
        WebElement secondPrice = driver.findElements(By.cssSelector("span[data-auto='mainPrice']")).get(1);
        String price = secondPrice.getText();
        int price2 = Integer.parseInt(price);
        return price2;
    }

    public int getSumPrices() {
        int sum = firstPrice() + secondPrice();
        return sum;
    }

    public void removeWhiskas() {
        String whiskas = secondItem();
        WebElement remove = driver.findElement(By.cssSelector("_2et7a _24eXc _3_z1Z"));
        if (whiskas.contains("Whiskas")) {
            remove.click();
        }
    }

    public void deleteCompareList() {
        WebElement deleteList = driver.findElement(By.cssSelector("class=_1KpjX _1KU3s"));
        deleteList.click();
    }

    public void emptyCompareList() {
        WebElement emptyCompare = driver.findElement(By.cssSelector("class=kpCeE"));
        emptyCompare.isDisplayed();
    }


}
