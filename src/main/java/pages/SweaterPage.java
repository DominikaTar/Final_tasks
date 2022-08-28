package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SweaterPage {
    private WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSizeM() {
        WebElement sizeButton = driver.findElement(By.id("group_1"));
        sizeButton.click();
        WebElement sizeM = driver.findElement(By.xpath("//*[text() = 'M']"));
        sizeM.click();
    }

    public void chooseQuantity(int j) {
        WebElement quantityInput = driver.findElement(By.cssSelector("button.bootstrap-touchspin-up"));
        for (int i = 0; i < j - 1; i++) {
            quantityInput.click();
        }
    }

    public void clickAddToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart"));
        addToCartButton.click();
    }

    public void clickCart() {
        driver.navigate().back();
        WebElement cartButton = driver.findElement(By.cssSelector("div.blockcart"));
        cartButton.click();
    }
}

