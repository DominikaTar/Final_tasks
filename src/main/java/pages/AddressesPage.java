package pages;

import net.jodah.failsafe.internal.util.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressesPage {
    private WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstAddressForm() throws InterruptedException {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement zipCodeInput = driver.findElement(By.name("postcode"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement chooseCountry = driver.findElement(By.name("id_country"));
        WebElement chosenCountry = driver.findElement(By.xpath("//*[text() = 'United Kingdom']"));
        WebElement saveButton = driver.findElement(By.cssSelector("button.float-xs-right"));
        WebElement phoneInput = driver.findElement(By.name("phone"));

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys("Address 0");

        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("DOMI");

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("XXX");

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys("Good 3/2");

        zipCodeInput.click();
        zipCodeInput.clear();
        zipCodeInput.sendKeys("34-456");

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys("Neverland");

        chooseCountry.click();
        chosenCountry.click();
        chosenCountry.click();
        //Thread.sleep(2000);

        /*phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys("666 666 666");*/

        saveButton.click();
    }

    public void fillAddressForm(String alias, String firstName, String lastName, String address, String zipCode, String city, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement zipCodeInput = driver.findElement(By.name("postcode"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement chooseCountry = driver.findElement(By.name("id_country"));
        WebElement chosenCountry = driver.findElement(By.xpath("//*[text() = 'United Kingdom']"));
        WebElement saveButton = driver.findElement(By.cssSelector("button.float-xs-right"));
        WebElement phoneInput = driver.findElement(By.name("phone"));


        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        zipCodeInput.click();
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        chooseCountry.click();
        chosenCountry.click();

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        saveButton.click();

    }

    public void clickAddress() {
        WebElement addressButton = driver.findElement(By.id("addresses-link"));
        addressButton.click();
    }

    public void clickCreateNewAddress() {
        WebElement createButton = driver.findElement(By.xpath("//*[text() = 'Create new address']"));
        createButton.click();
    }


    public void checkFirstAddress() {
        WebElement information = driver.findElement(By.id("notifications"));
        String informationText = information.getAttribute("data-alert");

        if (informationText == "warning") {
            Assertions.fail("First address didn't add");
        } else {}

    }

    public void checkAddressVisibility() {
        WebElement information = driver.findElement(By.id("notifications"));
        String informationText = information.getAttribute("data-alert");
        if (informationText == "warning") {
            Assertions.fail("Address didn't add");
        } else {}
    }

    public void checkAddresses(String alias, String firstName, String lastName, String address, String zipCode, String city, String phone) {
        List<WebElement> addressBoxes = driver.findElements(By.cssSelector("div.address-body"));
        int addressBoxlength = addressBoxes.size();
        String addressBoxText = addressBoxes.get(addressBoxlength - 1).getText();
        System.out.println(addressBoxText);
        String addressExample = alias + "\n" + firstName + " " + lastName + "\n" + address + "\n" + city + "\n" + zipCode + "\n" + "United Kingdom" + "\n" + phone;
        System.out.println(addressExample);
        System.out.println(addressBoxText.equals(addressExample));
    }

    public void deleteAddress() {
        List<WebElement> deleteAddress = driver.findElements(By.xpath("//*[text() = 'Delete']"));
        int addressLength = deleteAddress.size();
        deleteAddress.get(addressLength - 1).click();
    }

    public void deletedAddressCheck() {
        WebElement information = driver.findElement(By.id("notifications"));
        String informationText = information.getAttribute("data-alert");
        if (informationText == "success") {
        } else{
            Assertions.fail("Address is deleted");
        }
    }
}
