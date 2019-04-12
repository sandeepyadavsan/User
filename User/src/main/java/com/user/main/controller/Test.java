package com.user.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usr")
public class Test {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String getdata() {
		return "hello";
	}
	@RequestMapping(value="/getUpdate",method=RequestMethod.GET)
	public String getUpdate() {
		return "hellobyebye";
	}
	
	@RequestMapping(value="/getDelete",method=RequestMethod.GET)
	public String getDelete() {
		return "hello";
	}

}
