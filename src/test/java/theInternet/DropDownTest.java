package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    /*
    Open browser
    Navigate to https://the-internet.herokuapp.com/dropdown
    Select "option 1"
    Validate "option 1" is selected
    */
    @Test
    void selectMultipleOptionsSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        if(select.isMultiple()){
            System.out.println("Able select multiple options");
        }else {
            System.out.println("Select only 1 option");
        }

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.deselectByVisibleText("Apple");
    }
}
