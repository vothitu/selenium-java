package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    List<Person> table1= new ArrayList<>();
    @BeforeClass
    void setUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1 tbody tr"));
        for(WebElement row: rows){
            String lastName = row.findElements(By.tagName("td")).get(0).getText();
            String firstname = row.findElements(By.tagName("td")).get(1).getText();
            String email = row.findElements(By.tagName("td")).get(2).getText();
            Float due = Float.valueOf(row.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
            String website = row.findElements(By.tagName("td")).get(4).getText();
            Person person =  new Person( lastName,firstname, email, due, website);
            table1.add(person);
        }
    }
    @Test
    void getPersonWhoHasMaxOfDue() {
        Person maxdue = table1.stream().max(Comparator.comparing(Person::getDue)).orElseThrow();
        Assert.assertEquals(String.format("%s %s", maxdue.getLastName(), maxdue.getFirstName()), "Doe Jason");

    }

    }