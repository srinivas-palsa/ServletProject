package com.alpha.school;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher")
public class TeacherReq extends HttpServlet {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("srinivas");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		double salary = Double.parseDouble(req.getParameter("salary"));
		long phone = Long.parseLong(req.getParameter("phone"));
		
		Teacher t = new Teacher(name, subject, salary, phone);

		et.begin();

		em.persist(t);

		et.commit();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			long phone = Long.parseLong(req.getParameter("phone"));
			String query = "select t from Teacher t where phone=:phn";
			Teacher t = (Teacher) em.createQuery(query).setParameter("phn", phone).getSingleResult();

			et.begin();

			
			if (t != null) {
				resp.getWriter().println("NAME: " + t.getName());
				resp.getWriter().println("SUBJECT: " + t.getSubject());
				resp.getWriter().println("SALARY: " + t.getSalary());
			} 
		}
		catch(NoResultException e) {
			resp.getWriter().println("NO TEACHER FOUND");
		}
		catch (Exception e) {
			resp.getWriter().println("INVALID INPUT");
		}
		et.commit();

	}

}
