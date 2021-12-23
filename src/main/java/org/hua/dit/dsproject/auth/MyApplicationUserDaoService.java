package org.hua.dit.dsproject.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import static org.hua.dit.dsproject.security.ApplicationUserRole.*;
import static org.hua.dit.dsproject.security.ApplicationUserPermission.*;
import java.util.List;
import java.util.Optional;

@Repository("test")
public class MyApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUserList = Lists.newArrayList(
                new ApplicationUser("evangelos", passwordEncoder.encode("mypassword"), CITIZEN.getGrantedAuthorities(), true, true, true, true),
                new ApplicationUser("fotis", passwordEncoder.encode("mypassword"), ADMIN.getGrantedAuthorities(), true, true, true, true)

                );
        return applicationUserList;
    }
}
