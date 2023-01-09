package tests.base;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import pages.base.BasePage;
import pages.pkw_main.PkwMainPage;
import tests.search.SearchTest;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected PkwMainPage pkwMainPage = new PkwMainPage(driver);

   @BeforeTest
    public void acceptCookies() {

        WebElement cookieFooter = driver.findElement(By.xpath("//div[@class=\"popup-choose-cookies__first-block\"]"));

        if (cookieFooter != null) {
            cookieFooter.findElement(By.xpath("//a[@class=\"js-button_choose popup-choose-cookies__btn popup-choose-cookies__btn--full\"]")).click();
        }
    }

    @AfterSuite
    public  void close (){
        driver.quit();
    }
}
