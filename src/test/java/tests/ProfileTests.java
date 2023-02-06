package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProfileTests extends BaseTest {

    @Test
    public void test1_Edits_profile() {

        //loginPage.openLoginPage();
      // loginPage.login("admin@admin.com", "12345");
        //privremeno je blokiran admin nalog, pa ću privremeno koristiti logovanje sa drugog naloga

        Faker faker = new Faker();
        signupPage.openSignupPage();
        signupPage.signup(faker.name().firstName(), faker.internet().emailAddress(), "12345", "12345");
       driverWait.until(ExpectedConditions.urlContains("/home"));
        profilePage.openProfilePage();

        driverWait.until(ExpectedConditions.urlContains("/profile"));

        profilePage.changeProfile();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));


        Assert.assertEquals(profilePage.getMessageSaved().getText(), "Profile saved successfuly\n" +
                "CLOSE");


        String nameAssert = profilePage.getName().getText();
        Assert.assertEquals(profilePage.getName().getAttribute("value"), nameAssert);


        String typeAttributePass2 = profilePage.getPhone().getAttribute("value");
        Assert.assertEquals(typeAttributePass2, profilePage.getPhone().getText());

        String typeAttributePass3 = profilePage.getCountry().getAttribute("value");
        Assert.assertEquals(typeAttributePass3, profilePage.getCountry().getText());

        String typeAttributePass4 = profilePage.getSelectCityEnterText().getAttribute("value");
        Assert.assertEquals(typeAttributePass4, profilePage.getSelectCityEnterText().getText());

        String typeAttributePass5 = profilePage.getUrlTwitter().getAttribute("value");
        Assert.assertEquals(typeAttributePass5, profilePage.getUrlTwitter().getText());

        String typeAttributePass6 = profilePage.getUrlGitHub().getAttribute("value");
        Assert.assertEquals(typeAttributePass6, profilePage.getUrlGitHub().getText());





    }


    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }


}
