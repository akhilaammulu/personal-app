package com.example.personal_finance_management_app.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.FinancialGoal;

public interface FinancialGoalRepository extends MongoRepository<FinancialGoal, String> {
    // Custom query methods can be added here if needed
}
