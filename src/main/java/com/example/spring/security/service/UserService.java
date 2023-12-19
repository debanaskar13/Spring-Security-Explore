package com.example.spring.security.service;

import com.example.spring.security.entities.User;
import com.example.spring.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepo;
    private PasswordEncoder encoder;


    public List<User> getUsers(){
        return this.userRepo.findAll();
    }
    public User createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User getSingleUser(long userId){
        return this.userRepo.findById(userId).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    public User updateUser(long userId,User user){
        User user1 = this.userRepo.findById(userId).orElseThrow(()->new UsernameNotFoundException("User not found"));
        user1.setUsername(user.getUsername());
        return this.userRepo.save(user1);
    }

    public void deleteUser(long userId){
        this.userRepo.findById(userId).orElseThrow(()->new UsernameNotFoundException("User not found"));
        this.userRepo.deleteById(userId);
    }
}
