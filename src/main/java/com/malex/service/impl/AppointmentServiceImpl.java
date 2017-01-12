package com.malex.service.impl;

import com.malex.model.Appointment;
import com.malex.repository.AppointmentRepository;
import com.malex.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malex
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Appointment save(Appointment appointment) {
        return repository.saveAndFlush(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.saveAndFlush(appointment);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Appointment get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Appointment> getAll() {
        return repository.findAll();
    }
}
