package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class LoginTests extends BaseTest {

    private String email;
    private String password;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
        loginPage.driverWaitForEmailFieldPresence();
    }

    @Test
    public void validUrl(){
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }


    @Test
    public void checksInputTypes(){
        String typeAttributeEmail = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");
        String typeAttributePass = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
    }

    @Test
   public void displaysErrorsWhenUserDoesNotExist() {
        loginPage.login(email, password);
        loginPage.driverWaitForMessage();
        Assert.assertEquals("User does not exists", loginPage.getMessage().getText());
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
   }

   @Test
    public void displaysErrorsWhenPasswordIsWrong() {;
       loginPage.login("admin@admin.com", password);
       loginPage.driverWaitForMessage();
       Assert.assertEquals("Wrong password", loginPage.getMessage().getText());
       String actualLink = driver.getCurrentUrl();
       Assert.assertTrue(actualLink.contains("/login"));
   }

    @Test
    public void login() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/home"));
    }

    @Test
    public void logout() {
        loginPage.login("admin@admin.com", "12345");
        loginPage.driverWaitForLogoutButtonPresence();
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.logout();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualLink2 = driver.getCurrentUrl();
        Assert.assertTrue(actualLink2.contains("/login"));
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }




}
