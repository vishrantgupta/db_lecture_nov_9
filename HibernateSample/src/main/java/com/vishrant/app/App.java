package com.vishrant.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.vishrant.database.HibernateUtil;
import com.vishrant.database.NIUEmployee;

public class App {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("Is connected: " + session.isConnected());
		
		// session.beginTransaction();

		NIUEmployee emp = session.get(NIUEmployee.class, 1L);
		System.out.println(emp);
		
		// why use criteria? // it removes db dependency and Hibernate will 
		// generate optimized query based on selected dialect  
		
//		Criteria criteria = session.createCriteria(NIUEmployee.class);
//		List<NIUEmployee> employes = criteria
//				.add(Restrictions.ge("salary", 1000F)).list();
		
		session.close();

		System.out.println("Is connected: " + session.isConnected());

		System.exit(0);
		// session.getTransaction().commit();
	}
}
