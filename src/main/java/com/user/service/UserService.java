package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	List<User> getAllUser();
	void saveUser(User user);
	User getUserbyId(long id);
	void deletUser(long id);

}
