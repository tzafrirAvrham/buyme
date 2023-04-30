package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends  BasePage {

    //Attributes
    By nameFiled= By.xpath("//form[@action='register']/div[1]/label/input");
    By emailFiled= By.xpath("//form[@action='register']/div[2]/label/input");
    By passwordFiled= By.xpath("//form[@action='register']/div[3]/label/input");
    By verifyPasswordFiled= By.xpath("//form[@action='register']/div[4]/label/input");
    By confirmLoginTermsClick= By.xpath("//form[@action='register']/div[5]/div/div/span[1]");
    By confirmReceiptAdvertisementsClick = By.xpath("//form[@action='register']/div[6]/div/div/span[1]");
    By signUpClick= By.cssSelector("button[gtm='הרשמה ל-BUYME']");

    //Constructor
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //Functions
    public SignUpPage clickOnConfirmLoginTerms(){
        if (!selected(confirmLoginTermsClick))
            click(confirmLoginTermsClick);
        return  this;
    }
    public SignUpPage clickOnSignUp(){
        click(signUpClick);
        return  this;
    }
    public SignUpPage clickOnConfirmReceiptAdvertisements(){
        if (!selected(confirmReceiptAdvertisementsClick))
            click(confirmReceiptAdvertisementsClick);
        return  this;
    }
    public SignUpPage insertName(String name){
        writeText(nameFiled, name);
        return this;
    }
    public SignUpPage insertEmail(String email){
        writeText(emailFiled, email);
        return this;
    }
    public SignUpPage insertPassword(String pass){
        writeText(passwordFiled, pass);
        return this;
    }
    public SignUpPage insertPasswordVerify(String pass){
        writeText(verifyPasswordFiled, pass);
        return this;
    }
}
