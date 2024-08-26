package com.example.personal_finance_management_app.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.MyCustomUser;
import com.example.personal_finance_management_app.Service.MyCustomUserService;


@RestController
@RequestMapping("/api/users")
public class MyCustomUserController {

    @Autowired
    private MyCustomUserService userService;

    @GetMapping
    public ResponseEntity<List<MyCustomUser>> getAllUsers() {
        List<MyCustomUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyCustomUser> getUserById(@PathVariable String id) {
        MyCustomUser user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MyCustomUser> createUser(@RequestBody MyCustomUser user) {
        MyCustomUser createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MyCustomUser> updateUser(@PathVariable String id, @RequestBody MyCustomUser user) {
        MyCustomUser updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  
}