package com.malex.repository;

import com.malex.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author malex
 */
public interface UserRepository extends JpaRepository<User, Integer> {



    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserIgnoreAppointment(@Param("email") String email);

    @EntityGraph(value = User.USER_GRAPH, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserWithAppointment(@Param("email")String email);
}
