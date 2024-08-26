package com.example.personal_finance_management_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.RecurringTransaction;
import com.example.personal_finance_management_app.Service.RecurringTransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/recurring-transactions")
public class RecurringTransactionController {

    @Autowired
    private RecurringTransactionService service;

    @GetMapping
    public List<RecurringTransaction> getAllRecurringTransactions() {
        return service.getAllRecurringTransactions();
    }

    @PostMapping
    public RecurringTransaction addRecurringTransaction(@RequestBody RecurringTransaction transaction) {
        return service.addRecurringTransaction(transaction);
    }
}
