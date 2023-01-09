package com.autodoc.redirect_to_reifen_by_clicking;

import com.autodoc.general_settings.GeneralSettings;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RedirectToReifenByClickingTest extends GeneralSettings {
    @Test public void verifyRedirectToReifPageByClick(){
        driver.findElement(By.id("header_menu_tyres")).click();

        

        delaySec();
        driver.findElement(By.id("id=\"tyres_search\"")).click();
        }
        //String hrefValue = driver.findElement(By.xpath("//link[@hreflang=\"de\"]")).getAttribute("href");
        //String hrefValue = driver.findElement(By.xpath("a[@class=\"header__top-line-rate-link\"]")).getAttribute("href");

        //a[@class="header__top-line-rate-link"]
        //System.out.println(hrefValue);
    }

