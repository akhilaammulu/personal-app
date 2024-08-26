package com.example.personal_finance_management_app.Service;

import com.example.personal_finance_management_app.Model.Budget;
import com.example.personal_finance_management_app.Repository.BudgetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudgetById(ObjectId id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(ObjectId id, Budget budget) {
        budget.setId(id);
        return budgetRepository.save(budget);
    }

    public void deleteBudget(ObjectId id) {
        budgetRepository.deleteById(id);
    }
}
