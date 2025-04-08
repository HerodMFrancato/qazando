package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {},
        features = "src/test/resources/features", //Pasta aonde estão os arquivos features
        tags = {"˜@ignore"}, //Tudo que for diferente disso sera executado
        glue = "steps")

public class RunCucumberTest {
}
