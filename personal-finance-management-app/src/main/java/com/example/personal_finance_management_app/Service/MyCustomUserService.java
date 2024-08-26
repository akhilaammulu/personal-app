package com.example.personal_finance_management_app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Exceptions.UserNotFoundException;
import com.example.personal_finance_management_app.Model.MyCustomUser;
import com.example.personal_finance_management_app.Repository.MyCustomUserRepository;

@Service
public class MyCustomUserService {
	@Autowired
	  private MyCustomUserRepository userRepository;

	  

	    // Retrieve all users
	    public List<MyCustomUser> getAllUsers() {
	        return userRepository.findAll();
	    }

	    // Retrieve a user by ID
	    public MyCustomUser getUserById(String id) {
	        Optional<MyCustomUser> user = userRepository.findById(id);
	        if (user.isPresent()) {
	            return user.get();
	        } else {
	            throw new UserNotFoundException("User not found with ID: " + id);
	        }
	    }

	    // Create a new user
	    public MyCustomUser createUser(MyCustomUser user) {
	        return userRepository.save(user);
	    }

	    // Update an existing user
	    public MyCustomUser updateUser(String id, MyCustomUser user) {
	        if (!userRepository.existsById(id)) {
	            throw new UserNotFoundException("User not found with ID: " + id);
	        }
	        user.setId(id);
	        return userRepository.save(user);
	    }

	    // Delete a user
	    public void deleteUser(String id) {
	        if (!userRepository.existsById(id)) {
	            throw new UserNotFoundException("User not found with ID: " + id);
	        }
	        userRepository.deleteById(id);
	    }
} 