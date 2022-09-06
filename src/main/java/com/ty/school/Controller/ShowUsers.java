package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.UserDao;
import com.ty.school.dto.User;

@WebServlet(value = "/showusers")
public class ShowUsers extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printWriter = resp.getWriter();

		UserDao dao = new UserDao();
		List<User> users = dao.showAllUsers();

		printWriter.write("<html><body><center><table border :3px cellpadding=3px callsapcing=3px>");
		printWriter.write("<tr><th colspan='9'>User Details<th></tr>");
		printWriter.write("<tr>");
		printWriter.write("<th>Id</th>");
		printWriter.write("<th>Name</th>");
		printWriter.write("<th>Email</th>");
		printWriter.write("<th>Password</th>");
		printWriter.write("<th>Gender</th>");
		printWriter.write("<th>Address</th>");
		printWriter.write("<th>Country</th>");
		printWriter.write("<th>Edit</th>");
		printWriter.write("<th>Delete</th>");
		printWriter.write("</tr>");

		for (User user : users) {
			printWriter.write("<tr>");
			printWriter.write("<td>" + user.getId() + "</td>");
			printWriter.write("<td>" + user.getName() + "</td>");
			printWriter.write("<td>" + user.getEmail() + "</td>");
			printWriter.write("<td>" + user.getPassword() + "</td>");
			printWriter.write("<td>" + user.getGender() + "</td>");
			printWriter.write("<td>" + user.getAddress() + "</td>");
			printWriter.write("<td>" + user.getCountry() + "</td>");
			printWriter.write("<td><a href='edituser?id=" + user.getId() + "'>Edit</a></td>");
			printWriter.write("<td><a href='deleteuser?id=" + user.getId() + "'>Delete</a></td>");
			printWriter.write("</tr>");
		}
		printWriter.write("</table></center></body></html>");
	}

}
