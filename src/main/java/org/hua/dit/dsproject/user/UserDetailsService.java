package org.hua.dit.dsproject.user;

import org.hua.dit.dsproject.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    //The service contains a repo and it can load a user by its username, returning a UserDetails object
    @Autowired
    UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> applicationUser = userRepository.findByUserName(username);

        applicationUser.orElseThrow(() -> new UsernameNotFoundException("There is no such user"));
        return applicationUser.map(UserDetails::new).get();
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


    public void newUser(User user) {
        userRepository.save(user);
    }

}