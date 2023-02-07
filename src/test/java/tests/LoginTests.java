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
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("//*[@id=\"app\"]/div[4]/div/div/div[3]/button")));
    }

    @Test
    public void test1_validUrl(){
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }


    @Test
    public void test2_Checks_input_types(){
        String typeAttributeEmail = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");
        String typeAttributePass = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
    }

    @Test
   public void test3_Displays_errors_when_user_does_not_exist() {
        loginPage.login(email, password);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")));
        Assert.assertEquals("User does not exists", loginPage.getMessage().getText());
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
   }

   @Test
    public void test4_Displays_errors_when_password_is_wrong() {;
       loginPage.login("admin@admin.com", password);
       driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")));
       Assert.assertEquals("Wrong password", loginPage.getMessage().getText());
       String actualLink = driver.getCurrentUrl();
       Assert.assertTrue(actualLink.contains("/login"));
   }

    @Test
    public void test5_LOGIN() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/home"));
    }

    @Test
    public void test6_LOGOUT() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")));
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
