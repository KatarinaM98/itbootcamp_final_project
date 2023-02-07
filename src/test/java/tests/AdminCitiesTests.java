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

public class AdminCitiesTests extends BaseTest {

    private String city;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        city = faker.address().city();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        adminCities.driverWaitForHomePage();
        adminCities.openCitiesPage();
    }

    @Test
    public void test1_Visits_the_admin_cities_page_and_list_cities() {

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/admin/cities"));
        driver.manage().window().maximize();
        adminCities.driverWaitForLogoutButtonPresence();
        Assert.assertTrue(adminCities.getLogoutButton().isDisplayed());
    }

    @Test
    public void test2_Create_new_city() {

        adminCities.addNewCity(city);
        adminCities.driverWaitForMessage();
        Assert.assertTrue(adminCities.getMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void test3_Edit_city() {
        adminCities.editCity();
        adminCities.driverWaitForMessage();
        Assert.assertTrue(adminCities.getMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void test4_Search_city() {
        adminCities.searchCity();
        Assert.assertEquals(adminCities.getEditedCityInTable().getText(), adminCities.getSearchedCityInTable().getText());
    }

    @Test
    public void test5_Delete_city() {
        adminCities.searchCity();
        Assert.assertEquals(adminCities.getSearchText().getAttribute("value"), adminCities.getSearchedCityInTable().getText());
        adminCities.deleteCity();
        adminCities.driverWaitForMessage();
        Assert.assertTrue(adminCities.getMessage2().getText().contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logoutButton = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
        }
    }

}
