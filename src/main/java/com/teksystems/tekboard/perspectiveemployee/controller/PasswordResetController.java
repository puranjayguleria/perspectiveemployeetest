package com.teksystems.tekboard.perspectiveemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teksystems.tekboard.perspectiveemployee.model.perspectiveEmployeeDetails;
import com.teksystems.tekboard.perspectiveemployee.service.PasswordResetService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/passwordreset")
public class PasswordResetController {
	// dont know how token is going to be managed so leaving it for now
	@Autowired 
	private PasswordResetService passwordresetservice;
	@GetMapping("employee/{perspectiveEmployeeEmail}")
	//public List
	
	public List<perspectiveEmployeeDetails> getDetailsByEmail(@PathVariable("perspectiveEmployeeEmail") String email, perspectiveEmployeeDetails Pemployee) {
		
		// create service class first
		
		Pemployee.setEmail(email);
		return passwordresetservice.getDetailsByEmail(Pemployee);
		
		
	}
	
	@PutMapping("employee/updatepassword/{id}")
	public boolean setEmployeePassword(@RequestBody(required = false) perspectiveEmployeeDetails Pemployee,@PathVariable("id") int id) {
		System.out.println(Pemployee);
		Pemployee.setId(id);
		
		return passwordresetservice.setEmployeeFirstPassword(Pemployee);
	}

}
