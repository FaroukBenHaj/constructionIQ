package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.finance.entity.Facture;

@Repository
public interface FactureRepo extends JpaRepository<Facture, Long> {
}
