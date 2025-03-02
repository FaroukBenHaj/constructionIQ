package tn.esprit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.repository.BudgetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);

    }
    public Optional <Budget> findByProjectId(String projectId){
        return budgetRepository.findByProjectId(projectId);
    }

    public Budget updateBudget(Long id, Budget budgetDetails) {
        return budgetRepository.findById(id).map(budget -> {
            budget.setMontantRestant(budgetDetails.getMontantRestant());
            return budgetRepository.save(budget);
        }).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
