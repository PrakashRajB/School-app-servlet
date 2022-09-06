package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.school.dto.Student;
import com.ty.school.dto.User;

public class UserDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public List<User> showAllUsers() {
		String jqpl = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jqpl);
		List<User> users = query.getResultList();

		return users;

	}

}
