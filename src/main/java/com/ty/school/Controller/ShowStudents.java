package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;

@WebServlet(value = "/showstudent")
public class ShowStudents extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentDao dao = new StudentDao();
		List<Student> students = dao.getAllStudents();

		PrintWriter printWriter = resp.getWriter();

		printWriter.write("<html><body><center><table border :3px cellpadding=3px callsapcing=3px>");
		printWriter.write("<tr><th colspan='5'>Student Details<th></tr>");
		printWriter.write("<tr>");
		printWriter.write("<th>Id</th>");
		printWriter.write("<th>Name</th>");
		printWriter.write("<th>Age</th>");
		printWriter.write("<th>Edit</th>");
		printWriter.write("<th>Delete</th>");
		printWriter.write("</tr>");

		for (Student s : students) {
			printWriter.write("<tr>");
			printWriter.write("<td>" + s.getId() + "</td>");
			printWriter.write("<td>" + s.getName() + "</td>");
			printWriter.write("<td>" + s.getAge() + "</td>");
			printWriter.write("<td><a href='edit?id=" + s.getId() + "'>Edit</a></td>");
			printWriter.write("<td><a href='delete?id=" + s.getId() + "'>Delete</a></td>");
			printWriter.write("</tr>");
		}
		printWriter.write("</table></center></body></html>");
	}

}
