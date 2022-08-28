package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmAddress() {
        WebElement addressContinue = driver.findElement(By.name("confirm-addresses"));
        addressContinue.click();
    }

    public void chooseDelivery() {
        //WebElement pickUpInStore = driver.findElement(By.id("delivery_option_1"));
        //WebElement deliveryNextDay = driver.findElement(By.id("delivery_option_2"));
        WebElement deliveryContinue = driver.findElement(By.name("confirmDeliveryOption"));
        deliveryContinue.click();
    }

    public void paymentMethod() {
        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        payByCheck.click();
        WebElement confirmTerms = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        confirmTerms.click();
    }

    public void clickOrder() {
        WebElement orderButton = driver.findElement(By.cssSelector("button.btn-primary.center-block"));
        orderButton.click();
    }
}
