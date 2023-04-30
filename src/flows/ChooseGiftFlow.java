package flows;

import org.openqa.selenium.WebDriver;
import pageObject.ChooseGiftPage;

public class ChooseGiftFlow {

    //Attributes
    ChooseGiftPage chooseGiftPage;

    //Constructor
    public ChooseGiftFlow(WebDriver driver){
        super();
        chooseGiftPage= new ChooseGiftPage(driver);
    }

    //Functions
    public void goToSenderReceiverInformationPage() throws InterruptedException {
        chooseGiftPage.chooseGiftRandomly();
        Thread.sleep(3000);
        if(chooseGiftPage.GiftAmountIsExist()){
            chooseGiftPage
                .amountOfTheGift("100")
                .clickOnSelect();
            Thread.sleep(3000);
        }

        if (chooseGiftPage.subListAppear())
            chooseGiftPage.chooseGiftRandomlyFromSubList();

    }
}

