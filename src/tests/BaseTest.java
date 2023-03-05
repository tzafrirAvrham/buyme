package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;


public class BaseTest {

    String buyMe = "https://buyme.co.il/";
    static HomePage homePage;
    static LoginPage loginPage;
    static SignUpPage signUpPage;
    public static WebDriver driver;
    static ExtentReports extent;
    static ExtentTest myTest;
    static String reportFilePath= "C:/Users/USER/IdeaProjects/buyme/report/reports.html";



    @BeforeClass
    public static void setup() {

        extent= new ExtentReports(reportFilePath);
        myTest= extent.startTest("signUpTest");

        chooseBrowser("chrome");
        maximizeBrowser();
        homePage= new HomePage(driver);
        loginPage= new LoginPage(driver);
        signUpPage= new SignUpPage(driver);

    }
    @Before
    public void openWebsite(){
        website(buyMe);
    }


    @AfterClass
    public static void closeTests(){
        driver.close();
        driver.quit();
        extent.flush();
    }



    public static void maximizeBrowser() {
      driver.manage().window().maximize();
    }


    public void website(String web){
        driver.get(web);
    }


    public static void chooseBrowser(String browser){
     switch (browser) {

       case "chrome": {
         System.setProperty("webdriver.chrome.diver", "C:/Users/USER/Desktop/selenium/chromedriver.exe");
         driver = new ChromeDriver();
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
