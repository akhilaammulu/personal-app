package com.example.personal_finance_management_app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.Expense;
import com.example.personal_finance_management_app.Repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(String id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(String id, Expense expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
