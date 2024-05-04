package theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Frames {
    public static void main(String[] args) {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Switch to Top Frame
            driver.switchTo().frame("frame-top");
            // Switch to Left Frame
            WebElement frameLeft = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-left")));
            driver.switchTo().frame(frameLeft);
            String text1 = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in Left Frame: " + text1);

            // Switch to Middle Frame
            driver.switchTo().defaultContent(); // Switching back to parent frame
            // Switch to Top Frame
            driver.switchTo().frame("frame-top");
            WebElement frameMiddle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-middle")));
            driver.switchTo().frame(frameMiddle);
            String text2 = driver.findElement(By.id("content")).getText();
            System.out.println("Text in Middle Frame: " + text2);

            // Switch to Right Frame
            driver.switchTo().defaultContent(); // Switching back to parent frame
            // Switch to Top Frame
            driver.switchTo().frame("frame-top");
            WebElement frameRight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-right")));
            driver.switchTo().frame(frameRight);
            String text3 = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in Right Frame: " + text3);

            // Switch to Bottom Frame
            driver.switchTo().defaultContent(); // Switching back to parent frame
            WebElement frameBottom = driver.findElement(By.name("frame-bottom"));
            driver.switchTo().frame(frameBottom);
            String text4 = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in Bottom Frame: " + text4);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
