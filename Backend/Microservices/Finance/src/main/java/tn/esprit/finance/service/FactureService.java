package tn.esprit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.entity.Facture;
import tn.esprit.finance.repository.FactureRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private FactureRepo factureRepo;

    public List<Facture> getAllFactures() {
        return factureRepo.findAll();
    }

    public Facture saveFacture(Facture facture) {
        return factureRepo.save(facture);
    }
    public Facture updateFacture (Long id, Facture facture){
        Optional<Facture> existingFacture = factureRepo.findById(id);
        return null;
    }
    public boolean deleteFacture(Long id){
        return false;
    }
}

