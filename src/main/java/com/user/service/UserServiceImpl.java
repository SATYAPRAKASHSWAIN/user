package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);

	}

	@Override
	public User getUserbyId(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
		}else {
			throw new RuntimeException("User not found for this id");
		}
		return user;
	}

	@Override
	public void deletUser(long id) {
		this.userRepository.deleteById(id);
		
	}

}
