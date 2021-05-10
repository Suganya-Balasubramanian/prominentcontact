package com.sample.pc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.pc.service.Main1Service;

@RestController
public class Main1Controller{
	
	@Autowired
	Main1Service main1Service;
	
	@GetMapping("/")
	public String save(){
		main1Service.save();
		return "User Saved";
	}
}
