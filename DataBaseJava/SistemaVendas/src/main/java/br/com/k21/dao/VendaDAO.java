package br.com.k21.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.k21.Venda;
import br.com.k21.Vendedor;

public class VendaDAO {
	
    @PersistenceContext(unitName = "JPA")
    private static EntityManager entityManager;

    
    public static Venda find(long id)
    {
        return entityManager.find(Venda.class, new Long(id));
    }
    

    public static void remove(long id){
    	entityManager.remove(find(id));
    }
    
    public static EntityManager getEntityManager()
    {
        return entityManager;
    }

    public static void setEntityManager(EntityManager entityManager)
    {
    	VendaDAO.entityManager = entityManager;
    }


	public static double buscarTotalDeVendasPorVendedorEAno(
			Vendedor vendedor,
			int ano) {
		Query q = entityManager.createNativeQuery(
				"select sum(v.valor) " +
				"from venda v " +
				"where v.vendedor_id = :paramIdVendedor"); 

		q.setParameter("paramIdVendedor",vendedor.getId());
    	Object o = q.getSingleResult();
    	if(o == null)
    		return 0;
    	
    	Double valor = (Double) o;
    	return valor;
 	}


}
