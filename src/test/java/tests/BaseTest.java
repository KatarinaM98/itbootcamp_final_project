package tests;

import com.github.javafaker.Faker;
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
    protected Faker faker;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected BasePage basePage;
    protected HomePage homePage;
    protected AdminCities adminCities;
    protected ProfilePage profilePage;
    protected static final String baseUrl = "https://vue-demo.daniel-avellaneda.com";


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        adminCities = new AdminCities(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        driver.manage().window().maximize();
        faker = new Faker();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
