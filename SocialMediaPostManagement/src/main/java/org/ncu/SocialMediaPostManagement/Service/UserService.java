package org.ncu.SocialMediaPostManagement.Service;

import org.ncu.SocialMediaPostManagement.Entity.User;
import org.ncu.SocialMediaPostManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public int registerUser(User user) {
        return userRepository.addUser(user);
    }

    public boolean loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.map(user -> user.getPassword().equals(password)).orElse(false);
    }
}

