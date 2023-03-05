package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends  BasePage {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    By nameFiled= By.xpath("//form[@action='register']/div[1]/label/input");
    By emailFiled= By.xpath("//form[@action='register']/div[2]/label/input");
    By passwordFiled= By.xpath("//form[@action='register']/div[3]/label/input");
    By verifyPasswordFiled= By.xpath("//form[@action='register']/div[4]/label/input");
    By confirmLoginTermsClick= By.xpath("//form[@action='register']/div[5]/div/div/span[1]");
    By confirmReceiptAdvertisementsClick = By.xpath("//form[@action='register']/div[6]/div/div/span[1]");
    By signUpClick= By.cssSelector("button[gtm='הרשמה ל-BUYME']");
    By backToLoginPageClick= By.cssSelector(".register-or-login .text-link.theme");
    By errorPasswordsNotMatch= By.cssSelector("li.parsley-equalto");
    By errorMassageEmail= By.cssSelector("li.parsley-type");
    By loginError= By.cssSelector(".login-error");


    public SignUpPage clickOnConfirmLoginTerms(){
        if (!selected(confirmLoginTermsClick))
            click(confirmLoginTermsClick);
        return  this;
    }
    public SignUpPage clickOnSignUp(){
        click(signUpClick);
        return  this;
    }
    public SignUpPage clickOnBackToLogin(){
        click(backToLoginPageClick);
        return  this;
    }
    public SignUpPage clickOnConfirmReceiptAdvertisements(){
        if (!selected(confirmReceiptAdvertisementsClick))
            click(confirmReceiptAdvertisementsClick);
        return  this;
    }
    public SignUpPage insertName(){
        writeText(nameFiled, "name");
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
    public String notMatchedPasswordError(){

        return errorMessage(errorPasswordsNotMatch);
    }
    public String errorMessageEmailFiled(){

        return errorMessage(errorMassageEmail);
    }
    public String loginError(){

        return errorMessage(loginError);
    }
}
