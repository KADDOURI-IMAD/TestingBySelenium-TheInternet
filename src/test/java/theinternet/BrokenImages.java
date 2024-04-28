package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/broken_images");

        String[] imageXPaths = {
                "//*[@id=\"content\"]/div/img[1]",
                "//*[@id=\"content\"]/div/img[2]",
                "//*[@id=\"content\"]/div/img[3]"
        };

        for (String xpath : imageXPaths) {
            WebElement image = driver.findElement(By.xpath(xpath));
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Image at XPath: " + xpath + " is broken.");
            } else {
                System.out.println("Image at XPath: " + xpath + " is not broken.");
            }
        }

        driver.quit();
    }
}
