package org.mvpsuite.controller;

import org.mvpsuite.model.User;
import org.mvpsuite.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> user() {
        List<User> users = userService.getUsers();

        return ResponseEntity.ok(users);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object user(@RequestBody User user) {
        userService.addUser(user);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public Object user(@PathVariable("id") UUID id) {
        Optional<User> user = userService.getUserById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound();
        }

        return ResponseEntity.ok(user);
    }

}