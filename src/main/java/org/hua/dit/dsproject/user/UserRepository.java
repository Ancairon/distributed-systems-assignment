package org.hua.dit.dsproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Define our repository
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String username);
}