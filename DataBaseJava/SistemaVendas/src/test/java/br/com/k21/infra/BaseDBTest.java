package br.com.k21.infra;

import java.io.InputStream;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.hibernate.ejb.HibernateEntityManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendedorDAO;


public class BaseDBTest extends TestCase
{

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-test");

	// Inicializa antes de cada teste que for rodado... Se usasse @BeforeClass inicializaria antes da classe de testes
    @Before
    public void setUp()
    {
        InputStream testData = Vendedor.class.getResourceAsStream("/dados.xml");

        HibernateEntityManager em = (HibernateEntityManager) emf.createEntityManager();

        DbUnitDataLoader loader = new DbUnitDataLoader(testData, em.getSession().connection());

        try {
			loader.populateTestData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    @Test
    public void testGarantirInfraEstruturaTestesFuncionaParaBuscarUmaConexao()
    {
    	
        assertNotNull(emf.createEntityManager());
        
    }

    
    
	// Roda depois de Todo o teste da classe de testes que herda essa daqui 
    @AfterClass
    public void resetaEstadoBancoDados()
    {
        InputStream testData = Vendedor.class.getResourceAsStream("/dadosBackup.xml");

        HibernateEntityManager em = (HibernateEntityManager) emf.createEntityManager();

        DbUnitDataLoader loader = new DbUnitDataLoader(testData, em.getSession().connection());

        try {
			loader.populateTestData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
