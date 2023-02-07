package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
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
        signupPage.driverWaitForEmailFieldPresence();
    }


    @Test
    public void visitsTheSignupPage() {
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void checksInputTypes() {
        String typeAttributeEmail = signupPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");
        String typeAttributePass = signupPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
        String typeAttributePass2 = signupPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");
    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        signupPage.signup("Test Test", "admin@admin.com", "123654", "123654");
        signupPage.driverWaitForMessage();
        Assert.assertEquals("E-mail already exists", signupPage.getMessage().getText());
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void signup() {
        signupPage.signup("John Doe", "johndoe1@gmail.com", "stolica", "stolica");
        signupPage.driverWaitForVerificationMessage();
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
