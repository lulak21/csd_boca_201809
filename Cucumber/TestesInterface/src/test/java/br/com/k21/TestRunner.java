package br.com.k21;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { 
				"src/test/java/br/com/k21/features/SimulacaoDeAplicacaoNoBB.feature" 
				})
public class TestRunner {

}