package br.com.k21.scenarios;

import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Quando;

public class IMdb extends FluentTest {

	private WebDriver driver;

	@Given("^I am on the movie page$")
	public void i_am_on_the_movie_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C://Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://www.imdb.com/");
	}

	@When("^I enter \"([^\"]*)\" movie name$")
	public void i_enter_movie_name(String movieName) throws Throwable {

		driver.findElement(By.cssSelector("#navbar-query")).sendKeys(movieName);
	}

	@When("^click on the movie search button$")
	public void click_on_the_movie_search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the page should show me the movie results$")
	public void the_page_should_show_me_the_movie_results() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}