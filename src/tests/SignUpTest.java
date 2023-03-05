package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.assertEquals;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
public class SignUpTest extends BaseTest {





    @Before
    public void openSignUpPage(){
        homePage.clickOnLoginAndRegistry();
        loginPage.clickOnRegister();
    }

    @After
    public void afterTest(){
        extent.endTest(myTest);
    }

    @Test
    public void test01_emailFiledError(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());


        signUpPage
                .insertEmail("dddd")
                .clickOnSignUp();

        String actualErrorMessage= signUpPage.errorMessageEmailFiled();
        String exceptedErrorMessage= "ערך זה צריך להיות כתובת אימייל.";



        assertEquals(exceptedErrorMessage,actualErrorMessage);
        myTest.log(LogStatus.PASS, "info");

    }
    @Test
    public void test02_errorForPassword(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        signUpPage
                .insertPassword("jjj")
                .insertPasswordVerify("bbb")
                .clickOnSignUp();

        String actualError= String.valueOf(signUpPage.notMatchedPasswordError());
        String exceptedError= "הסיסמאות לא זהות, אולי זה מהתרגשות :)";

        assertEquals(exceptedError, actualError);
    }
    @Test
    public void test03_passwordLessThenEightUnit(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        signUpPage
                .insertEmail("hhh@gamil.com")
                .insertName()
                .insertPassword("hhhhh")
                .insertPasswordVerify("hhhhh")
                .clickOnConfirmLoginTerms()
                .clickOnConfirmReceiptAdvertisements()
                .clickOnSignUp();


        String actualError= String.valueOf(signUpPage.loginError());
        String exceptedError= "הסיסמה צריכה להכיל לפחות 8 תווים, ביניהם לפחות אות אחת גדולה באנגלית, לפחות אות אחת קטנה באנגלית ולפחות ספרה אחת";

        assertEquals(exceptedError, actualError);
        myTest.log(LogStatus.PASS, "info");
    }




}
