package com.javarnd.pizza.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.javarnd.pizza.dbutility.HibernateUtility;
import com.javarnd.pizza.model.User;

@Component
public class UserDaoImpl implements UserDao {
	
	
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String sql;
	
	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.UserDao#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User authenticateUser(String loginName, String password) throws SQLException {
		
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			// creating the entity manager
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			// Query Construction :
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			criteria.select(root);
			// adding where clause
			Predicate condition = builder.and(builder.equal(root.get("userName"), loginName),
					builder.equal(root.get("password"), password));
			criteria.where(condition);
			// quering the table
			User user = entityManager.createQuery(criteria).getSingleResult();
			System.out.println("Check :" + user.getName());
			session.getTransaction().commit();
			session.close();
			return user;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in authenticateUser()");
			e.printStackTrace();
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.UserDao#insertUser(com.javarnd.pizza.model.User)
	 */
	@Override
	public int insertUser(User user) throws SQLException {
		
		Session session = HibernateUtility.getSession();
		int userId;
		try {
			session.beginTransaction();
			userId = (Integer) session.save(user);
			session.getTransaction().commit();
			session.close();
			System.out.println("Check :" + userId);
			return userId;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in insertUser()");
			e.printStackTrace();
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.UserDao#updateUser(com.javarnd.pizza.model.User)
	 */
	@Override
	public int updateUser(User user) throws SQLException {
		// To Do
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.UserDao#deleteUser(int)
	 */
	@Override
	public int deleteUser(User user) throws SQLException {
		
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			return 1;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in deleteUser()");
			e.printStackTrace();
			return 0;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.dao.UserDao#blockUser(java.lang.String)
	 */
	@Override
	public int blockUser(String mobileNumber) throws SQLException {
		
		User user = this.getUserByUserByPhoneNumber(mobileNumber);
		user.setStatus("B");
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			session.close();
			return 1;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in deleteUser()");
			e.printStackTrace();
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.javarnd.library.dao.UserDao#getUserByUserName(java.lang.String)
	 * Method to get the User by passing the Phone Number
	 */
	public User getUserByUserByPhoneNumber(String phoneNumber) throws SQLException {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			// creating the entity manager
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			// Query Construction :
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> root = criteria.from(User.class);
			criteria.select(root);
			// adding where clause
			Predicate condition = builder.and(builder.equal(root.get("mobileNumber"), phoneNumber));
			criteria.where(condition);
			// quering the table
			User user = entityManager.createQuery(criteria).getSingleResult();
			System.out.println("Check :" + user.getName());
			session.getTransaction().commit();
			session.close();
			return user;
		} catch (HibernateException e) {
			session.clear();
			System.out.println("HibernateException in authenticateUser()");
			e.printStackTrace();
			return null;
		}
	}


}
