package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ирина on 02.08.2015.
 */
public class ImdbMainPage {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = ".//*[@id='navTitleMenu']/span")
    public WebElement moviesMenu;

    public ImdbMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Top250Page navigateToTop250() {
        new Actions(driver).moveToElement(moviesMenu).perform();
        driver.findElement(By.xpath("//a[contains(text(), 'Top 250')]")).click();
        return new Top250Page(driver);
    }
}
