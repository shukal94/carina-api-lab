package com.solvd.automation.lab.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.solvd.automation.lab.carina.demo.gui.pages.onliner.OnlinerMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerMainPageTest extends AbstractTest {

    @Test
    public void validateBaseElements() {
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage(getDriver());
        onlinerMainPage.open();
        Assert.assertTrue(onlinerMainPage.isPageOpened(), "Main page was not opened!");
    }

    @Test
    public void enc() {
        CryptoTool c = new CryptoTool();
        String strToEncrypt = "changeme";
        String cypherText = c.encrypt(strToEncrypt);
        String strDecrypted = c.decrypt(cypherText);
        Assert.assertEquals(strDecrypted, strToEncrypt);
    }
}
