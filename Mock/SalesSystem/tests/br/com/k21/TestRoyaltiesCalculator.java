package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.k21.dao.SalesRepository;
import br.com.k21.model.Sale;


public class TestRoyaltiesCalculator {

	@Before
	public void setUp()
	{
		SalesRepository sRepo = Mockito.mock(SalesRepository.class);		
	}
	
	@Test
	public void test_no_sales_return_0() {

		int month = 4;
		int year = 2018;
		int expectedRoyalties = 0;
		SalesRepository sRepo = new SalesRepository();
		
		double calculatedRoyalties = new RoyaltiesCalculator().calculate(month, year, sRepo);

		assertEquals(expectedRoyalties, calculatedRoyalties, 0);
	}
	
	@Test
	public void test_march_2018_9400() {
		
		int month = 3;
		int year = 2018;
		int expectedRoyalties = 9400;
		SalesRepository sRepo = Mockito.mock(SalesRepository.class);
		Mockito.when(sRepo.getSales(year, month)).thenReturn(Collections.singletonList(new Sale(1,1,month,year,50000)));
		
		
		double calculatedRoyalties = new RoyaltiesCalculator().calculate(month, year, sRepo);

		assertEquals(expectedRoyalties, calculatedRoyalties, 0);
	}

	@Test
	public void test_january_2018_19750() {

		int month = 1;
		int year = 2018;
		int expectedRoyalties = 19750;
		SalesRepository sRepo = new SalesRepository();
		
		double calculatedRoyalties = new RoyaltiesCalculator().calculate(month, year, sRepo);

		assertEquals(expectedRoyalties, calculatedRoyalties, 0);
	}

	@Test
	public void test_june_2018_1881_87() {

		int month = 6;
		int year = 2018;
		double expectedRoyalties = 1881.87;
		
		Mockito.when(sRepo.getSales(year, month)).thenReturn(Collections.singletonList(new Sale(1,1,month,year,10009.99)));
		
		
		double calculatedRoyalties = new RoyaltiesCalculator().calculate(month, year, sRepo);

		assertEquals(expectedRoyalties, calculatedRoyalties, 0);
	}
}
