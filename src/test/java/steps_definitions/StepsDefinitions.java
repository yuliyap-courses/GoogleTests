package steps_definitions;

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

    WebDriver driver;


    @Given("^I  open Google page$")
    public void iOpenGooglePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.close();

    }

    @When("I enter {string} on search field")
    public void iEnterMinskOnSearchField(String string) {
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
        driver.close();
       }

    @When("^I click to Search button$")
    public void iClickToSearchButton()  {
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
        driver.close();
    }


    @Then("^I can see  result of search$")
    public void iCanSeeResultOfSearch() {
        String result = "Минск — Википедия";

        this.driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement SearchField = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")));
        SearchField.sendKeys("Minsk");
        SearchField.sendKeys(Keys.ENTER);

        String actualResult= driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/a/h3/span")).getText();
        Assert.assertEquals(actualResult, result, "Минск — Википедия");
        driver.close();
    }
}
