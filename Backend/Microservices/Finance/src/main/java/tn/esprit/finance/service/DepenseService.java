package tn.esprit.finance.service;

import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Depense;
import tn.esprit.finance.repository.DepenseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepenseService {

    private final DepenseRepo depenseRepo;

    public DepenseService(DepenseRepo depenseRepo) {
        this.depenseRepo= depenseRepo;
    }

    public List<Depense> getAllDepenses() {
        return depenseRepo.findAll();
    }

    public Optional<Depense> getDepenseById(Long id) {
        return depenseRepo.findById(id);
    }

    public List<Depense> getDepensesByProjetId(Long projetId) {
        return depenseRepo.findByProjetId(projetId);
    }

    public Depense createDepense(Depense depense) {
        return depenseRepo.save(depense);
    }

    public Depense updateDepense(Long id, Depense depenseDetails) {
        return depenseRepo.findById(id).map(depense -> {
            depense.setProjetId(depenseDetails.getProjetId());
            depense.setCategorie(depenseDetails.getCategorie());
            depense.setDescription(depenseDetails.getDescription());
            depense.setMontant(depenseDetails.getMontant());
            depense.setDateDepense(depenseDetails.getDateDepense());
            depense.setFournisseurId(depenseDetails.getFournisseurId());
            depense.setFactureId(depenseDetails.getFactureId());
            depense.setMoyenPaiement(depenseDetails.getMoyenPaiement());
            depense.setStatut(depenseDetails.getStatut());
            depense.setUserId(depenseDetails.getUserId());
            return depenseRepo.save(depense);
        }).orElseThrow(() -> new RuntimeException("Dépense non trouvée avec l'id " + id));
    }

    public void deleteDepense(Long id) {
        depenseRepo.deleteById(id);
    }
}
