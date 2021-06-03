import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindMultiplePrinters {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KATE\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");

        Select genreSelect = new Select(driver.findElement(By.cssSelector("#category")));
        genreSelect.selectByVisibleText("Оргтехника и расходники");

        WebElement search = driver.findElement(By.xpath("//input[contains(@data-marker, 'search-form/suggest')]"));
        search.sendKeys("Принтер");
        zhdun();
        search.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[contains(@class, 'main-select-2pf7p main-location-3j9by')]")).click();

        WebElement city = driver.findElement(By.xpath("//input[contains(@class, 'suggest-input-3p8yi')]"));
        city.sendKeys("Владивосток");
        zhdun();
        city.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//li[contains(@data-marker, 'suggest(0)')]")).click();

        driver.findElement(By.xpath("//button[contains(@data-marker, 'popup-location/save-button')]")).click();

        WebElement checkbox = driver.findElement(By.xpath("//div/label[contains(@data-marker, 'delivery-filter')]"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-s-3-rn6 button-primary-1RhOG width-width-12-2VZLz']")).click();

        driver.findElement(By.xpath("//div/select/option[3][contains(@value, '2')]")).click();

        List<WebElement> printersList = driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(@class,'price-price')]"));

        for (int i = 0; i < 3; i++) {
            System.out.println(printersList.get(i).getText() + " , ");
            System.out.println("Цена - " + priceList.get(i).getText());
        }
    }

        public static void zhdun () {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

