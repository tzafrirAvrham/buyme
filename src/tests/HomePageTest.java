package tests;


import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomePageTest extends BaseTest {


    //Search Gift Card
    @Test
    public void searchBarForPresent() throws Exception {
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        homePage
                .closeThePopUp()
                .selectPrice("500-750 ש\"ח")
                .selectArea("מרכז")
                .selectCategory("גיפט קארד לבריאות, ספורט ואקסטרים")
                .clickOnFindMePresent();
        Thread.sleep(5000);

        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://buyme.co.il/search?budget=5&category=6&region=11";

        try{
            assertEquals(expectedURL,actualURL);
            myTest.log(LogStatus.PASS, "The search successful");
        } catch(AssertionError e) {
            myTest.log(LogStatus.FAIL, "Search failed");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img + "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();
        }

}
}
