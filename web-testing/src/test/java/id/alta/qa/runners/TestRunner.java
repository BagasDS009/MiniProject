package id.alta.qa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "id.alta.qa.steps",
    plugin = {"pretty"},
    tags = "not @wip"
)
public class TestRunner {
}
