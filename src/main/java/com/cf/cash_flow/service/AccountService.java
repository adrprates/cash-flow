package com.cf.cash_flow.service;

import com.cf.cash_flow.model.Account;
import com.cf.cash_flow.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account>listAll(){
        return accountRepository.findAll();
    }

    public Account save(Account account){
        if(accountRepository.existsByAccountNameAndUserId(account.getName(),  account.getUser().getId())){
            throw new RuntimeException("Account already exists by account name.");
        }
        return accountRepository.save(account);
    }

    public Account getById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account account = null;
        if(optionalAccount.isPresent()){
            account = optionalAccount.get();
        } else{
            throw new RuntimeException("Account not found by id " + id);
        }
        return account;
    }

    public List<Account> listByName(String accountName){
        return accountRepository.findByAccountNameContainingIgnoreCase(accountName);
    }

    public List<Account> listByUserId(Long userId){
        return accountRepository.findByUserId(userId);
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }
}