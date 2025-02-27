package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.finance.entity.TransactionFinanciere;
import java.util.List;

public interface TransactionFinanciereRepository extends JpaRepository<TransactionFinanciere, Long> {
    List<TransactionFinanciere> findByBudgetId(Long budgetId);
}
