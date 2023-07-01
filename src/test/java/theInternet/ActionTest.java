package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest {
    @Test
    void contextClickOnRectangle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions mouse = new Actions(driver);
        mouse
                .contextClick(driver.findElement(By.id("hot-spot")))
                .perform();
        driver.switchTo().alert().accept();

    }
    @Test
    void keyPress() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions keyboard = new Actions(driver);
        keyboard.sendKeys("A").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("B").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("C").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("D").perform();
        Thread.sleep(1000);
    }
}
