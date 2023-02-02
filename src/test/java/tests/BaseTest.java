package tests;

import org.testng.annotations.AfterClass;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LoginPage loginPage;

    protected SignupPage signupPage;
    protected BasePage basePage;
    protected HomePage homePage;
    protected AdminCities adminCities;


    protected static final String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\driver chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        adminCities = new AdminCities(driver, driverWait);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterClass // moras koristiti testNG anotacije, samo da vidim pom
    public void afterClass(){
        driver.quit();
    }


}
