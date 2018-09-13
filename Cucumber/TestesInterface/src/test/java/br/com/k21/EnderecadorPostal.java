package br.com.k21;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnderecadorPostal extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	@Test
	public void testeEmitirUmaEtiqueta() {
		abrirPaginaDoEnderecador();
		preencherCEP_Remetente("82030340");
		
		preencherNomeEPromocao_Remetente("Dina S/A", "promo");
	
		preencherNumero_Remetente("165");
		
		
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(4) > label > input[type='text']:nth-child(3)").with("80002900");
	
		click("body");
		await().atMost(3000).until("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(4) > label > input").isPresent();
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(6) > label > input").with("Blá Blá Blá");
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(7) > label > input").with("Promo");
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(10) > label > input").with("100");
		
		click("#btGerarEtiquetas");
	}


	@Test
	public void testeEmitirUmaEtiqueta2() {
		abrirPaginaDoEnderecador();
		preencherCEP_Remetente("82030340");
		
		preencherNomeEPromocao_Remetente("Dina2 S/A", "promo");
	
		preencherNumero_Remetente("165");
		
		
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(4) > label > input[type='text']:nth-child(3)").with("80002900");
	
		click("body");
		await().atMost(3000).until("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(4) > label > input").isPresent();
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(6) > label > input").with("Blá Blá Blá");
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(7) > label > input").with("Promo");
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(11) > div > span:nth-child(10) > label > input").with("100");
		
		click("#btGerarEtiquetas");
	}

	
	
	
	private void preencherNumero_Remetente(String numero) {
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(8) > label > input").with(numero);
	}

	private void preencherNomeEPromocao_Remetente(String nome, String promo) {
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(4) > label > input").with(nome);
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(5) > label > input").with(promo);
	}

	private void preencherCEP_Remetente(String cep) {
		fill("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > p > span > label > input[type='text']:nth-child(2)").with(cep);
		click("body");
		await().atMost(3000).until("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > form > div:nth-child(9) > div > span:nth-child(4) > label > input").isPresent();
	}

	private void abrirPaginaDoEnderecador() {
		goTo("http://correios.com.br");

		click("#content-principais-servicos > ul > li:nth-child(6) > a");
		click("body > div.back > div.tabs > div:nth-child(2) > div > div > div.column2 > div.content > div.ctrlcontent > p:nth-child(4) > a:nth-child(1)");
	}
}
