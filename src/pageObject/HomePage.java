package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{


     //Attributes
     By loginAndRegisterClick= By.cssSelector(".notSigned span");
     By pricePointClick= By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[1]/div/div[1]/span");
     By chooseAreaClick=By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[2]/div/div[1]/span");
     By chooseCategoryClick= By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[3]/div/div[1]/span");
     By priceOptions= By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[1]/div/div[2]/ul/li");
     By areaOptions= By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[2]/div/div[2]/ul/li");
     By categoryOptions= By.xpath("//*[@class='ember-view header-search-bar home']/div/form/label[3]/div/div[2]/ul/li");
     By findMePresentClick= By.linkText("תמצאו לי מתנה");
     By loadingDots= By.xpath("//*[@id='app-loading-img']/div");
     By popUpClose= By.xpath("/html/body/div[6]/div/div[2]");


     //Constructor
     public HomePage(WebDriver driver) {
        super(driver);
    }


    //Functions
    public HomePage clickOnLoginAndRegistry(){
        click(loginAndRegisterClick);
        return this;
    }
    public HomePage selectPrice(String text){
        chooseFromList(pricePointClick,priceOptions,text);
        return this;
    }
    public HomePage selectArea(String text){
        chooseFromList(chooseAreaClick,areaOptions,text);
        return this;
    }
    public HomePage selectCategory(String text){
        chooseFromList(chooseCategoryClick,categoryOptions,text);
        return this;
    }
    public HomePage clickOnFindMePresent(){
        click(findMePresentClick);
        return this;
    }
    public HomePage randomPriceChoose(){
        click(pricePointClick);
        selectRandomlyFromList(priceOptions);
        return this;
    }
    public HomePage randomAreaChoose(){
        click(chooseAreaClick);
        selectRandomlyFromList(areaOptions);
        return this;
    }
    public HomePage randomCategoryChoose(){
        click(chooseCategoryClick);
        selectRandomlyFromList(categoryOptions);
        return this;
    }
    public HomePage sizeOfLoadingDots(){
        while (checkIfElementExist(loadingDots) == false)
        {
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.NANOSECONDS);
        }
        elementSize(loadingDots);
        return this;
    }
    public HomePage closeThePopUp() throws InterruptedException {
         try {
             Thread.sleep(3000);
             click(popUpClose);
         }catch (Exception e){
             System.out.println("pop-up window didn't appear");
         }

         return this;
    }
}
