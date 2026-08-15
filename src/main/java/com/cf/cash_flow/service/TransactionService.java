package com.cf.cash_flow.service;

import com.cf.cash_flow.model.Transaction;
import com.cf.cash_flow.repository.TransactionRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> listAllByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        Transaction transaction = null;
        if (optionalTransaction.isPresent()) {
            transaction = optionalTransaction.get();
        } else{
            throw new RuntimeException("Transaction not found by id: " +id);
        }
        return transaction;
    }

    public List<Transaction> listFilter(Specification<Transaction> specification) {
        return  transactionRepository.findAll(specification);
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }
}