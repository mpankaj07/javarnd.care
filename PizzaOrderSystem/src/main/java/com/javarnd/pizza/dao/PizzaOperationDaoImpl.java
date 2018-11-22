package com.javarnd.pizza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.javarnd.pizza.dbutility.HibernateUtility;
import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Order;
import com.javarnd.pizza.model.Topping;

@Component
public class PizzaOperationDaoImpl implements PizzaOperationDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.pizza.dao.PizzaOperationDao#getMenu()
	 */
	@Override
	public List<Menu> getMenu() throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Menu> criteria = builder.createQuery(Menu.class);
			Root<Menu> root = criteria.from(Menu.class);
			criteria.select(root);

			List<Menu> listOfPizza = entityManager.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return listOfPizza;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getAllBooks()");
			e.printStackTrace();
			return null;
		}

	}
	
	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.PizzaOperationDao#getToppingsMenu()
	 */
	@Override
	public List<Topping> getToppingsMenu() throws SQLException {
		
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Topping> criteria = builder.createQuery(Topping.class);
			Root<Topping> root = criteria.from(Topping.class);
			criteria.select(root);
			List<Topping> listOfToppings = entityManager.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return listOfToppings;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getAllBooks()");
			e.printStackTrace();
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.PizzaOperationDao#getPizzaById(java.lang.String)
	 */
	@Override
	public Menu getPizzaById(String pizzaId) throws SQLException {
		
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Menu> criteria = builder.createQuery(Menu.class);
			Root<Menu> root = criteria.from(Menu.class);
			criteria.select(root);

			Predicate condition = builder.and(builder.equal(root.get("pizzaid"), pizzaId));
			criteria.where(condition);

			Menu pizza = entityManager.createQuery(criteria).getSingleResult();

			session.getTransaction().commit();
			return pizza;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getBookById()");
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.PizzaOperationDao#getToppingById(int)
	 */
	@Override
	public Topping getToppingById(int toppingId) throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Topping> criteria = builder.createQuery(Topping.class);
			Root<Topping> root = criteria.from(Topping.class);
			criteria.select(root);

			Predicate condition = builder.and(builder.equal(root.get("toppingId"), toppingId));
			criteria.where(condition);

			Topping topping = entityManager.createQuery(criteria).getSingleResult();

			session.getTransaction().commit();
			return topping;
		} catch (HibernateException e) {
			session.close();
			System.out.println("HibernateException in getBookById()");
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.PizzaOperationDao#submitOrder(com.javarnd.pizza.model.Order)
	 */
	@Override
	public int submitOrder(Order order) throws SQLException {

		Session session = HibernateUtility.getSession();
		int orderId;
		try {
			session.beginTransaction();
			orderId = (Integer) session.save(order);
			session.getTransaction().commit();
			session.close();
			System.out.println("Check :" + orderId);
			return orderId;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in insertUser()");
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ResultSet getOrderByID() throws SQLException {
		
		// to Implement
		return null;
	}

}
