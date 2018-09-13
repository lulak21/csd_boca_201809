package br.com.k21;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda
{
    @Id
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    
    private Double valor;
    
    private long vendedor_id;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public long getVendedorId() {
		return vendedor_id;
	}

	public void setVendedorId(long vendedorId) {
		this.vendedor_id = vendedorId;
	}

}
