package com.alpha.school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/registerstudent")
public class RegisterStudentReq extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name =req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		
//		System.out.println(name+" "+age+" "+phone+" "+address);
		
		Student s = new Student(name,age,phone,address);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("srinivas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(s);
		
		et.commit();
				
		
		PrintWriter pw = res.getWriter();
		pw.print("<h1>Registration Successful</h1>");
	}

}
