package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {
    private WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkingOrder() {
        WebElement price = driver.findElement(By.cssSelector("td.text-xs-right"));
        WebElement status = driver.findElement(By.cssSelector("span.label-pill.bright"));
        String priceText = price.getText().substring(1);
        String statusText = status.getText();

        double priceAmount = Double.parseDouble(priceText);

        System.out.println(priceAmount);
        System.out.println(statusText);

        if (priceAmount == 143.60 || statusText == "Awaiting check payment"){
                System.out.println("Order is correct");
        } else {
            System.out.println("Order is incorrect");
        }

    }
}
