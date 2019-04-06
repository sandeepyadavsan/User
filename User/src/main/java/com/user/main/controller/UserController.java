package com.user.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.main.domain.User;
import com.user.main.repository.UserRepository;

@RestController
@RequestMapping(value="/usr")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/setUser",method=RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		String status="Updated";
		if(user.getId()==null || user.getId().equals(""))
			status="Created";
		userRepository.save(user);
		return status;
		
	}
	
	@RequestMapping(value="/getUser/{usrid}",method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Integer usrid) {
		
		return userRepository.findById(usrid);
		/*System.out.println("Id: "+usrid);
		User usr=new User();
				usr.setId(1);
				usr.setName("Manish");
				usr.setEmail("manishp2@kpit.com");
		return usr;*/
	}
	
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET)
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
		
	}
	@RequestMapping(value="/delUser/{usrid}",method=RequestMethod.DELETE)
	public Optional<User> deleteUser(@PathVariable Integer usrid) {

		
		Optional<User> user=userRepository.findById(usrid);
		userRepository.deleteById(usrid);
		return user;
		
	}

}
