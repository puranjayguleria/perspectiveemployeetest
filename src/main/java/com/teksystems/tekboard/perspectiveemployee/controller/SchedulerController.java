package com.teksystems.tekboard.perspectiveemployee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teksystems.tekboard.perspectiveemployee.model.perspectiveEmployeeDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/scheduler")
public class SchedulerController {
	ArrayList temp = new ArrayList();

	@GetMapping(value = "emails")
	public List getScheduledEmails() {
		// This method will return the email address of employees to whom the mail is to be sent.
		
		return temp;
	}
	
	@PostMapping(value = "updateEmailTrigger")
	public boolean setEmailTrigger( @RequestBody List<perspectiveEmployeeDetails> emails)
	{
		
		return true;
	}
	
	
}


