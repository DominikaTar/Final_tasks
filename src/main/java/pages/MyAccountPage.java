package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddFirstAddres() {
        WebElement addFirstAddresButton = driver.findElement(By.id("address-link"));
        addFirstAddresButton.click();
    }

    public void clickOrderHistory() {
        WebElement orderHistoryButton = driver.findElement(By.id("history-link"));
        orderHistoryButton.click();
    }

}

