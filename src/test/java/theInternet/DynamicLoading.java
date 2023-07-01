package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoading {
    @Test
    void elementIsHidden() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String finish = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("#finish h4")))
                .getText();

        Assert.assertEquals(finish,"Hello World!");
    }
}
