package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.finance.entity.Budget;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByProjetId(String projetId);
}
