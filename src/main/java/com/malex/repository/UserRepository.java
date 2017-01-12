package com.malex.repository;

import com.malex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author malex
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
