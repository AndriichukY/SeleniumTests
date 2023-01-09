package tests.search;

import org.testng.annotations.Test;
import pages.pkw_main.PkwMainPage;
import tests.base.BaseTest;

import static constant.Constant.Urls.MAIN_PAGE;

public class SearchTest extends BaseTest {

    @Test

    public void checkIsRedirectToListing(){
        basePage.open(MAIN_PAGE);
        pkwMainPage.enterTextSearch();
    }

        }
