package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShoppingSteps {
    private WebDriver driver;

    @Given("user is on main page and logged and has one deliver address added")
    public void userIsOnMainPageAndLogged() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        HomePage onHomepage = new HomePage(driver);
        onHomepage.clickSignIn();
        SignInPage onSignInPage = new SignInPage(driver);
        onSignInPage.logIn();
        onHomepage.returnToHomePage();
    }

    @When("user clicks Hummingbird Printed Sweater")
    public void userClicksHummingbirdPrintedSweater() {
        HomePage onHomepage = new HomePage(driver);
        onHomepage.chooseSweater();
    }

    @And("chooses size M and quantity {int}")
    public void choosesSizeAndQuantity(int arg1) {
        SweaterPage onSweaterPage = new SweaterPage(driver);
        onSweaterPage.chooseSizeM();
        onSweaterPage.chooseQuantity(arg1);
    }

    @And("clicks Add to cart button and Proceed to Checkout button")
    public void clicksAddToCartButtonAndProceedToCheckoutButton() {
        SweaterPage onSweaterPage = new SweaterPage(driver);
        onSweaterPage.clickAddToCart();
        onSweaterPage.clickCart();
        CartPage onCartPage = new CartPage(driver);
        onCartPage.clickProceedToCheckout();
    }

    @And("confirms address")
    public void confirmsAddress() {
        CheckoutPage onCheckoutPage = new CheckoutPage(driver);
        onCheckoutPage.confirmAddress();
    }


    @And("chooses Pick-up in store delivery method")
    public void choosesPickUpInStoreDeliveryMethod() {
        CheckoutPage onCheckoutPage = new CheckoutPage(driver);
        onCheckoutPage.chooseDelivery();
    }

    @And("chooses Pay by Check method and clicks Order button")
    public void choosesPayByCheckMethodAndClicksOrderButton() {
        CheckoutPage onCheckoutPage = new CheckoutPage(driver);
        onCheckoutPage.paymentMethod();
        onCheckoutPage.clickOrder();
    }

    @Then("user confirmed shopping and made screenshot")
    public void userConfirmedShoppingAndMadeScreenshot() throws IOException {
        OrderConfirmedPage onOrderConfirmedPage = new OrderConfirmedPage(driver);
        onOrderConfirmedPage.screenShot();
        onOrderConfirmedPage.fullScreenShot();
    }

    @And("cclose the browser")
    public void ccloseTheBrowser() {
        driver.quit();
    }
}
