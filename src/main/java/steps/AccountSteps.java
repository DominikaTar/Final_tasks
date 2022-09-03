package steps;

import io.cucumber.java.en.*;
import net.jodah.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressesPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class AccountSteps {
    private static WebDriver driver;
    AddressesPage onAddressesPage = new AddressesPage(driver);

    @Given("user is on main page")
    public void userIsOnMainPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user clicks sign in button")
    public void userClicksSignInButton() {
        HomePage onHomepage = new HomePage(driver);
        onHomepage.clickSignIn();
    }

    @And("fills correct email and password and clicks sign in button")
    public void fillsCorrectEmailAndPasswordAndClicksSignInButton() {
        SignInPage onSignInPage = new SignInPage(driver);
        onSignInPage.logIn();
    }

    @Then("user is logged")
    public void userIsLogged() {
        HomePage onHomePage = new HomePage(driver);
        onHomePage.checkUserNameVisibility();

    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @Given("user is on an account details")
    public void userIsOnAnAccountDetails() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        HomePage onHomePage = new HomePage(driver);
        onHomePage.clickSignIn();
        SignInPage onSignInPage = new SignInPage(driver);
        onSignInPage.logIn();
        onHomePage.checkUserNameVisibility();
    }

    @When("user clicks Add first address button")
    public void userClicksAddFirstAddressButton() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickAddFirstAddres();
    }

    @And("fills address form and clicks Save button")
    public void fillsAddressFormAndClicksSaveButton() throws InterruptedException {
        AddressesPage onAddressessPage = new AddressesPage(driver);
        onAddressessPage.fillFirstAddressForm();
    }

    @Then("first address is added")
    public void firstAddressIsAdded() {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.checkFirstAddress();
    }

    @Given("user is on an account details page and already has one address added")
    public void userIsOnAnAccountDetailsPageAndAlreadyHasOneAddressAdded() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        HomePage onHomePage = new HomePage(driver);
        onHomePage.clickSignIn();
        SignInPage onSignInPage = new SignInPage(driver);
        onSignInPage.logIn();
        onHomePage.checkUserNameVisibility();
    }

    @When("user clicks Address button and Create new Address button")
    public void userClicksAddressButtonAndCreateNewAddressButton() {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.clickAddress();
        onAddressesPage.clickCreateNewAddress();

    }

    @And("fills the form with {string}, {string}, {string}, {string}, {string}, {string}, {string} and clicks save button")
    public void fillsTheFormWithAndClicksSaveButton(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.fillAddressForm(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Then("addresses are added to an account")
    public void addressesAreAddedToAnAccount() {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.checkAddressVisibility();
    }

    @And("delete address")
    public void deleteAddress() {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.deleteAddress();
        onAddressesPage.deletedAddressCheck();
    }


    @And("check address with {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void checkAddressWith(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.checkAddresses(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
}
