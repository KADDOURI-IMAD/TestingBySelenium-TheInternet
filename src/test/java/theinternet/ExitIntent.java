package theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

public class ExitIntent {
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/exit_intent");

        // Move the mouse out of the viewport
        moveMouseOutOfViewport();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));

        WebElement closeButton = modal.findElement(By.xpath(".//div[@class='modal-footer']/p"));
        closeButton.click();
    }

    private static void moveMouseOutOfViewport() throws AWTException {
            // Create a Robot object
            Robot rb = new Robot();
            // Move the mouse cursor to the specified coordinates
            rb.mouseMove(600, 0);

    }
}
