package com.alpha.jsp;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getstudents")
public class GetStudents extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s1 = new Student(101,"ALLEN",21,234456,"PUNE");
		Student s2 = new Student(102,"KEVIN",22,234456,"HYD");
		Student s3 = new Student(103,"MARTIN",23,234456,"BNG");
		Student s4 = new Student(104,"SMITH",24,234456,"MUMBAI");
		
		List<Student> students = Arrays.asList(s1,s2,s3,s4);
		
		req.setAttribute("students", students);
		req.getRequestDispatcher("displaystudents.jsp").forward(req, resp);
	}

}
