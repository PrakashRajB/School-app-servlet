package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.*;

import com.ty.school.dto.Student;

public class StudentDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Student saveStudent(Student student) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		return student;
	}

	public List<Student> getAllStudents() {
        String jqpl="SELECT s FROM Student s";
        Query query=entityManager.createQuery(jqpl);
        List<Student> students  = query.getResultList();
		
		return students;
	}

}
