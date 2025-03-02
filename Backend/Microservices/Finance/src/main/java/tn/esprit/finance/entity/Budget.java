package tn.esprit.finance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectId;  // Référence au projet

    @Positive(message = "Le montant total doit être un nombre positif")
    private double montantTotal;

    @PositiveOrZero(message = "Le montant restant ne peut pas être négatif")
    private double montantRestant;

    private LocalDateTime dateCreation;

    @AssertTrue(message = "Le montant total doit être supérieur au montant restant")
    public boolean isMontantTotalValid() {
        return montantTotal >= montantRestant;
    }
}

