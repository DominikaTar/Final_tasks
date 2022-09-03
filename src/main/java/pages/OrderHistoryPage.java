package pages;

import org.assertj.core.api.Assertions;
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

        if (priceAmount == 143.60 && statusText == "Awaiting check payment"){
                System.out.println("Order is correct");
        } else {
            Assertions.fail("Order is incorrect");
        }
    }
   /*public void checkOrder2()  {
        OrderConfirmedPage onOrderConfirmedPage = new OrderConfirmedPage(driver);
        String orderReference = onOrderConfirmedPage.orderReference();
        WebElement orderReferenceHistory = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/th"));
        String orderReferenceHistoryText = orderReferenceHistory.getText();
        System.out.println(orderReferenceHistoryText);
        if (orderReferenceHistoryText == orderReference) {
            System.out.println("Order is correct");
        } else {
            Assertions.fail("Order is incorrect");
        }*/

    }
