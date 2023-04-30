package flows;

import org.openqa.selenium.WebDriver;
import pageObject.SignUpPage;

public class SignUpFlow {

    //Attributes
    SignUpPage signUpPage;

    //Constructor
    public SignUpFlow(WebDriver driver){
        super();
        signUpPage= new SignUpPage(driver);
    }

    //Functions
    public void createNewUser(String name, String mail, String password, String verifyPassword) throws InterruptedException {
        if (name !=null)
            signUpPage.insertName(name);
        if (mail != null)
            signUpPage.insertEmail(mail);
        if (password!= null)
            signUpPage.insertPassword(password);
        if (verifyPassword!= null)
            signUpPage.insertPasswordVerify(verifyPassword);
        signUpPage.clickOnConfirmLoginTerms();
        signUpPage.clickOnConfirmReceiptAdvertisements();
        signUpPage.clickOnSignUp();
        Thread.sleep(4000);
    }
}
