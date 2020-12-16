package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
				glue= {"Functional"},
				tags= "@Run",
				monochrome= true,
				plugin = { "pretty", "html:target/reports"}
		)
public class TestRunner {

}
