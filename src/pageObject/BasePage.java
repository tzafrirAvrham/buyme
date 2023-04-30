package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class BasePage {

    //Attributes
    static WebDriver driver;
    WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver= driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Functions

    //Clicking on the element
    public void click(By elementLocation){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    //Inserting text
    public  void writeText(By elementLocation, String text){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }
    //Waiting 1.5 seconds for the element to appear
    public void waitVisibility(By by){
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //Check if the element is selected
    public boolean selected(By elementLocation){
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).isSelected();
    }
    //Text of the error message
    public String errorMessage(By elementLocation){
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }
    //Choose from list
    public void chooseFromList(By elementLocation,By options, String text){
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
        List<WebElement> list= driver.findElements(options);
        for (WebElement choose : list){
            if (choose.getText().equals(text))
                choose.click();
        }
    }
    //File uploading
    public  void uploadFile(By elementLocation, String text){
        WebElement uploadFile= driver.findElement(elementLocation);
        uploadFile.sendKeys(text);
    }
    //Random selection from a list
    public void selectRandomlyFromList(By elementLocation){
        waitVisibility(elementLocation);
        List<WebElement> allOptions= driver.findElements(elementLocation);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allOptions.size());
        allOptions.get(randomProduct).click();
    }
    //Check the size of the element
    public void elementSize(By elementLocation){
        WebElement load= driver.findElement(elementLocation);
        Dimension dimension= load.getSize();
        System.out.println(dimension);
    }
    //Checks whether the element exists on the page
    public boolean checkIfElementExist(By elementLocation){
        try {
            driver.findElement(elementLocation);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //Color of element in his Hexadecimal value
    public String elementColor(By elementLocation){
        WebElement element = driver.findElement(elementLocation);
        String color= element.getCssValue("color");
        return Color.fromString(color).asHex();

    }
    //Get text from the element
    public String getText(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }

}
