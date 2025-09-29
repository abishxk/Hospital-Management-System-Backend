package com.hexahealth.controller;

import com.hexahealth.model.User;
import com.hexahealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
                /*
                    {
                        "username" : "",
                        "password" : ""
                    }
                 */
        try{
            return ResponseEntity.ok(userService.save(user));
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
