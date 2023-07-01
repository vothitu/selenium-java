package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;
    private static int TIME_OUT_IN_SECONS = 30;

    public static void launch(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException(browserName + " is not support!!");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONS));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

    public static void captureScreenShot(String fileName) {
        TakesScreenshot scrShot = ((TakesScreenshot) Browser.getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(String.format("target/%s.png", fileName));
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void check (By element){
        if(!driver.findElement(element).isSelected()){
            driver.findElement(element).click();
        }
    }
    public static void uncheck(By element){
        if(driver.findElement(element).isSelected()){
            driver.findElement(element).click();
        }
    }

    public static void click (By element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static String getText(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public static void senKeys(By element, String withText){
        driver.findElement(element).sendKeys(withText);

    }

    public static void visit(String url){
        driver.get(url);
    }
    public static void hover(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public static void doubleClick(By element){
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(element)).perform();
    }

    public static void executeJSScript(String script,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script,element);
    }
    public static boolean isDisplayed(By element){
        return driver.findElements(element).size()>0;
    }

}
