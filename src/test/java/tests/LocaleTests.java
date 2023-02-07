package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void test1_Set_locale_to_ES() {
        homePage.changeLanguage("ES");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Página de aterrizaje", homePage.getHeaderText().getText());
    }

    @Test
    public void test2_Set_locale_to_EN() {
        homePage.changeLanguage("EN");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Landing", homePage.getHeaderText().getText());
    }

    @Test
    public void test3_Set_locale_to_FR() {
        homePage.changeLanguage("FR");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Page d'atterrissage", homePage.getHeaderText().getText());

    }

}
