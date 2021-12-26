package org.hua.dit.dsproject.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    public String idNumber;
    public String userName;
    public String password;
    public boolean active;
    public List<SimpleGrantedAuthority> grantedAuthorities;



    public MyUserDetails() {
    }

    public MyUserDetails(ApplicationUser applicationUser){
        this.idNumber = applicationUser.getIdNumber();
        this.userName = applicationUser.getUsername();
        this.password = applicationUser.getPassword();
        this.active = applicationUser.isActive();
        this.grantedAuthorities = Arrays.stream(applicationUser.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
