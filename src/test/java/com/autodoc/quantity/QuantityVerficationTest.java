package com.autodoc.quantity;

import com.autodoc.general_settings.GeneralSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

    public class QuantityVerficationTest extends GeneralSettings {

    @Test
    public void verifyQuant() {

        driver.findElement(By.xpath("//form[@class=\"header__search-form\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("SKBP-0011162", Keys.ENTER);
        delaySec();
        String total = driver.findElement(By.xpath("//span[@class=\"js-products-count\"]")).getText();
        int totalInt = Integer.valueOf(total);
        int elements = driver.findElements(By.xpath("//div[@class=\"brand-products\"]")).size();

        delaySec();

        WebElement nextPage = driver.findElement(By.xpath("//span[@class=\"next\"]"));

        if (nextPage.isDisplayed() == true){
            System.out.println("Next Page is displayed");

        }

        System.out.println("Total quantity on listing is: "+totalInt+ ". Total quantity on page is: "+elements);


        /*if (totalInt > 0) {
            int totalQ = 0;
            boolean hasLastPageBtn = false;
            WebElement nextPage = driver.findElement(By.xpath("//span[@class=\"next\"]"));
            do {
                WebElement lastPageBtn = driver.findElement(By.xpath("//span[@class=\"next\"]"));
                hasLastPageBtn = lastPageBtn.isDisplayed();

                int elements = driver.findElements(By.xpath("//div[@class=\"brand-products\"]")).size();

                if (elements != 20) {
                    System.out.println("Test failed count less than 20");
                }

                totalQ = totalQ + elements;
                String link = driver.findElement(By.xpath("//span[@class=\"next\"]//a")).getAttribute("href");
                driver.get(link);
                delaySec();
            } while (hasLastPageBtn);

            int elementsOnLastPage = driver.findElements(By.xpath("//div[@class=\"brand-products\"]")).size();
            totalQ = totalQ + elementsOnLastPage;
            System.out.println(totalQ);

        }*/
    }
}


