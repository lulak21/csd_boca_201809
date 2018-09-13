package br.com.k21;

import org.junit.Assert;
import org.junit.Test;

public class TestCommissionCalculator {

	@Test
	public void CommissionOn20000() {
		int SaleValue = 20000;
		int expectedResult = 1000;

		int result = Calculator.CalculateCommission(SaleValue);

		Assert.assertEquals(expectedResult, result);

	}
}