package ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EcommerceTest {
    @Test
    void validateTotalPrice(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/p/5034224981?iid=153638834105&var=453955077516");
    }
}
