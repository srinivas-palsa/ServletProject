package com.alpha.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//accessing the req
@WebServlet("/test")
public class Test extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("THIS IS TEST 1 REQUEST");
		
		// we are reading the data from req
		String name = req.getParameter("name");
		int age =Integer.parseInt(req.getParameter("age"));
		
		
		//Processing on the data -> business logic
		String result = "MY NAME IS: "+name+" AND MY AGE IS: "+age;
		
		PrintWriter pw = res.getWriter();
		pw.print("<h1 style=color:red>"+result+"</h1>");
		
		
	}

}
