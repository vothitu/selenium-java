package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFireFoxBrowserTest {
    @Test
    void defaultMode(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }
}
