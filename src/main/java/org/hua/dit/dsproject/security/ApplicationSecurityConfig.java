package org.hua.dit.dsproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/pets/**").hasRole(ApplicationUserRole.CITIZEN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails evangelos = User.builder().username("evangelos").password(passwordEncoder.encode("mypassword")).roles(ApplicationUserRole.CITIZEN.name()).build();
        UserDetails administrator = User.builder().username("admin").password(passwordEncoder.encode("mypassword")).roles(ApplicationUserRole.ADMIN.name()).build();
        UserDetails fotis = User.builder().username("fotis").password(passwordEncoder.encode("mypassword")).roles(ApplicationUserRole.CITIZEN.name()).build();

        return new InMemoryUserDetailsManager(evangelos,administrator,fotis);
    }
}
