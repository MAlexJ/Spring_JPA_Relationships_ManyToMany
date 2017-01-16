package com.malex.service;

import com.malex.model.User;

import java.util.List;

/**
 * @author malex
 */
public interface UserService {

    User save(User user);

    User update(User user);

    void delete(Long id);

    User get(Long id);

    List<User> getAll();

   User getUserByEmail(String email);
}
