package steps_definitions;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class ImageStepDefinition {
    WebDriver driver;

    @BeforeStep
    public void openGoogle(Scenario scenario){
        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.by/imghp?hl=ru&tab=wi&ogbl");
        this.driver = driver;

    }
    @Given("I  based on Google Image page")
    public void iBasedOnGoogleImagePage() {
        driver.findElement
                (By.xpath("//*[@id='hplogo']/div/span"));
    }

    @When("I find search field")
    public void iFindSearchField() {
        //driver.get("https://www.google.by/imghp?hl=ru&tab=wi&ogbl");
        WebElement SearchField = new WebDriverWait(driver, 90)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        (By.xpath("//*[@id='sbtc']/div/div[2]/input"))));
        SearchField.isDisplayed();
    }

    @Then("I based on GoogleImage")
    public void iBasedOnGoogleImage(){
       // driver.get("https://www.google.by/imghp?hl=ru&tab=wi&ogbl");
        String result = "Картинки";
        WebElement ImageLogo = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(
                        (By.xpath("//*[@id='hplogo']/div/span"))));
                ImageLogo.isDisplayed();
        String actualResult= driver.findElement(By.xpath("//*[@id='hplogo']/div/span")).getText();
        Assert.assertEquals(actualResult, result, "Картинки");
    }

    @AfterStep
    public void closeDriver(Scenario scenario){
        driver.close();
    }

}

//https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
 //https://qna.habr.com/q/630942