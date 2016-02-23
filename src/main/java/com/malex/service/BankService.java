package com.malex.service;

import com.malex.model.Bank;

import java.util.List;

/**
 * Created by malex on 23.02.16.
 */
public interface BankService {

    Bank save(Bank bank);

    Bank update(Bank bank);

    void delete(Long id);

    Bank get(Long id);

    List<Bank> getAll();

}
