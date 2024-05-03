package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.logging.Logger;


public class EntryAd {
    private static final Logger log = Logger.getLogger(EntryAd.class.getName());

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        // Wait for the modal to appear (if applicable)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = null;
        try {
            modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
            // If modal is present, close it
            closeModal(modal);
        } catch (Exception e) {
            // Modal not present, continue with other actions
            System.out.println("Modal not present.");
        }

        // Click on the link
        WebElement restartAdLink = driver.findElement(By.id("restart-ad"));
        restartAdLink.click();

        // Wait for the modal to appear again (if applicable)
        try {
            modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
            // If modal is present, close it
            closeModal(modal);
        } catch (Exception e) {
            // Modal not present, continue with other actions
            System.out.println("Modal not present after clicking the link.");
        }

        // Close the browser
        driver.quit();
    }

    private static void closeModal(WebElement modal) {
        WebElement closeButton = modal.findElement(By.xpath(".//div[@class='modal-footer']/p"));
        closeButton.click();
        System.out.println("Modal closed.");
    }
}
