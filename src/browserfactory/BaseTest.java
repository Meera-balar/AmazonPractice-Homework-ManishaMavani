package browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class BaseTest {
    //global variable declaration for webdriver
    public static WebDriver driver;

    //Method for openBrowser
    public void openBrowser(String baseUrl) {
        //setup key-value for Chrome browser
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
//        driver = new EdgeDriver();
        //Launch the URL
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //method declaration and implementation for close browser
    public void closeBrowser() {
        driver.quit(); //quit() method will close entire webdriver session
    }

}
