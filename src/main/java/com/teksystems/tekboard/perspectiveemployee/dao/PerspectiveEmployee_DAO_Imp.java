package com.teksystems.tekboard.perspectiveemployee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teksystems.tekboard.perspectiveemployee.model.perspectiveEmployeeDetails;


@Repository
@Transactional

public class PerspectiveEmployee_DAO_Imp {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<perspectiveEmployeeDetails> getStudentByID(perspectiveEmployeeDetails PEmployee) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query= currentSession.createQuery("from perspectiveEmployeeDetails where email=:employee_email");
		query.setParameter("employee_email", PEmployee.getEmail());
		List<perspectiveEmployeeDetails> list=(List<perspectiveEmployeeDetails>)query.list();
		System.out.println(PEmployee.getEmail());
		return list;
		
	}
	
	public boolean updateEmployeeDetails(perspectiveEmployeeDetails Pemp)
	{
		// This method can be reused for all updates as we are passing object here which can contain any update information regarding 
		// any attribute.
		boolean status=false;
		try {
			int count=0;
			Session currentSession = sessionFactory.getCurrentSession();
			Query query= currentSession.createQuery("from perspectiveEmployeeDetails where id=:employee_id");
			query.setParameter("employee_id", Pemp.getId());
			List<perspectiveEmployeeDetails> list=(List<perspectiveEmployeeDetails>)query.list();
			for(perspectiveEmployeeDetails empdetails : list) {
				empdetails.setPassword(Pemp.getPassword());
				sessionFactory.getCurrentSession().update(empdetails);
				status=true;
				count++;
				System.out.println("For loop ran for "+ count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	

}
