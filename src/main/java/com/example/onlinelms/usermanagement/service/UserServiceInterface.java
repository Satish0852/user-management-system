package com.example.onlinelms.usermanagement.service;



import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.example.onlinelms.usermanagement.entity.User;
import com.example.onlinelms.usermanagement.exception.UserException;

public interface UserServiceInterface {
	public User fetchUserById(Long id ) throws UserException;
	public List<User> fetchAllUser() throws UserException;
	public User addUser(User user) throws UserException;
	public String deleteUser(Long id) throws UserException;
    public Page<User> findAll(int pageNumber,int PageSize);
    public List<User> findAll(Sort sort);
}
