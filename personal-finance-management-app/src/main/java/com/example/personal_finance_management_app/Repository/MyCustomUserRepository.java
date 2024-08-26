package com.example.personal_finance_management_app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.MyCustomUser;

public interface MyCustomUserRepository extends MongoRepository<MyCustomUser, String> {

	
	    MyCustomUser findByEmail(String email); // or any other field you're using
	}

