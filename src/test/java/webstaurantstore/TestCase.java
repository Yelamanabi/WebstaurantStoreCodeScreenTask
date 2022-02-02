package webstaurantstore;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestCase {
    @Test
    public void testWorkTable() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.webstaurantstore.com/");

        WebElement searchBox = driver.findElement(By.id("searchval"));
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button"));

        searchBox.sendKeys("stainless work table");
        searchBtn.click();

        List<WebElement> searchForStainlessWorkTable = driver.findElements(By.xpath("//*[@id=\"product_listing\"]/div"));

        WebElement lastProduct = driver.findElement(By.xpath("//*[@id=\"product_listing\"]/div[60]/div[4]/form/div/div/input[2]"));

        for (int i = 0; i < searchForStainlessWorkTable.size(); i++) {

            assertTrue(searchForStainlessWorkTable.get(i).getText().contains("Table"));

            if (i == searchForStainlessWorkTable.size() - 1) {
                lastProduct.click();
            }
        }

        //viewing cart
        driver.findElement(By.xpath("//*[@id=\"watnotif-wrapper\"]/div/p/div[2]/div[3]/a[1]")).click();


        //clicking Empty cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/form/div/div[1]/div/a")).click();

        //Empty cart confirmation
        driver.findElement(By.xpath("//div/button[.='Empty Cart']")).click();


        Thread.sleep(2000);

        driver.quit();

    }

}
