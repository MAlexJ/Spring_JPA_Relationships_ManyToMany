package com.malex.repository;

import com.malex.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by malex on 23.02.16.
 */
public interface BankRepository extends JpaRepository<Bank, Long> {
}
