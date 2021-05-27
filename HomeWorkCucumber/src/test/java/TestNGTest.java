import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java"
)
public class TestNGTest extends AbstractTestNGCucumberTests {
}

