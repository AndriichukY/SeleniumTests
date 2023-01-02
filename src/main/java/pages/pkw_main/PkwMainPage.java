package pages.pkw_main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class PkwMainPage extends BasePage {
    public PkwMainPage(WebDriver driver) {
        super(driver);
    }

    private final By searchForm = By.xpath("//form[@class=\"header__search-form\"]");
    private final By inputField = By.xpath("//input[@type=\"text\"]");

    public PkwMainPage enterTextSearch() {

        String inputValue = "SKBP-0011162";

        driver.findElement(searchForm).click();
        driver.findElement(inputField).sendKeys(inputValue, Keys.ENTER);

        return this;
    }
}
