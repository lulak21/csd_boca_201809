package br.com.k21.model;

public class Sale {

	  public Sale(int id, int salesman, int month, int year, double saleValue)
      {
          saleId = id;
          salesmanId = salesman;
          saleMonth = month;
          saleYear = year;
          value = saleValue;
      }

      private  int saleId ;
      private  int salesmanId;
      private  int saleMonth ;
      private  int saleYear ;
      private  double value ;


    public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int idVenda) {
		this.saleId = idVenda;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int idVendedor) {
		this.salesmanId = idVendedor;
	}
	public int getSaleMonth() {
		return saleMonth;
	}
	public void setSaleMonth(int mesVenda) {
		this.saleMonth = mesVenda;
	}
	public int getSaleYear() {
		return saleYear;
	}
	public void setSaleYear(int anoVenda) {
		this.saleYear = anoVenda;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double valor) {
		this.value = valor;
	}


}
