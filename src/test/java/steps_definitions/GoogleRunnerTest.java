package steps_definitions;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        monochrome = true,
        features = "src/test/resources/search.feature",
        snippets = SnippetType.CAMELCASE,
        glue = {"steps_definitions"}

)
public class GoogleRunnerTest {
}
