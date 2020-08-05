package com.solvd.automation.lab.carina.demo.gui.pages.onliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerMainPage extends AbstractPage {
    @FindBy(className = "b-top-logo")
    private ExtendedWebElement logo;

    @FindBy(className = "fast-search__form")
    private ExtendedWebElement searchForm;

    @FindBy(className = "auth-bar__item auth-bar__item--text")
    private ExtendedWebElement signinBtn;

    @FindBy(xpath = "(//div[contains(@class, 'project-navigation')])[1]/following-sibling::div[@class='b-tiles-outer']//div[@role='grid']//div[contains(@id, 'widget')]")
    private List<ExtendedWebElement> newsTiles;

    public OnlinerMainPage(WebDriver driver) {
        super(driver);
    }

    public OnlinerMainPage clickSignInButton() {
        signinBtn.click();
        return this;
    }

    public OnlinerArticlePage chooseTheArticleByIndex(int i) {
        newsTiles.get(i).click();
        return new OnlinerArticlePage(driver);
    }

    @Override
    public boolean isPageOpened() {
        return logo.isElementPresent() &&
                searchForm.isElementPresent() &&
                signinBtn.isElementPresent() &&
                newsTiles.stream().allMatch(e -> e.isElementPresent());
    }


}
