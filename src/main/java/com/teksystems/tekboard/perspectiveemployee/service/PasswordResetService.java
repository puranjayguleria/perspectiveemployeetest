package com.teksystems.tekboard.perspectiveemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teksystems.tekboard.perspectiveemployee.dao.PerspectiveEmployee_DAO_Imp;
import com.teksystems.tekboard.perspectiveemployee.model.perspectiveEmployeeDetails;
@Service
public class PasswordResetService {
	@Autowired
	private PerspectiveEmployee_DAO_Imp perspectiveemployeeDAO;
	
	public List<perspectiveEmployeeDetails> getDetailsByEmail(perspectiveEmployeeDetails employee)
	{
		return perspectiveemployeeDAO.getStudentByID(employee);
		
		
	}

	
	public boolean setEmployeeFirstPassword(perspectiveEmployeeDetails Pemp)
	{
		//create a dao method first
		
		return perspectiveemployeeDAO.updateEmployeeDetails(Pemp);
	}
}
