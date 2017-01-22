package com.malex.service.impl;

import com.malex.model.User;
import com.malex.repository.UserRepository;
import com.malex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malex
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public User get(int id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

   @Override
   public User getUserByEmail(String email) {
//      Map<String, Object> parameters = new HashMap<String, Object>();
//      parameters.put ("email", email);
//      User usr = find (User.class, "User.getByEmailOnly", parameters);
      return null;
   }

    @Override
    public User getUserIgnoreAppointment(String email) {
        return repository.getUserIgnoreAppointment(email);
    }

    @Override
    public User getUserWithAppointment(String email) {
        return repository.getUserWithAppointment(email);
    }
}
