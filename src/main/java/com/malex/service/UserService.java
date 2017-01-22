package com.malex.service;

import com.malex.model.User;

import java.util.List;

/**
 * @author malex
 */
public interface UserService {

    User save(User user);

    User update(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();

    User getUserByEmail(String email);

    User getUserIgnoreAppointment(String email);

    User getUserWithAppointment(String email);
}
