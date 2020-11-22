package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StepsDefinitions {

   protected WebDriver driver;

    @Before
    public void openGoogle(Scenario scenario){

        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
        this.driver = driver;
    }

    @Given("^I  open Google page$")
    public void iOpenGooglePage() {
        driver.findElement(By.xpath("//div[contains(@class, 'pR49Ae gsfi')]"));

    }

    @When("I enter {string} on search field")
    public void iEnterMinskOnSearchField(String string) {
        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
       }

    @When("^I click to Search button$")
    public void iClickToSearchButton()  {
        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
    }


    @Then("^I can see  result of search$")
    public void iCanSeeResultOfSearch() throws InterruptedException {
        String result = "Минск — Википедия";

        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
        SearchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String actualResult= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span")).getText();
        Assert.assertEquals(actualResult, result, "Минск — Википедия");

    }

    @After
    public void closeDriver(Scenario scenario){
        driver.close();
    }
}
