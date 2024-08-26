package com.example.personal_finance_management_app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.RecurringTransaction;
import com.example.personal_finance_management_app.Repository.RecurringTransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecurringTransactionService {

    @Autowired
    private RecurringTransactionRepository repository;

    public List<RecurringTransaction> getAllRecurringTransactions() {
        return repository.findAll();
    }

    public RecurringTransaction addRecurringTransaction(RecurringTransaction transaction) {
        return repository.save(transaction);
    }

    public void processRecurringTransactions() {
        List<RecurringTransaction> transactions = repository.findAll();
        for (RecurringTransaction transaction : transactions) {
            if (transaction.getNextDate().isEqual(LocalDate.now()) || transaction.getNextDate().isBefore(LocalDate.now())) {
                // Logic to add a new transaction to the user's expenses
                // After processing, update the nextDate based on frequency
                switch (transaction.getFrequency()) {
                    case "monthly":
                        transaction.setNextDate(transaction.getNextDate().plusMonths(1));
                        break;
                    case "weekly":
                        transaction.setNextDate(transaction.getNextDate().plusWeeks(1));
                        break;
                    // Add more frequencies as needed
                }
                repository.save(transaction);
            }
        }
    }
}
