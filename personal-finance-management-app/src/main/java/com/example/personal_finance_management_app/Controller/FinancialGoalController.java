package com.example.personal_finance_management_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.FinancialGoal;
import com.example.personal_finance_management_app.Service.FinancialGoalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/financial-goals")
public class FinancialGoalController {

    @Autowired
    private FinancialGoalService financialGoalService;

    @GetMapping
    public List<FinancialGoal> getAllFinancialGoals() {
        return financialGoalService.getAllFinancialGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialGoal> getFinancialGoalById(@PathVariable String id) {
        Optional<FinancialGoal> financialGoal = financialGoalService.getFinancialGoalById(id);
        return financialGoal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FinancialGoal> createFinancialGoal(@RequestBody FinancialGoal financialGoal) {
        FinancialGoal createdGoal = financialGoalService.createFinancialGoal(financialGoal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialGoal> updateFinancialGoal(@PathVariable String id, @RequestBody FinancialGoal financialGoal) {
        FinancialGoal updatedGoal = financialGoalService.updateFinancialGoal(id, financialGoal);
        return ResponseEntity.ok(updatedGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialGoal(@PathVariable String id) {
        financialGoalService.deleteFinancialGoal(id);
        return ResponseEntity.noContent().build();
    }
}
