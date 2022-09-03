package cos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class Main01 {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        HomePage onHomePage = new HomePage(driver);
        /* onHomePage.clickSignIn();
        SignInPage onSignInPage = new SignInPage(driver);
        onSignInPage.logIn();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        AddressesPage onAddressesPage = new AddressesPage(driver);*/

    }
}
