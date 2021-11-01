import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PollBoothPage;

import java.io.IOException;

public class SlashdotTest extends Base {

    @BeforeMethod
    public void initiliazeTest() throws IOException {
        driver = initializeDriver();
    }

    @Test
    public void getNumberOfArticlesOnSlashdot() {
        //given I go to landing page
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openLandingPage();

        //and close the pop up
        landingPage.closeCookiePopUp();

        //Then I get the number of articles on the page
        int numberOfArticles = landingPage.getNumberOfArticlesOnPage();
        // and print it out
        System.out.println("Number of Articles on slash.org is " + numberOfArticles);
    }

    @Test
    public void printAllUniqueIconsOnPage() {
        //given I go to landing page
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openLandingPage();

        //and close the pop up
        landingPage.closeCookiePopUp();

        //When I get the number of unique icons on the page
        landingPage.getNumberOfIconsOnPage();

        //Then I can print them out
        landingPage.printListOfIconsOnPage();
    }

    @Test
    public void voteOnPoll() {
        //given I go to landing page
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openLandingPage();

        //and close the pop up
        landingPage.closeCookiePopUp();

        //When I vote on the poll for the page
        PollBoothPage pollBoothPage = landingPage.voteForPoll();

        //Then I can count how many other votes that poll got
        String numberOfVotes = pollBoothPage.getNumberOfVotes();
    }

    @AfterMethod
    public void closeBrowser() {
        closeDriver();
    }

}
