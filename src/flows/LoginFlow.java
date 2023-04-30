package flows;

import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;



public class LoginFlow {

    //Attributes
    LoginPage loginPage;


    //Constructor
    public LoginFlow(WebDriver driver){
         super();
         loginPage= new LoginPage(driver);
     }

     //Functions
     public void goToRegistrationPage(){
         loginPage.clickOnRegister();
     }
     public void userLogin(String mail, String password){
         if (mail !=null)
             loginPage.insertEmail(mail);
         if (password !=null)
             loginPage.insertPassword(password);
         loginPage.clickOnLogin();
     }
}
