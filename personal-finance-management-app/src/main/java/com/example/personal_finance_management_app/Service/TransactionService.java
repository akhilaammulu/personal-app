package com.example.personal_finance_management_app.Service;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.Transaction;
import com.example.personal_finance_management_app.Repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByBudget(ObjectId budgetId) {
        return transactionRepository.findByBudget_Id(budgetId);
    }

    public Transaction getTransactionById(ObjectId id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(ObjectId id, Transaction transaction) {
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(ObjectId id) {
        transactionRepository.deleteById(id);
    }
}
