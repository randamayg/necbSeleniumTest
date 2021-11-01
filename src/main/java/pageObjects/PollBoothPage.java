package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollBoothPage {

    public WebDriver driver;
    //See explanation on LandingPage class why this is the hardcoded to first element
    String pollBoothVotes  =  ".poll-bar-text:nth-child(1)";

    public PollBoothPage(WebDriver driver){
        this.driver = driver;
    }

    public String getNumberOfVotes(){
        String numberVotes = driver.findElement(By.cssSelector(pollBoothVotes)).getText();
        return returnNumberOfVotes(numberVotes);
    }

    public String returnNumberOfVotes(String votesSentence) {
        String numberOfVotes = votesSentence.substring(0, votesSentence.indexOf(" "));
        return numberOfVotes;
    }
}


