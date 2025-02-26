package tn.esprit.finance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "factures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projetId; // Clé du projet associé

    @Column(nullable = false)
    private String fournisseurId; // Clé du fournisseur

    @Column(unique = true, nullable = false)
    private String numeroFacture; // Numéro de Facture unique

    @Column(nullable = false)
    private Double montantTotal;

    @Column(nullable = false)
    private LocalDate dateEmission;

    @Column(nullable = false)
    private LocalDate dateEcheance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutFacture statut;

    @Enumerated(EnumType.STRING)
    private Depense.MoyenPaiement moyenPaiement;

    private Boolean paiementEffectué = false; // Par défaut non payé

    @ElementCollection
    private List<String> listeDepenses; // Liste des ID des dépenses liées

    private String creePar;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    private LocalDateTime derniereMiseAJour;

    public enum StatutFacture {
        EN_ATTENTE,
        PAYEE,
        EN_RETARD
    }

}
