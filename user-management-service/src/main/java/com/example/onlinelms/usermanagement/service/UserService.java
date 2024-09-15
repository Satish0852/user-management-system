package com.example.onlinelms.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinelms.usermanagement.entity.User;
import com.example.onlinelms.usermanagement.exception.UserException;
import com.example.onlinelms.usermanagement.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User fetchUserById(Long id) throws UserException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserException("User with id " + id + " was not found"));
	}

	@Override
	public List<User> fetchAllUser() throws UserException {
		List<User> listOfUsers = userRepository.findAll();
		if (listOfUsers.isEmpty()) {
			throw new UserException("Users are empty");
		}
		return listOfUsers;
	}

	@Override
	public User addUser(User user) throws UserException {
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) throws UserException {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.orElseThrow(() -> new UserException("user with " + id + "was not found"));
		userRepository.delete(user);
		return "user has been deleted Successfully";
	}

}
