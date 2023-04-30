package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import static org.junit.Assert.assertEquals;


public class SignUpTest extends BaseTest {



    // Go To Registration Page
    @Before
    public void openSignUpPage(){
        homePageFlow.goToLoginPage();
        loginFlow.goToRegistrationPage();
    }

    //Create a new user
    @Test
    public void registration_01() throws Exception {
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        signUpFlow.createNewUser(readFromRegistrationFile("name"),readFromRegistrationFile("mail"),readFromRegistrationFile("password"),readFromRegistrationFile("verifyPassword"));

        String actualPage= driver.getCurrentUrl();
        String expectedPage= buyMe;


        try{
            assertEquals(expectedPage,actualPage);
            myTest.log(LogStatus.PASS, "You have successfully registered");
        } catch(AssertionError e) {
            myTest.log(LogStatus.FAIL, "The site registration failed");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img+ "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();

        }
    }
}
