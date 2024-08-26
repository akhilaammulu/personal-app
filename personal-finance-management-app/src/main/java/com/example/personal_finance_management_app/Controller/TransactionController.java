package com.example.personal_finance_management_app.Controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.Transaction;
import com.example.personal_finance_management_app.Service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/budget/{budgetId}")
    public List<Transaction> getTransactionsByBudget(@PathVariable ObjectId budgetId) {
        return transactionService.getTransactionsByBudget(budgetId);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable ObjectId id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable ObjectId id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable ObjectId id) {
        transactionService.deleteTransaction(id);
    }
}
