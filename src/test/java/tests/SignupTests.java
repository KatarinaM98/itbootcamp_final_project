package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test
    public void test1_Visits_the_signup_page(){

        driver.manage().window().maximize();
        signupPage.openSignupPage();
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void test2_Checks_input_types(){
        signupPage.openSignupPage();

        String typeAttributeEmail = signupPage.getEmail().getAttribute("type");
        Assert.assertEquals(typeAttributeEmail, "email");

        String typeAttributePass = signupPage.getPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");

        String typeAttributePass2 = signupPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(typeAttributePass, "password");

    }

    @Test
    public void test3_Displays_errors_when_user_does_not_exist() {

       signupPage.openSignupPage();
       // driver.get("https://vue-demo.daniel-avellaneda.com/signup");

        signupPage.signup("Test Test", "admin@admin.com", "123654", "123654");


        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")));
        Assert.assertEquals("E-mail already exists", signupPage.getMessage().getText());

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));
    }

    @Test
    public void test5_SIGNUP() {
        signupPage.openSignupPage();
        signupPage.signup("John Doe", "john@gmail.com", "stolica", "stolica");


        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        Assert.assertEquals("IMPORTANT: Verify your account", homePage.getSignUpMessage().getText());

    }



}
