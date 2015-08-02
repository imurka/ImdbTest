package test.com.imdb.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.steps.Top250PageSteps;
import test.steps.WebSteps;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ирина on 02.08.2015.
 */
public class ImdbChartGenreTest {
    WebDriver driver;
    WebSteps webSteps;
    Top250PageSteps top250PageSteps;

    @DataProvider(name = "genre")
    public static Object[][] query() {
        return new Object[][] {{"Western"}};
    }

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://www.imdb.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webSteps = new WebSteps(driver);
    }

    @AfterClass
    public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "genre")
    public void verifySearchResultsWithGenre(String genreName) throws InterruptedException {
        top250PageSteps = webSteps.goToTop250Page();
        Assert.assertTrue(top250PageSteps.verifyGenreSearchResults(genreName));
    }

}
