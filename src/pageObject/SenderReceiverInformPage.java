package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SenderReceiverInformPage extends BasePage {


    //Attribute
    By toSomeoneElseButton= By.cssSelector("div[gtm='למישהו אחר']");
    By ReceiverNameFiled= By.cssSelector("#friendName input");
    By selectEventClick= By.cssSelector("span.selected-text");
    By eventOptions= By.cssSelector(".input-label-wrapper .dropdown ul li");
    By enterBlessingFiled= By.tagName("textarea");
    By uploadPictureClick= By.cssSelector(".media-circle-btn.ember-view.bm-media-upload input");
    By continueClick= By.cssSelector("button[type='submit']");
    By sendNowClick= By.cssSelector(".ember-view.button.button-now.selected");
    By sendBySms= By.cssSelector(".ember-view.bm-sending-methods div:nth-of-type(1)");
    By phoneReceiverFiled= By.id("sms");
    By senderNameFiled= By.cssSelector("input[placeholder='שם שולח המתנה']");
    By phoneSenderFiled= By.cssSelector(".mx-6.md-12.bottom-sm input[data-parsley-mobile='mobile']");
    By ContinueToPaymentClick= By.cssSelector("button[gtm='המשך לתשלום']");
    By sendPresentButton= By.cssSelector("button[gtm='אישור התשלום ושליחת המתנה']");
    By stepOneButtonColor= By.xpath("//*[@class='steps'] /div[1]/div[1]");
    By giftCardPreviewClick= By.cssSelector(".giftcard-preview");
    By previewOfBlessing= By.cssSelector(".greeting.bottom-md");


    //Constructor
    public SenderReceiverInformPage(WebDriver driver) {
        super(driver);
    }

    //Functions
    public SenderReceiverInformPage clickOnToSomeoneElse(){
        if (!selected(toSomeoneElseButton))
        click(toSomeoneElseButton);
        return this;
    }
    public SenderReceiverInformPage insertReceiverName(String name){
        writeText(ReceiverNameFiled, name);
        return this;
    }
    public SenderReceiverInformPage selectEvent(String event){
        chooseFromList(selectEventClick, eventOptions,event);
        return this;
    }
    public SenderReceiverInformPage enterBlessing(String text){
        writeText(enterBlessingFiled, text);
        return this;
    }
    public SenderReceiverInformPage uploadPicture(String picturePath){
        uploadFile(uploadPictureClick,picturePath);
        return this;
    }
    public SenderReceiverInformPage clickOnContinue(){
        click(continueClick);
        return this;
    }
    public SenderReceiverInformPage clickOnSendNow(){
        if (!selected(sendNowClick))
        click(sendNowClick);
        return this;
    }
    public SenderReceiverInformPage clickOnBySms(){
        click(sendBySms);
        return this;
    }
    public SenderReceiverInformPage insertReceiverPhone(String receiverPhone){
        writeText(phoneReceiverFiled, receiverPhone);
        return this;
    }
    public SenderReceiverInformPage insertSenderName(String senderName){
        writeText(senderNameFiled, senderName);
        return this;
    }
    public SenderReceiverInformPage insertSenderPhone(String senderPhone){
        writeText(phoneSenderFiled, senderPhone);
        return this;
    }
    public SenderReceiverInformPage clickOnContinueToPayment(){
        click(ContinueToPaymentClick);
        return this;
    }
    public boolean sendPresentButtonAppear(){
        return checkIfElementExist(sendPresentButton);
    }
    public String colorOfStepOne(){
        return elementColor(stepOneButtonColor);
    }
    public SenderReceiverInformPage clickOnGiftCardPreview(){
        click(giftCardPreviewClick);
        return this;
    }
    public String showPreviewBlessing(){
        return getText(previewOfBlessing);
    }
}
