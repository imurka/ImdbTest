package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;
import java.util.List;


/**
 * Created by Ирина on 02.08.2015.
 */
public class Top250Page {
    WebDriver driver;
    Logger log;

    @FindBy(how = How.CLASS_NAME, using = "lister-sort-by")
    public WebElement sortMenu;

    public Top250Page(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(Top250Page.class);
        PageFactory.initElements(driver, this);
    }

    public void setSorting(String sortName){
        List<WebElement> dropDownValues = new Select(sortMenu).getOptions();
        for (WebElement option : dropDownValues) {
            if (option.getText().trim().equals(sortName)) {
                option.click();
            }
        }
    }

    public void setGenre(String genreName){
        driver.findElement(By.xpath(".//a[contains(text(),'"+genreName+"')]")).click();
    }

    public int getResultsCount() {
        int count = driver.findElements(By.xpath("//table[@class='chart']/tbody/tr[*]")).size();
        log.info("Count of rows in search results is " + count);
        return count;
    }

    public int getResultsCountAfterGenreSorting() {
        int count = driver.findElements(By.xpath("//table[@class='results']/tbody/tr[*]")).size();
        log.info("Count of rows in search results is " + count);
        return count;
    }

}
