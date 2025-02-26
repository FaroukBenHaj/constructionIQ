package tn.esprit.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Budget;
import tn.esprit.finance.entity.Facture;
import tn.esprit.finance.service.FactureService;

import java.util.List;

@RestController
@RequestMapping("/factures")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        return ResponseEntity.ok(factureService.getAllFactures());
    }

    @PostMapping
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        return ResponseEntity.ok(factureService.saveFacture(facture));
    }

    @PutMapping
    public ResponseEntity<Facture> updateFacture(@PathVariable long id, @RequestBody Facture facture) {
        Facture updateFacture = factureService.updateFacture(id, facture);
        return updateFacture != null ? ResponseEntity.ok(updateFacture) : ResponseEntity.notFound().build();
    }
}



