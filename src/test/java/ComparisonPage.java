package yandex.market.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparisonPage {
    private WebDriver driver;
    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCompare() {
        WebElement compare = driver.findElement(By.linkText("Сравнить"));
        Actions actions = new Actions(driver);
        actions.moveToElement(compare).click();
    }

    public int getTotalPrice() {
        WebElement totalPriceElement = driver.findElement(By.cssSelector(".n-compare-summary__value span"));
        String totalPriceText = totalPriceElement.getText();
        return Integer.parseInt(totalPriceText.replaceAll("[^\\d]", ""));
    }

    public void removeProductByProducer(String producer) {
        WebElement removeButton = driver.findElement(By.xpath("//span[text()='" + producer + "']/following-sibling::span[@class='n-compare-row-name-remove']"));
        removeButton.click();
    }

    // Другие методы для взаимодействия с элементами страницы Comparison
}
