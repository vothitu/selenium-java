package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenEdgBrowserTest {
    @Test
    void defaultMode(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }
}
