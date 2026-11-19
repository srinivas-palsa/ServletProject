package com.alpha.school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/findstudent")
public class FindStudentReq extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("srinivas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		long phone = Long.parseLong(req.getParameter("phone"));
		
		String query = "select s from Student s where phone=:ph";
		
//		Query q = em.createQuery(query);
//		q.setParameter("ph", phone);
//		Object o =q.getSingleResult();
//		Student s = (Student) o;
		
		Student s = (Student) em.createQuery(query).setParameter("ph", phone).getSingleResult();
		
		if(s!=null) {
//			PrintWriter pw = res.getWriter();
//			pw.println("NAME: "+s.getName());
//			pw.println("AGE: "+s.getAge())
			res.getWriter().println("NAME: "+s.getName());
			res.getWriter().println("AGE: "+s.getAge());
			res.getWriter().println("ADDRESS: "+s.getAddress());
		}else {
			res.getWriter().println("Student not found");
		}
		
		
		et.commit();
		
	}

}
