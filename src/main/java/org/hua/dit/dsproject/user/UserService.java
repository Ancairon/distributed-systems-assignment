package org.hua.dit.dsproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void newUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(int id, String username, String password){
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            User theUser = user.get();
            theUser.setUsername(username);
            theUser.setPassword(password);
        }
    }



}
