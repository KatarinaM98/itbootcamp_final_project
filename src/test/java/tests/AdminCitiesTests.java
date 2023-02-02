package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @Test
    public void test1_Visits_the_admin_cities_page_and_list_cities() {
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCities.openCitiesPage();
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/admin/cities"));
        driver.manage().window().maximize();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")));
        Assert.assertTrue(adminCities.getLogoutButton().isDisplayed());
    }


    @Test
    public void test2_Create_new_city() {
        Faker faker = new Faker();
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        adminCities.openCitiesPage();

        adminCities.addNewCity(faker.address().city());
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        /*
        Test prolazi ako se u expected napiše:
         "Saved successfully\n" +
                "CLOSE"
         Test ne prolazi ako se napiše "Saved successfully"
        */
        //Assert.assertEquals("Saved successfully", adminCities.getMessage().getText());
        Assert.assertEquals("Saved successfully\n" + "CLOSE", adminCities.getMessage().getText());

    }

    @Test (dependsOnMethods = { "test2_Create_new_city" })
    public void test3_Edit_city() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
//        loginPage.openLoginPage();
//        loginPage.login("admin@admin.com", "12345");
//        driverWait.until(ExpectedConditions.urlContains("/home"));
//        adminCities.openCitiesPage();
        //driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"edit\"]/span/i")));
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCities.editCity();

        /*
        Test prolazi ako se u expected napiše:
        "Saved successfully\n" +
                "CLOSE"
         Test ne prolazi ako se napiše "Saved successfully"

        */

        //Assert.assertEquals("Saved successfully", adminCities.getMessage().getText());
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        Assert.assertEquals("Saved successfully\n" + "CLOSE", adminCities.getMessage().getText());
    }

    @Test (dependsOnMethods = { "test3_Edit_city", "test2_Create_new_city" })
    public void test4_Search_city() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Ako se stavi "+-edited" onda test 4 fejluje jer ne može da pretražuje "+-" karaktere --- PRIJAVITI BUG
        adminCities.searchCity();
        Assert.assertEquals(adminCities.getEditedCityInTable().getText(), adminCities.getSearchedCityInTable().getText());
    }

    @Test (dependsOnMethods = { "test3_Edit_city", "test2_Create_new_city", "test4_Search_city" })
    public void test5_Delete_city() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        adminCities.searchCity();
        //driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]/span")));

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(adminCities.getSearchText().getAttribute("value"), adminCities.getSearchedCityInTable().getText());

        adminCities.deleteCity();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]/ul/li")));

        Assert.assertEquals("Not found", adminCities.getMessage2().getText());

    }




}
