package com.example.personal_finance_management_app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.SavingsAccount;
import com.example.personal_finance_management_app.Service.SavingsAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/savings-accounts")
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService service;

    @GetMapping
    public List<SavingsAccount> getAllSavingsAccounts() {
        return service.getAllSavingsAccounts();
    }

    @PostMapping
    public SavingsAccount addSavingsAccount(@RequestBody SavingsAccount account) {
        return service.addSavingsAccount(account);
    }

    @PutMapping("/{id}")
    public SavingsAccount updateSavingsAccount(@PathVariable String id, @RequestBody SavingsAccount account) {
        return service.updateSavingsAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteSavingsAccount(@PathVariable String id) {
        service.deleteSavingsAccount(id);
    }
}
