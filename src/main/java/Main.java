import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void dellay2sec() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://pagination.js.org/");

        dellay2sec();

        List<WebElement> elements= driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

        String text =elements.get(5).getText();
        System.out.println(text);

        pages.get(2).click();
        wait.until(ExpectedConditions.stalenessOf(elements.get(5)));

        elements=driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));

        text=elements.get(5).getText();
        System.out.println(text);




/*        driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
        dellay2sec();


        WebElement element1 = driver.findElement(By.id("draggable"));
        WebElement element2 = driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        //actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();
        actions.clickAndHold(element1).moveToElement(element2).release().build().perform();
        actions.dragAndDrop(element1, element2);
        dellay2sec();*/

        dellay2sec();

        driver.quit();
    }
}
