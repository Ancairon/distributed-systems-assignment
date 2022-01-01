package org.hua.dit.dsproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(path = "/users/list")
    public List<User> getUser() {
        return userDetailsService.listAllUsers();
    }

    @PostMapping(path = "/users/new")
    public void newUser(@RequestBody User user) {
        userDetailsService.newUser(user);
    }

    @PostMapping(path = "/users/modify")
    public void modifyUser(@RequestBody User user) {
        userDetailsService.userRepository.deleteById(user.getIdNumber());
        userDetailsService.newUser(user);
    }

    @PostMapping(path = "/users/delete")
    public void deleteUser(@RequestBody User user) {
        userDetailsService.userRepository.deleteById(user.getIdNumber());
    }
}
