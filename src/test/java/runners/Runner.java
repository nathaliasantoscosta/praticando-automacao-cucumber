package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/removerItemSacola.feature",
        glue = "steps",
        plugin = "pretty",
        tags = "@RemoverItemSacolaStep",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        strict = true
)

public class Runner {

}
