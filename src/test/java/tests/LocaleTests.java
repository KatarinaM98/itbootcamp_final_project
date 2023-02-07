package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void setLocaleToES() {
        homePage.changeLanguage("ES");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Página de aterrizaje", homePage.getHeaderText().getText());
    }

    @Test
    public void setLocaleToEN() {
        homePage.changeLanguage("EN");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Landing", homePage.getHeaderText().getText());
    }

    @Test
    public void setLocaleToFR() {
        homePage.changeLanguage("FR");
        homePage.driverWaitForHeading();
        Assert.assertEquals("Page d'atterrissage", homePage.getHeaderText().getText());

    }

}
