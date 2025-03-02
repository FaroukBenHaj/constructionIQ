package tn.esprit.finance.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.service.BudgetService;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import tn.esprit.finance.entity.Budget;
//import tn.esprit.finance.service.BudgetService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/budgets")
//public class BudgetController {
//
//    @Autowired
//    private BudgetService budgetService;
//
//    @GetMapping
//    public List<Budget> getAllBudgets() {
//        return budgetService.getAllBudgets();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
//        Optional<Budget> budget = budgetService.getBudgetById(id);
//        return budget.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Budget createBudget(@RequestBody Budget budget) {
//        return budgetService.createBudget(budget);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budgetDetails) {
//        return ResponseEntity.ok(budgetService.updateBudget(id, budgetDetails));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
//        budgetService.deleteBudget(id);
//        return ResponseEntity.noContent().build();
//    }
@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

//    @PostMapping
//    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
//        return ResponseEntity.ok(budgetService.createBudget(budget));
//    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@Valid @RequestBody Budget budget) {
        Budget newBudget = budgetService.createBudget(budget);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBudget);
    }


    @GetMapping("/{projectId}")
    public ResponseEntity<Optional<Budget>> getBudget(@PathVariable String projectId) {
        return ResponseEntity.ok(budgetService.findByProjectId(projectId));
    }
}


