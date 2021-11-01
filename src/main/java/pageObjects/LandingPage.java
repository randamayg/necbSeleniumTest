package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class LandingPage {


    public WebDriver driver;
    HashMap<String, Integer> listOfIcons = new HashMap<String, Integer>();
    ;
    String acceptCookiesSelector = "cmpbntyestxt";
    String articlesTitleSelector = "h2.story";
    String submitPollSelector = "#pollBooth .btn-polls";
    String pollParent = "#pollBooth label";
    //please note, I had a random method to select random item between 1 and 8,
    // but my selector didn't work with nth-child. Hence I had to do this
    String firstPollOption = "input:nth-child(1)";
    String iconSelector =  "span.topic";


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage openLandingPage(){
        driver.get("http://www.slashdot.org/");
        return new LandingPage(driver);
    }
    public void closeCookiePopUp() {
        driver.findElement(By.id(acceptCookiesSelector)).click();
    }

    public int getNumberOfArticlesOnPage() {
        return driver.findElements(By.cssSelector(articlesTitleSelector)).size();
    }

    public void getNumberOfIconsOnPage() {
        List<WebElement> elements = driver.findElements(By.cssSelector(iconSelector));

        for (WebElement element : elements) {
            String iconName = element.getAttribute("id");

            if (listOfIcons.containsKey(iconName)) {
                int number = listOfIcons.get(iconName);
                listOfIcons.put(iconName, number + 1);
            } else {
                listOfIcons.put(iconName, 1);
            }
        }
    }

    public void printListOfIconsOnPage() {
        for (Object icon : listOfIcons.keySet()) {
            System.out.println("Icon name: " + icon + " -  Number of times appears on page: "
                    + listOfIcons.get(icon));
        }
    }

    private int randomNumberBetween1to8() {
        Random randomGenerator=new Random();
        return randomGenerator.nextInt(8) + 1;
    }

    public PollBoothPage voteForPoll() {
        WebElement parent = driver.findElement(By.cssSelector(pollParent));
        // please note, I had a random method to select random item between 1 and 8,
        // but my selector didn't work with nth-child. Hence I had to do this
        // original code:
        //  int randomNumber = randomNumberBetween1to8();
        // and use the randomNumber to select the :nth-child  of the poll selector,
        // but it wasn't selecting the correct element so I change it select the first

        parent.findElement(By.cssSelector(firstPollOption)).click();

        driver.findElement(By.cssSelector(submitPollSelector)).click();
        return new PollBoothPage(driver);
    }


}
