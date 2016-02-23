package com.malex.repository;

import com.malex.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by malex on 23.02.16.
 */
public interface EmpliyeeRepository extends JpaRepository<Employee, Long> {
}
