package ru.sokolov.pricelist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ru.sokolov.pricelist.models.Product;

public class ProductDaoImpl implements ProductDao {
	
	private EntityManagerFactory emf;
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * @return List<{@link}Product> with all database entries
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT p FROM Product p");
		//Add limit for ResultList size
		query.setFirstResult(0);
		query.setMaxResults(50);
		List<Product> products = (List<Product>) query.getResultList();
		
		em.close();
		
		return products;
	}
	
	/**
	 * @param reqParameters describe the appropriate entries in database
	 * @return List<{@link}Product> with only appropriate database entries
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAppropriate(ReqParameters reqParameters) {
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT p FROM Product p WHERE "
				+ "p.cat.name LIKE :productCathegory AND "
				+ "p.name LIKE :productName AND "
				+ "p.price >= :productMinPrice AND "
				+ "p.price <= :productMaxPrice");
		
		query.setParameter("productCathegory", reqParameters.getProductCathegory()+"%");
		query.setParameter("productName", reqParameters.getProductName()+"%");
		query.setParameter("productMinPrice", "".equals(reqParameters.getProductMinPrice()) ? 0.0 : Double.parseDouble(reqParameters.getProductMinPrice()));
		query.setParameter("productMaxPrice", "".equals(reqParameters.getProductMaxPrice()) ? Double.MAX_VALUE : Double.parseDouble(reqParameters.getProductMaxPrice()));
		//Add limit for ResultList size
		query.setFirstResult(0);
		query.setMaxResults(50);
		
		List<Product> products = (List<Product>) query.getResultList();
		
		em.close();
		
		return products;
	}
}
