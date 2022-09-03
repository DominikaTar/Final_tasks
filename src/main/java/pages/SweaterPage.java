package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class SweaterPage {
    private WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSize(String size) {
        WebElement sizeDropdown = driver.findElement(By.name("group[1]"));
        Select select = new Select(sizeDropdown);
        select.selectByVisibleText(size);
    }

    public void chooseQuantity(int j) throws InterruptedException {
        WebElement quantityInput = driver.findElement(By.cssSelector("button.bootstrap-touchspin-up"));
        for (int i = 0; i < j; i++) {
            quantityInput.click();
            Thread.sleep(1000);
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

