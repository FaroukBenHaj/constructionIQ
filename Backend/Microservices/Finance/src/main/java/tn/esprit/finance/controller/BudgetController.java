package tn.esprit.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.service.BudgetService;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Récupérer tous les budgets
    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgets = budgetService.getAllBudgets();
        return budgets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(budgets);
    }

    // Récupérer un budget par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Budget budget = budgetService.getBudget(id);
        return budget != null ? ResponseEntity.ok(budget) : ResponseEntity.notFound().build();
    }

    // Créer un nouveau budget
    @PostMapping("/addbudget")
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget createdBudget = budgetService.createBudget(budget);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBudget);
    }

    // Mettre à jour un budget
    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable long id, @RequestBody Budget budget) {
        Budget updatedBudget = budgetService.updateBudget(id, budget);
        return updatedBudget != null ? ResponseEntity.ok(updatedBudget) : ResponseEntity.notFound().build();
    }

    // Supprimer un budget
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable long id) {
        boolean isDeleted = budgetService.deleteBudget(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
