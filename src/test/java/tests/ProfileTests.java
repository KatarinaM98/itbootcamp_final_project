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
        //privremeno je blokiran admin nalog, pa ću privremeno koristiti logovanje sa drugog naloga
//        loginPage.login("admin@admin.com", "12345");
        //loginPage.login("ana@ana.com", "12345");
        Faker faker = new Faker();
        signupPage.openSignupPage();
        signupPage.signup("sdasdsa", faker.internet().emailAddress(), "12345", "12345");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        profilePage.openProfilePage();
        driverWait.until(ExpectedConditions.urlContains("/profile"));
        profilePage.changeProfile();


    }


    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }


}
