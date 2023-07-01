package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameTest {
    /*
    1.Nested frames
    2.Open browser
    3.Navigate to https://the-internet.herokuapp.com/nested_frames
    4. Verify Text present:
    -     LEFT
          RIGHT
          MIDDLE
          BOTTOM
    */
    @Test
    void verifyFrame(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top"); //Switch to frame top
        driver.switchTo().frame("frame-left"); //switch to frame left
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
    }
}
