package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.school.dto.Teacher;
import com.ty.school.dto.User;

public class TeacherDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Teacher saveTeacher(Teacher teacher) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();

		return teacher;
	}

	public List<Teacher> showAllTeachers() {
		String jqpl = "SELECT t FROM Teacher t";
		Query query = entityManager.createQuery(jqpl);
		List<Teacher> teachers = query.getResultList();

		return teachers;

	}

}
