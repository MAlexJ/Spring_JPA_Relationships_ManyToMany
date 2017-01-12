package com.malex.repository;

import com.malex.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author malex
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
