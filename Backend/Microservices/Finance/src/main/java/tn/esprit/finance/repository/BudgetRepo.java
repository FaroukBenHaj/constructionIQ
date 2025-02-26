package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.finance.entity.Budget;

import java.util.Optional;

@Repository
public interface BudgetRepo extends JpaRepository<Budget, Long> {
    // Recherche d'un budget par projet ID
    Optional<Budget> findByProjetId(String projetId);
}
