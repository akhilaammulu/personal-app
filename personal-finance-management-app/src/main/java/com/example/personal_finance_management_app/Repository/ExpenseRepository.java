package com.example.personal_finance_management_app.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    // Custom query methods can be added here if needed
}
