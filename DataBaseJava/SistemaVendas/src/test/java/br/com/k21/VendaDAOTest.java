package br.com.k21;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testeVendedorInexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		vendedor.setId(999);
		int ano = 2017;		
		double valorTotalVendasEsperado = 0;
		double valorTotalRetornado;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		valorTotalRetornado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, ano);
		
		// asserts
		assertEquals(valorTotalVendasEsperado, valorTotalRetornado);		
	}
	
	@Test
	public void testeVendedorUmRetorna142() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1);
		int ano = 2016;		
		double valorTotalVendasEsperado = 142;
		double valorTotalRetornado;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		valorTotalRetornado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, ano);
		
		// asserts
		assertEquals(valorTotalVendasEsperado, valorTotalRetornado);		
	}
}
