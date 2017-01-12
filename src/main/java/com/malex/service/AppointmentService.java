package com.malex.service;

import com.malex.model.Appointment;

import java.util.List;

/**
 * @author malex
 */
public interface AppointmentService {

    Appointment save(Appointment appointment);

    Appointment update(Appointment appointment);

    void delete(Long id);

    Appointment get(Long id);

    List<Appointment> getAll();
}
