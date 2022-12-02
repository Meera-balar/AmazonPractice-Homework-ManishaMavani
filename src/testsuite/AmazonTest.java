package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;


public class AmazonTest extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void amazonTest() throws InterruptedException{
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        Thread.sleep(500);
        mouseHoverToElementAndClick(By.xpath("//input[@id='nav-search-submit-button']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[5]/ul[1]/li[1]//span[1]/a[1]/div[1]/label[1]/i[@class='a-icon a-icon-checkbox']"));
        List<WebElement> productsName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Total number of product is : " + productsName.size());
        int expectedProducts = 30;
        int actualProducts = productsName.size();
        Assert.assertEquals(expectedProducts,actualProducts);

        for (WebElement productNames : productsName) {
            System.out.println("Product Name is  : " + productNames.getText());
        }
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
