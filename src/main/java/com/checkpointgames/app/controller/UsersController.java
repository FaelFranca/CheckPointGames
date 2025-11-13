
package com.checkpointgames.app.controller;

import com.checkpointgames.app.entity.Users;
import com.checkpointgames.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    public Users saveUser(@Valid @RequestBody Users user){
        return userService.saveUser(user);
    }
    
}
