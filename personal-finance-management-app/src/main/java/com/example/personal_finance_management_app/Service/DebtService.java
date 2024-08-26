package com.example.personal_finance_management_app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.Debt;
import com.example.personal_finance_management_app.Repository.DebtRepository;

import java.util.List;

@Service
public class DebtService {

    @Autowired
    private DebtRepository repository;

    public List<Debt> getAllDebts() {
        return repository.findAll();
    }

    public Debt addDebt(Debt debt) {
        return repository.save(debt);
    }

    public Debt updateDebt(String id, Debt debt) {
        return repository.findById(id)
                .map(existingDebt -> {
                    existingDebt.setName(debt.getName());
                    existingDebt.setPrincipalAmount(debt.getPrincipalAmount());
                    existingDebt.setInterestRate(debt.getInterestRate());
                    existingDebt.setRemainingBalance(debt.getRemainingBalance());
                    existingDebt.setDueDate(debt.getDueDate());
                    return repository.save(existingDebt);
                })
                .orElseThrow(() -> new RuntimeException("Debt not found with id " + id));
    }

    public void deleteDebt(String id) {
        repository.deleteById(id);
    }
}
