package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.TeacherDao;
import com.ty.school.dto.Student;
import com.ty.school.dto.Teacher;

@WebServlet(value = "/showteachers")
public class ShowTeachers extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TeacherDao dao = new TeacherDao();
		List<Teacher> teachers = dao.showAllTeachers();

		PrintWriter printWriter = resp.getWriter();

		printWriter.write("<html><body><center><table border :3px cellpadding=3px callsapcing=3px>");
		printWriter.write("<tr><th colspan='5'>Teacher Details<th></tr>");
		printWriter.write("<tr>");
		printWriter.write("<th>Id</th>");
		printWriter.write("<th>Name</th>");
		printWriter.write("<th>Age</th>");
		printWriter.write("<th>Edit</th>");
		printWriter.write("<th>Delete</th>");
		printWriter.write("</tr>");

		for (Teacher teacher : teachers) {
			printWriter.write("<tr>");
			printWriter.write("<td>" + teacher.getId() + "</td>");
			printWriter.write("<td>" + teacher.getName() + "</td>");
			printWriter.write("<td>" + teacher.getAge() + "</td>");
			printWriter.write("<td><a href='editteacher?id=" + teacher.getId() + "'>Edit</a></td>");
			printWriter.write("<td><a href='deleteteacher?id=" + teacher.getId() + "'>Delete</a></td>");
			printWriter.write("</tr>");
		}
		printWriter.write("</table></center></body></html>");

	}

}
