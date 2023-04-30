package flows;
import org.openqa.selenium.WebDriver;
import pageObject.SenderReceiverInformPage;

public class SenderReceiverInfoFlow {

    //Attributes
    SenderReceiverInformPage senderReceiverInformPage;

    //Constructor
    public SenderReceiverInfoFlow(WebDriver driver){
        super();
        senderReceiverInformPage= new SenderReceiverInformPage(driver);
    }

    //Functions
    public void sendGiftCard(String receiverName,String event, String blessing, String picturePath,String receiverPhone,String senderName, String senderPhone) throws InterruptedException {
        senderReceiverInformPage
                    .clickOnToSomeoneElse();
        if (receiverName!= null)
            senderReceiverInformPage.insertReceiverName(receiverName);
        if(event!=null)
            senderReceiverInformPage.selectEvent(event);
        if (blessing!=null)
            senderReceiverInformPage.enterBlessing(blessing);
        if (picturePath!=null)
            senderReceiverInformPage.uploadPicture(picturePath);
        Thread.sleep(3000);
        senderReceiverInformPage
                    .clickOnContinue()
                    .clickOnSendNow()
                    .clickOnBySms();
        if (receiverPhone!=null)
            senderReceiverInformPage.insertReceiverPhone(receiverPhone);
        if (senderName!= null)
            senderReceiverInformPage.insertSenderName(senderName);
        if (senderPhone!=null)
            senderReceiverInformPage.insertSenderPhone(senderPhone);
        senderReceiverInformPage .clickOnContinueToPayment();
        Thread.sleep(5000);
        }


}
