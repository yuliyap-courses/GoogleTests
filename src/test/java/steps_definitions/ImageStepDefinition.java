package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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

    @Before
    public void openGoogle(Scenario scenario){

        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.by/");
        this.driver = driver;

    }

    @Given("I  based on Google page")
    public void iBasedOnGooglePage() {
        driver.findElement(By.xpath("//*[contains(text(), 'Картинки')]"));
    }

    @When("I click to Image link")
    public void iClickToImageLink() {
        WebElement ImageLink = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[contains(text(), 'Картинки')]")));
        ImageLink.click();
    }

    @Then("I based on GoogleImage")
    public void iBasedOnGoogleImage(){
        String result = "Картинки";
        WebElement ImageLogo = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(
                        (By.xpath("//div[contains(@class, 'logo-subtext'"))));
                ImageLogo.isDisplayed();
        String actualResult= driver.findElement(By.xpath("//div[contains(@class, 'logo-subtext')]")).getText();
        Assert.assertEquals(actualResult, result, "Картинки");
    }

    @After
    public void closeDriver(Scenario scenario){
        driver.close();
    }


}

