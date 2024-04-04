package com.example.UserMicroServices.controller;

import com.example.UserMicroServices.entity.User;
import com.example.UserMicroServices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return (List<User>) userService.getAllUser();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User>  getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user == null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        if(updatedUser==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updatedUser);
    }
}
