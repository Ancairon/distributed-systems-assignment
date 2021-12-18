package org.hua.dit.dsproject.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String helloWorld() {
        User myuser = new User(123, "username1", "password1");
        return myuser.toString();
    }
}
