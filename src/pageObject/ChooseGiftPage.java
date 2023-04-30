package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseGiftPage extends BasePage {


    //Attributes
    By listOfGifts=By.xpath("//*[@class='grid bm-product-cards']/div") ;
    By giftAmount= By.cssSelector("input[placeholder='הכנס סכום']");
    By selectClick= By.xpath("//*[@action='submitMoney']/div[2]/button");
    By subListOfGifts=By.xpath("//*[@class='grid gifts-list']/li");

    //Constructor
    public ChooseGiftPage(WebDriver driver) {
        super(driver);
    }

    //Functions
    public ChooseGiftPage chooseGiftRandomly(){
        selectRandomlyFromList(listOfGifts);
        return this;
    }
    public ChooseGiftPage amountOfTheGift(String amount){
        writeText(giftAmount, amount);
        return this;
    }
    public ChooseGiftPage clickOnSelect(){
        click(selectClick);
        return this;
    }
    public boolean GiftAmountIsExist(){
        return checkIfElementExist(giftAmount);
    }
    public ChooseGiftPage chooseGiftRandomlyFromSubList(){
        selectRandomlyFromList(subListOfGifts);
        return this;
    }
    public boolean subListAppear(){
        return checkIfElementExist(subListOfGifts);
    }
}
