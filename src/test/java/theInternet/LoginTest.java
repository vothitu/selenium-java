package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    void withValidCredentialsShouldLoginSuccess(){
        /*
        1. Login successful with valid credentials
        2. Open browser
        3. Navigate to https://the-internet.herokuapp.com/login
        4. Fill in username with tomsmith
        5. Fill in the password with SuperSecretPassword!
        6. Click on Login button
        7. And the home page is appear
        */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.name("username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[type = text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[name = username]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[type = text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name = username]")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.tagName("input")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("[type = submit]")).click();
//        driver.findElement(By.className("fa-sign-in")).click();
//        driver.findElement(By.xpath("//i[contains(.,'Login')]")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        String wellcomeMessage = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(wellcomeMessage, "Welcome to the Secure Area. When you are done click logout below.");

    }
}
