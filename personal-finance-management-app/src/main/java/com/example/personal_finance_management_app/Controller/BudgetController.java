package com.example.personal_finance_management_app.Controller;

import com.example.personal_finance_management_app.Model.Budget;
import com.example.personal_finance_management_app.Service.BudgetService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/{id}")
    public Budget getBudgetById(@PathVariable ObjectId id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.createBudget(budget);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable ObjectId id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable ObjectId id) {
        budgetService.deleteBudget(id);
    }
}
