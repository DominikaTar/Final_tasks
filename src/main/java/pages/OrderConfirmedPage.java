package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OrderConfirmedPage {
    private WebDriver driver;

    public OrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void screenShot() throws IOException { //https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot/1.5.4
        Screenshot orderScreenShot = new AShot().takeScreenshot(driver);
        ImageIO.write(orderScreenShot.getImage(), "PNG", new File("C:\\CL\\PageScreenshot.png"));
    }

    public void fullScreenShot() throws IOException {
        Screenshot orderScreenShotFull = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(orderScreenShotFull.getImage(), "PNG", new File("C:\\CL\\FullPageScreenshot.png"));
    }
}
