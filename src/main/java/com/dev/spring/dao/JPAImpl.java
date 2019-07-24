package com.dev.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.dev.spring.beans.User;

@Repository
public class JPAImpl implements UserDAO {
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");

	public Boolean createProfile(User user) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.merge(user);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//throw custom exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public User getUser(Integer userId) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, userId);
		em.close();
		return user;
	}

	@Override
	public User removeUser(Integer userId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, userId);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public Boolean updatePassword(Integer userId, String passwd) {
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			com.dev.spring.beans.User user = em.find(User.class, userId);
			user.setPassword(passwd);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}
}
