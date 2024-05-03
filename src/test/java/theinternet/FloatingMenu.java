package theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class FloatingMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/floating_menu");


        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Thread.sleep(2000);
        // Find the link to be opened in a new tab using XPath
        String linkXPath = "//*[@id='menu']/ul/li[3]/a";
        // Click the link using JavaScript to open in a new tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0])", driver.findElement(By.xpath(linkXPath)));

        Set<String> AllWindows = driver.getWindowHandles();
        System.out.println(AllWindows);
        Thread.sleep(2000);
        for (String window :AllWindows){
            if(!window.equalsIgnoreCase(parent)){
                driver.switchTo().window(parent);
            }
        }
    }
}
