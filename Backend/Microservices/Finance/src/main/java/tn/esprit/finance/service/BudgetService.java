package tn.esprit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.repository.BudgetRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepo budgetRepo;

    // Récupérer un budget par son ID
    public Budget getBudget(Long id) {
        return budgetRepo.findById(id).orElse(null);
    }

    // Ajouter un budget (Create)
    public Budget createBudget(Budget budget) {
        return budgetRepo.save(budget);
    }

    // Sauvegarder ou mettre à jour un budget (Save)
    public Budget saveBudget(Budget budget) {
        return budgetRepo.save(budget);
    }

    // Récupérer un budget par projet ID (avec recherche par projetId)
    public Budget getBudgetByProjet(String projetId) {
        return budgetRepo.findByProjetId(projetId).orElse(null);
    }

    // Récupérer tous les budgets (Read All)
    public List<Budget> getAllBudgets() {
        return budgetRepo.findAll();
    }

    // Mettre à jour un budget existant (Update)
    public Budget updateBudget(Long id, Budget budget) {
        Optional<Budget> existingBudget = budgetRepo.findById(id);
        if (existingBudget.isPresent()) {
            Budget updatedBudget = existingBudget.get();
            updatedBudget.setDescription(budget.getDescription());
            updatedBudget.setMontant(budget.getMontant());
            updatedBudget.setDateBudget(budget.getDateBudget());
            return budgetRepo.save(updatedBudget);
        }
        return null;
    }



    // Supprimer un budget (Delete)
    public boolean deleteBudget(Long id) {
        Optional<Budget> existingBudget = budgetRepo.findById(id);
        if (existingBudget.isPresent()) {
            budgetRepo.delete(existingBudget.get());
            return true;
        }
        return false;
    }
}
