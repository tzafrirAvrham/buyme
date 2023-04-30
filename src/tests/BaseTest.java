package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import flows.*;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import pageObject.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;


public class BaseTest {

     //Attributes
     HomePage homePage;
     LoginPage loginPage;
     HomePageFlow homePageFlow;
     ChooseGiftFlow chooseGiftFlow;
     SenderReceiverInformPage senderReceiverInformPage;
     SignUpFlow signUpFlow;
     LoginFlow loginFlow;
     SenderReceiverInfoFlow senderReceiverInformFlow;
     static ScreenRecorder screenRecorder;
     static WebDriver driver;
     static ExtentReports extent;
     static ExtentTest myTest;
     final static String reportFilePath= "C:/Users/USER/IdeaProjects/buyme/report/reports.html";
     final String img= "C:/Users/USER/IdeaProjects/buyme/screenshot";
     final static String recordPath= "C:/Users/USER/IdeaProjects/buyme/record";
     final static String buyMe = "https://buyme.co.il/";



     //Opening the browser that the user select and start the report and recording
    @BeforeClass
    public static void setup() throws Exception {

        extent= new ExtentReports(reportFilePath);
        myTest= extent.startTest("buymeTests");

        chooseBrowser(readFromRegistrationFile("browser"));
        driver.manage().window().maximize();
        website(buyMe);
        startRecording();
    }

    //Initializing of imported pages
    @Before
    public void initializing(){
        homePage= new HomePage(driver);
        loginPage= new LoginPage(driver);
        senderReceiverInformPage= new SenderReceiverInformPage(driver);
        signUpFlow= new SignUpFlow(driver);
        loginFlow= new LoginFlow(driver);
        senderReceiverInformFlow= new SenderReceiverInfoFlow(driver);
        homePageFlow= new HomePageFlow(driver);
        chooseGiftFlow= new ChooseGiftFlow(driver);
    }
    //End of the test report
    @After
    public void afterTest(){
        extent.endTest(myTest);
    }


    //Closing the browser and ending the recording and the report.
    @AfterClass
    public static void closeTests() throws IOException {
        driver.quit();
        screenRecorder.stop();
        myTest= extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTest.log(LogStatus.INFO, "screen:" + myTest.addScreencast(screenRecorder.getCreatedMovieFiles().toString()));
        extent.flush();
    }

    //Functions


    //Start Recording
    public static void startRecording() throws Exception {

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc,
                gc.getBounds(),
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null,
                new File(recordPath));
        screenRecorder.start();
    }
    //ScreenShot
    public String takeScreenShot(String imagesPate){
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File screenShotFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile= new File(imagesPate+".png");
        try{
            FileUtils.copyFile(screenShotFile, destinationFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  imagesPate+".png";}
    //Data from Registration file
    public static String readFromRegistrationFile(String data) throws  Exception{

        File xmlfile= new File("C:/Users/USER/IdeaProjects/buyme/src/data/registration.xml");
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder db= dbFactory.newDocumentBuilder();
        Document doc= db.parse(xmlfile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(data).item(0).getTextContent();
    }
    //Data from SendGift file
    public String readFromSendGiftFile(String data) throws Exception{

        File xmlfile= new File("C:/Users/USER/IdeaProjects/buyme/src/data/sendGift.xml");
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder db= dbFactory.newDocumentBuilder();
        Document doc= db.parse(xmlfile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(data).item(0).getTextContent();
    }
    //Choosing website by url
    public static void website(String web){
        driver.get(web);
    }
    //Choosing Browser
    public static void chooseBrowser(String browser){
     switch (browser) {

       case "chrome": {
           ChromeOptions options= new ChromeOptions();
           options.addArguments("--remote-allow-origins=*");
           System.setProperty("webdriver.chrome.diver", "C:/Users/USER/Desktop/selenium/chromedriver.exe");
         driver = new ChromeDriver(options);
         break;
       }
       case "edge": {
          System.setProperty("webdriver.edge.driver", "C:/Users/USER/Desktop/selenium/msedgedriver.exe");
          driver = new EdgeDriver();
          break;
       }
        case "firefox": {
          System.setProperty("webdriver.gecko.marionette", "C:/Users/USER/Desktop/selenium/geckodriver.exe");
          driver = new FirefoxDriver();
          break;
        }
        default:
          System.out.println("the option are chrome, edge and firefox!");
        }

     }



}
