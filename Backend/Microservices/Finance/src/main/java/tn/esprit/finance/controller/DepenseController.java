package tn.esprit.finance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Depense;
import tn.esprit.finance.service.DepenseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/depenses")
public class DepenseController {

    private DepenseService depenseService;

    public DepenseController(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @GetMapping
    public List<Depense> getAllDepenses() {
        return depenseService.getAllDepenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depense> getDepenseById(@PathVariable Long id) {
        Optional<Depense> depense = depenseService.getDepenseById(id);
        return depense.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/projet/{projetId}")
    public List<Depense> getDepensesByProjetId(@PathVariable Long projetId) {
        return depenseService.getDepensesByProjetId(projetId);
    }

    @PostMapping("/add-dep")
    public Depense createDepense(@RequestBody Depense depense) {
        return depenseService.createDepense(depense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depense> updateDepense(@PathVariable Long id, @RequestBody Depense depense) {
        try {
            Depense updatedDepense = depenseService.updateDepense(id, depense);
            return ResponseEntity.ok(updatedDepense);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepense(@PathVariable Long id) {
        depenseService.deleteDepense(id);
        return ResponseEntity.noContent().build();
    }
}
