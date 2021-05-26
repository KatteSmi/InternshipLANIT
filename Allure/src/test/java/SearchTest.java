import io.qameta.allure.Issue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    private FindMultiplePrinters driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KATE\\chromedriver_win32\\chromedriver.exe");
        driver = new FindMultiplePrinters(new ChromeDriver());
    }

    @Test
    public void searchTest() {
        driver.openMainPage();
        WebElement category = driver.category();
        driver.makeScreenShot();
        driver.makeAshotScreenShot(category);

        WebElement search = driver.search();
        driver.makeAshotScreenShot(search);


        WebElement printer = driver.printer();
        driver.makeAshotScreenShot(printer);

        WebElement city = driver.city();
        driver.makeAshotScreenShot(city);

        WebElement button = driver.button();
        driver.makeAshotScreenShot(button);

        WebElement checkBox = driver.checkBox();
        driver.makeScreenShot();
        driver.makeAshotScreenShot(checkBox);

        WebElement filter = driver.filter();
        driver.makeScreenShot();
        driver.makeAshotScreenShot(filter);

        driver.printerAndPriceList();
        driver.makeScreenShot();

        driver.quit();
    }
}

