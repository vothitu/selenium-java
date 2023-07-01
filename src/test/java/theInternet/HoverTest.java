package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
    /*Hover elements
Open browser
Navigate to https://the-internet.herokuapp.com/hovers
When user hover on user 1 avatar
Then the "name: user1" label is present.*/
    @Test
    void avatar1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions mouse = new Actions(driver);
        List<WebElement> avatars = driver.findElements(By.cssSelector(".figure img"));
        for(WebElement avatar:avatars){
            Thread.sleep(1000);
            mouse
                    .moveToElement(avatar)
                    .perform();
        }
}
}
