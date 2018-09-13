package br.com.k21.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.k21.Vendedor;


public class VendedorDAO {
	
    @PersistenceContext(unitName = "JPA")
    private static EntityManager entityManager;

    
    public static Vendedor find(long id)
    {
        return entityManager.find(Vendedor.class, new Long(id));
    }
    
    public static void remove(long id){
    	entityManager.remove(find(id));
    }
    
    public static List<Vendedor> findVendedorByNome(String nome){
    	Query q = entityManager.createQuery("select v from Vendedor v where v.nome = :paramNome");
    	
    	q.setParameter("paramNome", nome);
    
    	List<Vendedor> lista = q.getResultList();
    	return lista;
    }
    
    public static EntityManager getEntityManager()
    {
        return entityManager;
    }

    public static void setEntityManager(EntityManager entityManager)
    {
    
    	VendedorDAO.entityManager = entityManager;
    }

}
