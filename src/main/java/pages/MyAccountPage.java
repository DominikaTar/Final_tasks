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


    /*public void firstAddress() {
        WebElement firstAddressButton = driver.findElement(By.id("address-link"));
        if (firstAddressButton.isDisplayed()){
            firstAddressButton.click();
        } else {
            WebElement addressButton = driver.findElement(By.id("addresses-link"));
            addressButton.click();
        }
    }*/

       /* if (firstAddressText == "ADD FIRST ADDRESS") {
            firstAddressButton.click();
        } else {
            addAddress();
        }*/

    /*public boolean addAddress() {
        //WebElement firstAddressButton = driver.findElement(By.xpath("//*[text() = 'Add first address']"));
        //WebElement AddressButton = driver.findElement(By.xpath("//*[text() = 'Addresses']"));
        //WebElement createButton = driver.findElement(By.xpath("//*[text() = 'Create new address']"));
        WebElement addressButton = driver.findElement(By.id("addresses-link"));
        if (addressButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }*/

     /* if (addressText == "ADDRESSES") {
           addressButton.click();
      } else {
           firstAddress();
      }*/
/*    }
    public boolean yyy() {

    }
    public boolean xxx() {

        if (firstAddress()) {
            WebElement firstAddressButton = driver.findElement(By.id("address-link"));
            firstAddressButton.click();
            return true;
        } else {
            WebElement addressButton = driver.findElement(By.id("addresses-link"));
            addressButton.click();
        }
    }*/
}

