package caculator;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;

public class CaculatorTest extends BaseTest {
    BodyMassIndexPage bodyMassIndexPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @BeforeMethod
    void setUp(){
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearForm();
    }

    @DataProvider
    Object[][] data(){
        return new Object[][]{
                {"26","male","40","150","BMI = 17.8 kg/m2"},
                {"30","female","40","150","BMI = 17.8 kg/m2"},
                {"30","female","70","170","BMI = 24.2 kg/m2" },
        };
    }
    @Test(dataProvider = "data")
    void tc01(String age, String gender, String weight, String height, String exceptedResult){
        bodyMassIndexPage.fillCaculatorForm(age,gender,weight,height);
        Assert.assertEquals(bodyMassIndexPage.getResult(), exceptedResult);
    }
}
