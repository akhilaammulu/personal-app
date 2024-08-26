package com.example.personal_finance_management_app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.Debt;
import com.example.personal_finance_management_app.Service.DebtService;

import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtController {

    @Autowired
    private DebtService service;

    @GetMapping
    public List<Debt> getAllDebts() {
        return service.getAllDebts();
    }

    @PostMapping
    public Debt addDebt(@RequestBody Debt debt) {
        return service.addDebt(debt);
    }

    @PutMapping("/{id}")
    public Debt updateDebt(@PathVariable String id, @RequestBody Debt debt) {
        return service.updateDebt(id, debt);
    }

    @DeleteMapping("/{id}")
    public void deleteDebt(@PathVariable String id) {
        service.deleteDebt(id);
    }
}
