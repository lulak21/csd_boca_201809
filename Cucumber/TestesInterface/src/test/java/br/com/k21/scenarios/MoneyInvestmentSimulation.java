package br.com.k21.scenarios;

import org.fluentlenium.adapter.FluentTest;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Quando;

public class MoneyInvestmentSimulation extends FluentTest {

	private WebDriver driver;

	@Before
	public void setUp()
	{
		
	}
	
	@Given("^I am on the main simulation page$")
	public void open_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://www.bb.com.br/portalbb/jsp/home/inst/popupFormSimulador.jsp?id=3");
	}

	@When("^I fill the screen inputs$")
	public void fill_data() throws Throwable {

		driver.findElement(By.cssSelector("input.valor1:nth-child(6)")).sendKeys("1000000,00");
		driver.findElement(By.cssSelector("input.valor1:nth-child(11)")).sendKeys("1,00");
		driver.findElement(By.cssSelector("input.valor1:nth-child(16)")).sendKeys("1,00");
		driver.findElement(By.cssSelector("input.valor1:nth-child(21)")).sendKeys("120");

		
	}

	@Quando("^click on the OK button$")
	public void click_ok_button() throws Throwable {
		driver.findElement(By.id("ok")).click();
	}

	@Then("^the page should show me the simulation results$")
	public void show_results() throws Throwable {
		driver.close();
		driver.quit();
	}
	
	@After
	public void tearDown(){
		//close, quit restore database
	}
}