package br.com.k21;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TestCommissionCalculator {

	@Test
	public void test_commission_10000_return_500() {
		BigDecimal sale = new BigDecimal("10000");
		BigDecimal expectedCommission = new BigDecimal("500.00");
		BigDecimal actualCommission;

		actualCommission = CommissionCalculator.getCommission(sale);

		Assert.assertEquals(expectedCommission, actualCommission);
	}

	@Test
	public void test_commission_10001_return_600_06() {
		BigDecimal sale = new BigDecimal("10001");
		BigDecimal expectedCommission = new BigDecimal("600.06");

		BigDecimal actualCommission;

		actualCommission = CommissionCalculator.getCommission(sale);

		Assert.assertEquals(expectedCommission, actualCommission);
	}

	@Test
	public void test_commission_10000_99_return_600_05() {
		BigDecimal sale = new BigDecimal("10000.99");
		BigDecimal expectedCommission = new BigDecimal("600.05");

		BigDecimal actualCommission;

		actualCommission = CommissionCalculator.getCommission(sale);

		Assert.assertEquals(expectedCommission, actualCommission);
	}

	@Test
	public void test_commission_9999_99_return_499_99() {
		BigDecimal sale = new BigDecimal("9999.99");
		BigDecimal expectedCommission = new BigDecimal("499.99");

		BigDecimal actualCommission = CommissionCalculator.getCommission(sale);

		Assert.assertEquals(expectedCommission, actualCommission);
	}

	@Test
	public void test_rounding_commission_55_59_return_2_77() {
		BigDecimal sale = new BigDecimal("55.59");
		BigDecimal expectedCommission = new BigDecimal("2.77");

		BigDecimal actualCommission;

		actualCommission = CommissionCalculator.getCommission(sale);

		Assert.assertEquals(expectedCommission, actualCommission);
	}

}