package com.example.onlinelms.usermanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.onlinelms.usermanagement.entity.User;
import com.example.onlinelms.usermanagement.exception.UserException;
import com.example.onlinelms.usermanagement.service.UserService;

@RestController
@RequestMapping
public class UserController {
	final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(User user) throws UserException {
		User u = userService.addUser(user);
		return new ResponseEntity<>(u, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> fetchAllUsers() throws UserException {
		List<User> listOfUsers = userService.fetchAllUser();

		return new ResponseEntity<List<User>>(listOfUsers, HttpStatus.FOUND);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id) throws UserException {
		User user = userService.fetchUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws UserException {
		String responceMessage = userService.deleteUser(id);
		return new ResponseEntity<>(responceMessage, HttpStatus.OK);

	}
	
	@GetMapping("/pagination")
	public Page<User> fetchAllUsers(@RequestParam(defaultValue = "0") int pageNo,
                                    @RequestParam(defaultValue = "3") int noOfUsers){
		return userService.findAll(pageNo, pageNo);
		
	}
	@GetMapping("/sort")
	public List<User> findAllUsers(@RequestParam (required = false,defaultValue = "name") String sortBy,
			                       @RequestParam (required = false,defaultValue = "asc")  String sortDirection){
		 Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
		 Sort sort = Sort.by(direction, sortBy);
		List<User> ListofUsersSortedByAscendingOrder=userService.findAll(sort);
		return ListofUsersSortedByAscendingOrder;
	}
}
