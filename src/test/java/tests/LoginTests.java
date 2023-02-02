package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;


public class LoginTests extends BaseTest {




    @Test
    public void test1_validUrl(){
        Faker faker = new Faker();
        loginPage.openLoginPage();
        //driver.get("https://vue-demo.daniel-avellaneda.com/login");
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }


    @Test
    public void test2_Checks_input_types(){
        loginPage.openLoginPage();
        //driver.get("https://vue-demo.daniel-avellaneda.com/login");
        String typeAttributeEmail = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");

        String typeAttributePass = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
    }

    @Test
   public void test3_Displays_errors_when_user_does_not_exist() {
        Faker faker = new Faker();
        loginPage.openLoginPage();
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")));
        Assert.assertEquals("User does not exists", loginPage.getMessage().getText());
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
   }

   @Test
    public void test4_Displays_errors_when_password_is_wrong() {
       loginPage.openLoginPage();
       loginPage.login("admin@admin.com", "dfgfdgfd");
       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")));
       Assert.assertEquals("Wrong password", loginPage.getMessage().getText());

       String actualLink = driver.getCurrentUrl();
       Assert.assertTrue(actualLink.contains("/login"));
   }

    @Test
    public void test5_LOGIN() {
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/home"));
    }

    @Test
    public void test6_LOGOUT() {
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        driver.manage().window().maximize();


        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")));
        driver.manage().window().maximize();

       // WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());

      homePage.logout();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualLink2 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink2.contains("/login"));


    }





}
