package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    static By loginAndRegisterClick= By.cssSelector(".notSigned span");




    public HomePage clickOnLoginAndRegistry(){
        click(loginAndRegisterClick);
        return this;
    }
}
