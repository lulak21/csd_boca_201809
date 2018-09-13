package br.com.k21;

import java.util.List;

import br.com.k21.dao.SalesRepository;
import br.com.k21.model.Sale;

public class RoyaltiesCalculator {
	
	
	public double calculate(int month, int year, SalesRepository salesRepo) { 
		
		double totalSales = 0;
		double totalCommission = 0;
		List<Sale> sales = salesRepo.getSales(year, month);
		for (Sale sale : sales) {
			totalSales += sale.getValue();
			totalCommission += CommissionCalculator.calcular(sale.getValue());
		}
		
		return .2 * (totalSales - totalCommission);
	}
	
public double calculate(int month, int year, SalesRepository salesRepo) { 
		
		double totalSales = 0;
		double totalCommission = 0;
		List<Sale> sales = salesRepo.getSales(year, month);
		for (Sale sale : sales) {
			totalSales += sale.getValue();
			totalCommission += CommissionCalculator.calcular(sale.getValue());
		}
		
		return .2 * (totalSales - totalCommission);
	}
}
