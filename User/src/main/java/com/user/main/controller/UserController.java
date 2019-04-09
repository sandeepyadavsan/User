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
import com.user.main.exception.UserNotFoundException;
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
		
		Optional<User> user = userRepository.findById(usrid);
		if(!user.isPresent())
			throw new UserNotFoundException("User is not exist in the system: "+usrid);
		
		return user;
	
	}
	
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET)
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
		
	}
	@RequestMapping(value="/delUser/{usrid}",method=RequestMethod.DELETE)
	public Optional<User> deleteUser(@PathVariable Integer usrid) {

		
		Optional<User> user=userRepository.findById(usrid);
		
		if(!user.isPresent())
			throw new UserNotFoundException("User Id Not Found For Deletion: "+usrid);
		
		userRepository.deleteById(usrid);
		return user;
		
	}

}
