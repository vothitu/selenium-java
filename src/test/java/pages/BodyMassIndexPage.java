package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static common.Browser.click;
import static common.Browser.senKeys;

public class BodyMassIndexPage {
    public BodyMassIndexPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
    * Suffix: ==> naming convention
    * Tab
    * RadioButton
    * Button
    * TextBox
    * Label
    * */

    WebDriver driver;
    By metricUnitTab = By.id("menuon");
    By clearButton = By.className("clearbtn");
    By ageTextBox = By.id("cage");
    By maleRadioButton = By.cssSelector("label[for=csex1]");
    By femaleRadioButton = By.cssSelector("label[for=csex2]");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By caculateButton  = By.cssSelector("[type = image]");
    By resultLabel = By.cssSelector(".rightresult .bigtext b");

    public BodyMassIndexPage(){
        this.driver = Browser.getDriver();
    }
    public void selectMetricTab(){
        driver.findElement(metricUnitTab);
    }

    public void clearForm(){

        driver.findElement(clearButton).click();
    }
    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }
    public void fillCaculatorForm(String age, String gender, String weight, String height){
        senKeys(ageTextBox, age);
        if(gender.equalsIgnoreCase("male")){
            check(maleRadioButton);
        }else{
            check(femaleRadioButton);
        }
        //driver.findElement(By.name("csex")).sendKeys("Female");
        senKeys(heightTextBox,height);
        senKeys(weightTextBox,weight);
        click(caculateButton);
    }
    public String getResult(){
        return driver.findElement(resultLabel).getText();
    }
    private void check(By locator){
        if(!driver.findElement(locator).isSelected()){
            driver.findElement(locator).click();
        }
    }
}
