package org.hua.dit.dsproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/list")
    public List<User> getUser() {
        return userService.listAllUsers();
    }

    @PostMapping(path = "/users/new")
    public void newUser(@RequestBody User user) {
        userService.newUser(user);
    }

    @DeleteMapping(path = "/users/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "/users/modify/{id}")
    public void modifyUser(@PathVariable("id") int id, @RequestParam(required = false) String username, @RequestParam(required = false) String password) {
        userService.updateUser(id, username, password);
    }
}
