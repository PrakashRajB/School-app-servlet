package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;
@WebServlet(value="/savestudent")
public class SaveStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("myName");
		String age = req.getParameter("myAge");

		int recAge = Integer.parseInt(age);

		Student student = new Student();
		student.setName(name);
		student.setAge(recAge);

		StudentDao dao = new StudentDao();
		dao.saveStudent(student);

		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><body><h1>Data Recieved and Saved Id is "+student.getId()+"</h1></body></html>");

	}

}
