package com.user.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.main.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	

}
