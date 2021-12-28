package org.hua.dit.dsproject.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Define our repository
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
    Optional<ApplicationUser> findByUserName(String username);
}