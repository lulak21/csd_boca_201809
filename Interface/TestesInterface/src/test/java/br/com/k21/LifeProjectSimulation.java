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

public class LifeProjectSimulation extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Chromedriver/chromedriver.exe");
		return new ChromeDriver();
	}
	
	@Test
	public void lifeProjectSimulationTest() throws InterruptedException {
		goTo("http://www.brasilprev.com.br/realizeseusprojetosdevida_bp_html/home.aspx");
		fill("#txtNome").with("Lula");
		fill("#txtDataNascimento").with("16081988");
		click("#rdbMasculino");
		click("#rbtnMaiorDeIdade");
		click("#ibtnEnviar");
		
		Actions builder = new Actions(getDriver());

		Action dragAndDrop = builder.clickAndHold($("#boxSliderQndeAnosScroll_pointer").first().getElement())
		   .moveByOffset(100, 0)
		   .release()
		   .build();

		dragAndDrop.perform();
		
		click("#boxErro > div.bgErro > p:nth-child(5) > a > img");
		click("#boxNumber2Content > div > fieldset > label.lblSimplifica");

		fill("#txtValorMensal").with("1000000");
		fill("#txtValorInicial").with("200000");
		
		click("#ibtnSimular");
		
		await().atMost(5000).until("#txtValorTotalAcumulado").isPresent();
		
		Assert.assertEquals("R$ 40.883.210,31", $("#txtValorTotalAcumulado").getValue());
	}
}
