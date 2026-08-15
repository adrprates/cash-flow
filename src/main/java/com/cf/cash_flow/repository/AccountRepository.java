package com.cf.cash_flow.repository;

import com.cf.cash_flow.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountNameContainingIgnoreCase(String accountName);
    List<Account> findByUserId(Long userId);
    boolean existsByAccountNameAndUserId(String accountName, Long userId);
}