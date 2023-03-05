package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    // web element

    By emailFiled= By.xpath("//form/div[1]/label/input[@type='email']");
    By loginWithFacebook= By.cssSelector("div[class='social-btn facebook']");
    By loginWithGoogle= By.cssSelector("div[class='social-btn google']");
    By passwordFiled= By.xpath("//form/div[2]/label/input[@type='password']");
    By forgotPasswordClick= By.cssSelector("u[class='bm-body-2 text-link theme db']");
    By registerClick= By.cssSelector("span[class='text-link theme']");
    By rememberMeClick= By.xpath("//div[@class='ember-view bm-checkbox checked']/div/span[1]");
    By loginClick= By.cssSelector("button[type='submit'][class='ember-view bm-btn no-reverse main md stretch']");




    //page Method

    public LoginPage clickOnLogin(){
        click(loginClick);
        return  this;
    }
    public LoginPage clickOnLoginWithFacebook(){
        click(loginWithFacebook);
        return  this;
    }
    public LoginPage clickOnLoginWithGoogle(){
        click(loginWithGoogle);
        return  this;
    }
    public LoginPage clickOnForgotPassword(){
        click(forgotPasswordClick);
        return this;
    }
    public LoginPage clickOnRegister(){
        click(registerClick);
        return this;
    }
    public LoginPage clickOnRememberMe(){
        if (!selected(rememberMeClick))
            click(rememberMeClick);
        return this;
    }
    public LoginPage insertEmail(String mail){
        writeText(emailFiled, mail);
        return this;
    }
    public LoginPage insertPassword(){
        writeText(passwordFiled, "123456");
        return this;
    }


}
