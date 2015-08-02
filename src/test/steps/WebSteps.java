package test.steps;

import org.openqa.selenium.WebDriver;
import test.pages.ImdbMainPage;
import test.pages.Top250Page;

/**
 * Created by Ирина on 02.08.2015.
 */
public class WebSteps {
    WebDriver driver;
    ImdbMainPage imdbMainPage;

    public WebSteps(WebDriver driver){
        this.driver = driver;
        imdbMainPage = new ImdbMainPage(driver);
    }

    public Top250PageSteps goToTop250Page(){
        return new Top250PageSteps(driver);
    }
}
