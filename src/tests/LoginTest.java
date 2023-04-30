package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {


    //Checking whether the error messages match
    @Test
    public void errorMessageEmailFiled(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        homePageFlow.goToLoginPage();
        loginFlow.userLogin(null,null);
        String actualMessage= loginPage.errorMessageEmailFiled();
        String expectedMessage="כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";

        try{
            assertEquals(actualMessage,expectedMessage);
            myTest.log(LogStatus.PASS, "The error messages match");
        } catch(AssertionError e) {
            myTest.log(LogStatus.FAIL, "The error messages don't match");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img + "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();

        }


    }

    //Checking whether the error messages match
    @Test
    public void errorMessagePasswordFiled(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        String actualMessage= loginPage.errorMessagePasswordFiled();
        String expectedMessage="כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";

        try{
            assertEquals(actualMessage,expectedMessage);
            myTest.log(LogStatus.PASS, "The error messages match");
        } catch(AssertionError e) {
            myTest.log(LogStatus.FAIL, "The error messages don't match");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img + "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();

        }
    }
}

