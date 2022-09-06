package com.ty.school.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/deleteuser")
public class DeleteUser extends HttpServlet{
      
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");

		int id = Integer.parseInt(i);

		PrintWriter printWriter = resp.getWriter();
		
		printWriter.write("<html><body>");
		printWriter.write("<h1>Delete User By ID = "+id+"</h1>");
		printWriter.write("</body></html>");

	}

}
