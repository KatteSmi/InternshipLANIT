import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Steps {

    public static WebDriver driver;
    public static boolean checkResult = false;
    public static String city;


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KATE\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close() { driver.quit();
    }

    @ParameterType(".*")
    public Categories categories(String categories) {
        return Categories.valueOf(categories);
    }

    @ParameterType(".*")
    public PriceType priceType(String priceType) {
        return PriceType.valueOf(priceType);
    }

    @Пусть("открыт ресурс авито")
    public static void open() {
        driver.get("https://www.avito.ru/");
    }

    @И("в выпадающем списке категорий выбрана {categories}")
    public void selectCategory(Categories categories) {
        Select genreSelect = new Select(driver.findElement(By.xpath("//*[@id=\"category\"]/option[39]")));
        genreSelect.selectByVisibleText(categories.type);
    }

    @И("в поле поиска введено значение {string}")
    public void enteredValue(String string) {
        WebElement search = driver.findElement(By.xpath("//input[contains(@data-marker, 'search-form/suggest')]"));
        search.sendKeys(string);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        search.sendKeys(Keys.ENTER);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void region() {
        WebElement region = driver.findElement(By.xpath("//div[contains(@class, 'main-select-2pf7p main-location-3j9by')]"));
        region.click();
    }

    @Тогда("в поле регион введено значение {string}")
    public void enteredRegion(String string) {
        WebElement city = driver.findElement(By.xpath("//input[contains(@class, 'suggest-input-3p8yi')]"));
        city.sendKeys(string);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        city.sendKeys(Keys.ENTER);
    }

    @И("нажата кнопка показать объявления")
    public void buttonToShow() {
        WebElement saveButton = driver.findElement(By.xpath("//div/button[contains(@data-marker, 'popup-location/save-button')]"));
        saveButton.click();
    }

    @Тогда("открылась страница результаты по запросу {string}")
    public void openResults(String string) {
        WebElement pageTitle = driver.findElement(By.xpath("//div/h1[contains(@data-marker, 'page-title/text')]"));
    }

    @И("активирован чекбокс только с фотографией")
    public void ifChecked() {
        WebElement checkbox = driver.findElement(By.xpath("//div/label[contains(@data-marker, 'delivery-filter')]"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @И("в выпадающем списке сортировка выбрано значение {sorts}")
    public void sortByDesc() {
        driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-s-3-rn6 button-primary-1RhOG width-width-12-2VZLz']")).click();
        driver.findElement(By.xpath("//div/select/option[3][contains(@value, '2')]")).click();

    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void consoleOut(int num) {
        List<WebElement> printersList = driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(@class,'price-price')]"));

        for (int i = 0; i < num; i++) {
            System.out.println(printersList.get(i).getText() + " , ");
            System.out.println("Цена - " + priceList.get(i).getText());
        }
    }
}
