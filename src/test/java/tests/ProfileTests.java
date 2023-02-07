package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ProfileTests extends BaseTest {

    private String newPassword;
    private String name;
    private String phone;
    private String city;
    private String country;
    private String twitter;
    private String gitHub;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        newPassword = faker.internet().password();
        name = faker.name().firstName();
        phone = faker.phoneNumber().cellPhone();
        city = "New York";
        country = faker.country().name();
        twitter = "https://twitter.com/" + faker.name().username().toLowerCase();
        gitHub = "https://github.com/" + faker.name().username().toLowerCase();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        profilePage.openProfileChangePage();
    }

    @Test
    public void test1_Edits_profile() {
       profilePage.clearText();
        profilePage.changeProfile(newPassword, name, phone, country, city, twitter, gitHub);
        Assert.assertTrue(profilePage.getMessageSaved().getText().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePage.getName().getAttribute("value"), name);
        Assert.assertEquals(profilePage.getPhone().getAttribute("value"), phone);
        Assert.assertEquals(profilePage.getCountry().getAttribute("value"), country);
        Assert.assertEquals(profilePage.getSelectCityEnterText().getAttribute("value"), city);
        Assert.assertEquals(profilePage.getUrlTwitter().getAttribute("value"), twitter);
        Assert.assertEquals(profilePage.getUrlGitHub().getAttribute("value"), gitHub);

    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }


}
