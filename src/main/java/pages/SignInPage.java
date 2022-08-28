package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn() {
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("aaa123@test.pl");

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("TEST123");

        signInButton.click();
    }
}
