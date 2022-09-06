package com.ty.school.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/delete")
public class DeleteStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");
		
		int id=Integer.parseInt(i);

		PrintWriter writer = resp.getWriter();

		writer.write("<html><body>");
		writer.write("<h1>Delete Student By ID = " + id + "</h1>");
		writer.write("</body></html>");
	}
}
