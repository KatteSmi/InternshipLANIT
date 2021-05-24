import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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

        PageObject page = PageFactory.initElements(driver, PageObject.class);

        page.category();
        page.desiredCategory();
        page.search();
        page.city();
        page.desiredCity();
        page.choice();
        page.button();
        page.checkBox();
        page.filter();
        page.printerPriceList();
    }
}
