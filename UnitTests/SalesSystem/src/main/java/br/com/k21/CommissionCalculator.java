package br.com.k21;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommissionCalculator {

	public static BigDecimal getCommission(BigDecimal sale) {

		if (sale.doubleValue() > 10000) {
			return sale.multiply(new BigDecimal("0.06")).setScale(2, RoundingMode.FLOOR);
		}

		return sale.multiply(new BigDecimal(0.05)).setScale(2, RoundingMode.FLOOR);
	}

}
