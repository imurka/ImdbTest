package test.steps;

import org.openqa.selenium.WebDriver;
import test.pages.Top250Page;

/**
 * Created by Èğèíà on 02.08.2015.
 */
public class Top250PageSteps extends WebSteps{
    Top250Page top250Page;

    public Top250PageSteps(WebDriver driver){
        super(driver);
        top250Page = imdbMainPage.navigateToTop250();
    }

    public boolean verifySortingSearchResults(String sortName) {
        top250Page.setSorting(sortName);
        return verifySearchResultsIsPresent();
    }

    public boolean verifyGenreSearchResults(String genreName){
        top250Page.setGenre(genreName);
        return verifySearchResultsAfterGenreSorting();
    }

    public boolean verifySearchResultsIsPresent() {
       if (top250Page.getResultsCount() >= 1) {
           return true;
       } else
           return false;
    }

    public boolean verifySearchResultsAfterGenreSorting() {
        if (top250Page.getResultsCountAfterGenreSorting() >= 1) {
            return true;
        } else
            return false;
    }

}
