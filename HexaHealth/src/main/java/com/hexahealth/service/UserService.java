package com.hexahealth.service;

import com.hexahealth.model.User;
import com.hexahealth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User findById(int pid) {
        return userRepo.findById(pid).orElseThrow(()->new RuntimeException("User not found"));
    }
}
