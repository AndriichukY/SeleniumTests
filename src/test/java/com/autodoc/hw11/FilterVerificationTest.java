package com.autodoc.hw11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilterVerificationTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private final String baseURL = "https://front_test:YNA709O1mRPmsgww@test.pkwteile.de";
    private WebDriver driver;

    private static void delaySec() {
        delaySec(3);
    }

    private static void delaySec(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.navigate().to(baseURL);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
        acceptCookies();
    }

    public void acceptCookies() {
        WebElement cookieFooter = driver.findElement(By.xpath("//div[@class=\"popup-choose-cookies__first-block\"]"));

        if (cookieFooter != null) {
            cookieFooter.findElement(By.xpath("//a[@class=\"js-button_choose popup-choose-cookies__btn popup-choose-cookies__btn--full\"]")).click();
        }
        delaySec();
    }

    @Test
    public void verifyQuant() {

        String inputValue="SKBP-0011162";

        driver.findElement(By.xpath("//form[@class=\"header__search-form\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(inputValue, Keys.ENTER);
        delaySec();
        String article = driver.findElement(By.xpath("//div[@class=\"brand-products\"][1]//div[@class=\"nr\"]/span[1]")).getText();
         if (article.contains(inputValue)){
        System.out.println("The product with search article is first!");
    } else {
        System.out.println("The product isn't first "+article);}
}
    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
