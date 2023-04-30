package flows;

import org.openqa.selenium.WebDriver;
import pageObject.HomePage;

public class HomePageFlow {

    //Attributes
    HomePage homePage;

    //Constructor
    public HomePageFlow(WebDriver driver){
        super();
        homePage= new HomePage(driver);
    }

    //Functions
    public void goToLoginPage(){
        homePage.clickOnLoginAndRegistry();
    }
    public void goToChooseGiftPage() throws InterruptedException {
        homePage
                .randomPriceChoose()
                .randomAreaChoose()
                .randomCategoryChoose()
                .clickOnFindMePresent();
        Thread.sleep(3000);

    }


}
