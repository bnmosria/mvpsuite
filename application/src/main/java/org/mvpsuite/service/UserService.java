package org.mvpsuite.service;

import lombok.extern.slf4j.Slf4j;
import org.mvpsuite.entity.User;
import org.mvpsuite.exception.DuplicatedUserNameException;
import org.mvpsuite.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        User existingUser = userRepository.existsByUsername(user.getUserName());

        if (existingUser != null) {
            throw new DuplicatedUserNameException();
        }

        userRepository.save(user);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
