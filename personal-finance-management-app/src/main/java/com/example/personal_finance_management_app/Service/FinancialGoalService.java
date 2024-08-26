package com.example.personal_finance_management_app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.FinancialGoal;
import com.example.personal_finance_management_app.Repository.FinancialGoalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialGoalService {

    @Autowired
    private FinancialGoalRepository financialGoalRepository;

    public List<FinancialGoal> getAllFinancialGoals() {
        return financialGoalRepository.findAll();
    }

    public Optional<FinancialGoal> getFinancialGoalById(String id) {
        return financialGoalRepository.findById(id);
    }

    public FinancialGoal createFinancialGoal(FinancialGoal financialGoal) {
        return financialGoalRepository.save(financialGoal);
    }

    public FinancialGoal updateFinancialGoal(String id, FinancialGoal financialGoal) {
        financialGoal.setId(id);
        return financialGoalRepository.save(financialGoal);
    }

    public void deleteFinancialGoal(String id) {
        financialGoalRepository.deleteById(id);
    }
}
