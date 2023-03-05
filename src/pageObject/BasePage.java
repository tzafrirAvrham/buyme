package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver= driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void click(By elementLocation){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    public  void writeText(By elementLocation, String text){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }
    public void waitVisibility(By by){
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public boolean selected(By elementLocation){
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).isSelected();
    }
    public String errorMessage(By elementLocation){
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }
}
