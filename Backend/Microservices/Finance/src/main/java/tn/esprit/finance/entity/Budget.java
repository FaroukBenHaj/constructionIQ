package tn.esprit.finance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;  // Assurez-vous que ce champ existe bien

    private double montant;

    private LocalDate dateBudget;

    private String projetId;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    private LocalDateTime derniereMiseAJour;

    // Getter et Setter pour description, montant, dateBudget, etc.

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDateBudget() {
        return dateBudget;
    }

    public void setDateBudget(LocalDate dateBudget) {
        this.dateBudget = dateBudget;
    }

    public String getProjetId() {
        return projetId;
    }

    public void setProjetId(String projetId) {
        this.projetId = projetId;
    }
}
