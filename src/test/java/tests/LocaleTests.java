package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void test1_Set_locale_to_ES() {
        homePage.changeLanguage("ES");

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")));

        Assert.assertEquals("Página de aterrizaje", homePage.getHeaderTextES().getText());

    }

    @Test
    public void test2_Set_locale_to_EN() {
        homePage.changeLanguage("EN");

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")));

        Assert.assertEquals("Landing", homePage.getHeaderTextES().getText());

    }

    @Test
    public void test3_Set_locale_to_FR() {
        homePage.changeLanguage("FR");

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")));

        Assert.assertEquals("Page d'atterrissage", homePage.getHeaderTextES().getText());

    }



}
