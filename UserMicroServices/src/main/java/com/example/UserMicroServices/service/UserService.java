package com.example.UserMicroServices.service;

import com.example.UserMicroServices.entity.User;
import com.example.UserMicroServices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User postUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User getUserById(@PathVariable Long id){
       return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id,User user){
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser=optionalUser.get();
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            existingUser.setPhone(user.getPhone());
            return userRepository.save(existingUser);
        }
        return null;
    }

}
