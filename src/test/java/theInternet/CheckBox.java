package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox {

    @Test
    void validateCheckSuccessfully(){
        WebDriver drive = new ChromeDriver();
        drive.get("https://the-internet.herokuapp.com/checkboxes");

        check(drive.findElement(By.cssSelector("#checkboxes input:first-child")));
        Assert.assertTrue(drive.findElement(By.cssSelector("#checkboxes input:first-child")).isSelected());

        check(drive.findElement(By.cssSelector("#checkboxes input:last-child")));
        Assert.assertTrue(drive.findElement(By.cssSelector("#checkboxes input:last-child")).isSelected());
    }

    @Test
    void validateUncheckSuccessfully(){
        WebDriver drive = new ChromeDriver();
        drive.get("https://the-internet.herokuapp.com/checkboxes");

        uncheck(drive.findElement(By.cssSelector("#checkboxes input:first-child")));
        Assert.assertFalse(drive.findElement(By.cssSelector("#checkboxes input:first-child")).isSelected());

        uncheck(drive.findElement(By.cssSelector("#checkboxes input:last-child")));
        Assert.assertFalse(drive.findElement(By.cssSelector("#checkboxes input:last-child")).isSelected());
    }

    static void check(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }
    static void uncheck(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }
}
