package theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");


        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        sleep(2000);
        // actions.dragAndDrop(source, destination).perform();
        // sleep(2000);
        // OR
        actions.clickAndHold(source).moveToElement(destination).release().perform();
    }
}
