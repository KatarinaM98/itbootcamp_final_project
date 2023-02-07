package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SignupTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        signupPage.openSignupPage();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email\"]")));
    }

    @Test
    public void test1_Visits_the_signup_page(){
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void test2_Checks_input_types(){
        String typeAttributeEmail = signupPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");
        String typeAttributePass = signupPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
        String typeAttributePass2 = signupPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
    }

    @Test
    public void test3_Displays_errors_when_user_does_not_exist() {
        signupPage.signup("Test Test", "admin@admin.com", "123654", "123654");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")));
        Assert.assertEquals("E-mail already exists", signupPage.getMessage().getText());
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void test5_SIGNUP() {
        signupPage.signup("John Doe", "johndoe1@gmail.com", "stolica", "stolica");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        Assert.assertEquals("IMPORTANT: Verify your account", homePage.getSignUpMessage().getText());
        signupPage.closeMessage();
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }

}
