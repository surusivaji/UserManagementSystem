package org.siva.usermanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.siva.usermanagement.model.User;

public class IUserDaoImpl implements IUserDao {

	@Override
	public List<User> displayAllUsers() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserManageementUsingHibernate");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			String query = "select user from User user";
			TypedQuery<User> typedQuery = manager.createQuery(query, User.class);
			List<User> list = typedQuery.getResultList();
			return list;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean insertUser(User user) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserManageementUsingHibernate");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			manager.close();
			factory.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User getUserById(int id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserManageementUsingHibernate");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			User user = manager.find(User.class, id);
			if (user!=null) {
				return user;
			}
			else {
				return null;
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int updateUserInformation(int userid, String firstname, String lastname, String mobile, String email,
			String gender, String address, String password) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserManageementUsingHibernate");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "UPDATE User user SET user.first_Name = :fname, user.last_Name = :lname, "
		                + "user.email_Id = :email, user.mobile_Number = :mobile, user.gender = :gender, "
		                + "user.address = :address, user.password = :password WHERE user.user_Id = :id";
		    Query query = manager.createQuery(jpql);
		    query.setParameter("fname", firstname);
		    query.setParameter("lname", lastname);
		    query.setParameter("email", email);
		    query.setParameter("mobile", mobile);
		    query.setParameter("gender", gender);
		    query.setParameter("address", address);
		    query.setParameter("password", password);
		    query.setParameter("id", userid);
			int executeUpdate = query.executeUpdate();
			transaction.commit();
			manager.close();
			factory.close();
			return executeUpdate;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteUserById(int id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserManageementUsingHibernate");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "delete from User user where user.user_Id=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("id", id);
			int update = query.executeUpdate();
			transaction.commit();
			manager.close();
			factory.close();
			return update;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
