package com.example.spring.security.controller;

import com.example.spring.security.entities.User;
import com.example.spring.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping("/{user_id}")
    public User getSingleUser(@PathVariable("user_id") long userId){
        return this.userService.getSingleUser(userId);
    }

    @PutMapping("/{user_id}")
    public User updateUSer(@PathVariable("user_id") long userId,@RequestBody User user){
        return this.userService.updateUser(userId,user);
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable("user_id") long userId){
        this.userService.deleteUser(userId);
        return "User Deleted";
    }
}
