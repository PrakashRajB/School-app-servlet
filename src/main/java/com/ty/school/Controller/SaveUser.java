package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.school.dao.UserDao;
import com.ty.school.dto.User;

@WebServlet(value="/saveuser")
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = new User();
		user.setName(req.getParameter("myName"));
		user.setEmail(req.getParameter("myEmail"));
		user.setPassword(req.getParameter("myPassword"));
		user.setGender(req.getParameter("gender"));
		user.setCountry(req.getParameter("myCountry"));
		user.setAddress(req.getParameter("myAddress"));
		
		UserDao dao=new UserDao();
		User user2=dao.saveUser(user);
		
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("<html><body><center>");
		printWriter.write("<h1>Data Received and Saved Id ="+user2.getId()+"</h1</center></body></html>");

	}
}
