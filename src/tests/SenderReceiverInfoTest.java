package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
public class SenderReceiverInfoTest extends BaseTest {


    //Sending a Gift Card
    @Test
    public void test_01_SendGiftCard() throws Exception {
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        homePageFlow.goToLoginPage();
        loginFlow.userLogin(readFromRegistrationFile("mail"), readFromRegistrationFile("password"));
        Thread.sleep(20000);
        homePageFlow.goToChooseGiftPage();
        chooseGiftFlow.goToSenderReceiverInformationPage();
        myTest.log(LogStatus.INFO, "Arrived to Sender Receiver Information Page");
        senderReceiverInformFlow.sendGiftCard(readFromSendGiftFile("receiverName"), readFromSendGiftFile("event"), readFromSendGiftFile("blessing"), readFromSendGiftFile("picturePath"), readFromSendGiftFile("receiverPhone"), readFromSendGiftFile("senderName"), readFromSendGiftFile("senderPhone"));

        try {
            assertTrue(senderReceiverInformPage.sendPresentButtonAppear());
            myTest.log(LogStatus.PASS, "The Gift Card has been sent successfully");
        }catch (Exception e){
            myTest.log(LogStatus.FAIL, "Failed to send Gift Card");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img + "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }



    //Checking whether  the color of "step one" is orange.
    @Test
    public void test_02_ColorOfStepOne(){
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        String actualColor = senderReceiverInformPage.colorOfStepOne();
        String expectedColor = "#ffa126";

        try {
            assertEquals(actualColor, expectedColor);
            myTest.log(LogStatus.PASS, "The colors is match");
        }catch (Exception e){
            myTest.log(LogStatus.FAIL, "The colors don't match");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img+ "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();
        }


    }
    //Checking whether  the blessing that present in Gift Card preview match with the data entered in test 1
    @Test
    public void test_03_DisplayOfTheGift() throws Exception {
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        senderReceiverInformPage.clickOnGiftCardPreview();

        String actualBlessing=senderReceiverInformPage.showPreviewBlessing();
        String expectedBlessing= readFromSendGiftFile("blessing");

        try {
            assertEquals(expectedBlessing, actualBlessing);
            myTest.log(LogStatus.PASS, "The blessings match");
        }catch (Exception e){
            myTest.log(LogStatus.FAIL, "The blessing don't match");
            myTest.log(LogStatus.INFO, "screen:" + myTest.addScreenCapture(takeScreenShot(img + "\\" + System.currentTimeMillis())));
            System.out.println(e.getMessage());
            Assert.fail();
        }


    }



}
