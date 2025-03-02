package tn.esprit.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.finance.entity.Invoice;
import tn.esprit.finance.entity.Projet;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByProjectId(Projet projectId);
}
