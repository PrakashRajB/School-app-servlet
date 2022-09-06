package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.TeacherDao;
import com.ty.school.dto.Teacher;

@WebServlet(value = "/saveteacher")
public class SaveTeacher extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("myName");
		String a = req.getParameter("myAge");
		int age = Integer.parseInt(a);

		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setAge(age);

		TeacherDao dao = new TeacherDao();
		Teacher teacher2 = dao.saveTeacher(teacher);

		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h1>Data Received And Saved Id=" + teacher.getId() + "</h1>");
		writer.write("</body></html>");

	}

}
