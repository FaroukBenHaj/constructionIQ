package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.finance.entity.Depense;

import java.util.List;

@Repository
public interface DepenseRepo extends JpaRepository<Depense, Long> {
    List<Depense> findByProjetId(Long projetId);
}
