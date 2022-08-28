package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // nie wiem czemu nie działa....
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    public void clickSignIn() {
        WebElement signInButton = driver.findElement(By.cssSelector("div.user-info"));
        signInButton.click();
    }

    public boolean checkUserNameVisibility() {
        WebElement signInButton = driver.findElement(By.cssSelector("span.hidden-sm-down"));
        String signInText = signInButton.getAttribute("tittle");

        if (signInText == "Log in to your customer account") {
            return false;
        } else {
            return true;
        }
    }

    public void returnToHomePage() {
        WebElement logo = driver.findElement(By.id("_desktop_logo"));
        logo.click();
    }

    public void chooseSweater() {
        WebElement sweater = driver.findElement(By.xpath("//*[text() = 'Hummingbird printed sweater']"));
        sweater.click();
    }


}
