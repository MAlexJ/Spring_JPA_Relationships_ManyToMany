package com.malex.service.impl;

import com.malex.model.Bank;
import com.malex.repository.BankRepository;
import com.malex.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 23.02.16.
 */
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository repository;

    @Override
    public Bank save(Bank bank) {
        return repository.saveAndFlush(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return repository.saveAndFlush(bank);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Bank get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Bank> getAll() {
        return repository.findAll();
    }
}
