import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageObject {

    @FindBy(css = "#category")
    WebElement category;

    @FindBy(xpath = "//*[@id=\"category\"]/option[39]")
    WebElement desiredCategory;

    @FindBy(css = "#search")
    WebElement search;

    @FindBy(xpath = "//div[contains(@class, 'main-select-2pf7p main-location-3j9by')]")
    WebElement city;

    @FindBy(xpath = "//input[contains(@class, 'suggest-input-3p8yi')]")
    WebElement desiredCity;

    @FindBy(xpath = "//li[contains(@data-marker, 'suggest(0)')]")
    WebElement choice;

    @FindBy(xpath = "//button[contains(@data-marker, 'popup-location/save-button')]")
    WebElement button;

    @FindBy(xpath = "//div/label[contains(@data-marker, 'delivery-filter')]")
    WebElement checkBox;

    @FindBy(xpath = "//div/select/option[3][contains(@value, '2')]")
    WebElement filter;

    @FindBy(xpath = "//h3[contains(@itemprop, 'name')]")
    List<WebElement> printersList;

    @FindBy(xpath = "//span[contains(@class,'price-price')]")
    List<WebElement> priceList;

    public void category() {
        category.click();
    }

    public void desiredCategory() {
        desiredCategory.click();
    }

    public void search() {
        search.sendKeys("Принтер");
        zhdun();
        search.sendKeys(Keys.ENTER);
    }

    public void city() {
        city.click();
    }

    public void desiredCity() {
        desiredCity.sendKeys("Владивосток");
        zhdun();
        desiredCity.sendKeys(Keys.ENTER);
    }

    public void choice() {
        choice.click();
    }

    public void button() {
        button.click();
    }

    public void checkBox() {
        if (!checkBox.getAttribute("class").contains("checkbox-checked")) {
            checkBox.click();
        }
    }

    public void filter() {
        filter.click();
    }

    public void printerPriceList() {
        for (int i = 0; i < 3; i++) {
            System.out.println(printersList.get(i).getText() + " , ");
            System.out.println("Цена - " + priceList.get(i).getText());
        }
    }

    public void zhdun() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

