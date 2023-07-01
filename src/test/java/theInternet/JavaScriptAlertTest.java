package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {
    @Test
    void javaScriptAlertTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Promt']")).click();

        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();

    }
}
