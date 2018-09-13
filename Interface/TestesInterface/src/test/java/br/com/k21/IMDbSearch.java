package br.com.k21;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class IMDbSearch extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Chromedriver/chromedriver.exe");
		return new ChromeDriver();
	}
	
	@Test
	public void lifeProjectSimulationTest() throws InterruptedException {
		goTo("http://www.imdb.com/");
		fill("#navbar-query").with("crazy rich asians");
		click("#navbar-submit-button");
		
		await().atMost(5000).until("#main > div > div.findSection > table > tbody > tr:nth-child(1) > td.result_text").isPresent();
		
		Assert.assertEquals("Podres de Ricos", $("#main > div > div.findSection > table > tbody > tr:nth-child(1) > td.result_text > a").getText());
	}
}
