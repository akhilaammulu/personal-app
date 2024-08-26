package com.example.personal_finance_management_app.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.SavingsAccount;
import com.example.personal_finance_management_app.Repository.SavingsAccountRepository;

import java.util.List;

@Service
public class SavingsAccountService {

    @Autowired
    private SavingsAccountRepository repository;

    public List<SavingsAccount> getAllSavingsAccounts() {
        return repository.findAll();
    }

    public SavingsAccount addSavingsAccount(SavingsAccount account) {
        return repository.save(account);
    }

    public SavingsAccount updateSavingsAccount(String id, SavingsAccount account) {
        return repository.findById(id)
                .map(existingAccount -> {
                    existingAccount.setAccountName(account.getAccountName());
                    existingAccount.setBalance(account.getBalance());
                    existingAccount.setInterestRate(account.getInterestRate());
                    return repository.save(existingAccount);
                })
                .orElseThrow(() -> new RuntimeException("Savings account not found with id " + id));
    }

    public void deleteSavingsAccount(String id) {
        repository.deleteById(id);
    }
}
