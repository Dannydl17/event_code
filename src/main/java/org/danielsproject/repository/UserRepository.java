package org.danielsproject.repository;

import org.danielsproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    User findUserByEmail(String email);

}
