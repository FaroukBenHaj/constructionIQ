package tn.esprit.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions_financieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFinanciere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeTransaction typeTransaction; // DEPENSE ou FACTURE

    @Enumerated(EnumType.STRING)
    private CategorieDepense categorie;

    private String description;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private LocalDate dateTransaction;

    private String fournisseurId; // Null si c'est une simple dépense

    private String numeroFacture; // Null si ce n'est pas une facture

    @Column(nullable = true)
    private LocalDate dateEcheance; // Seulement pour les factures

    @Enumerated(EnumType.STRING)
    private MoyenPaiement moyenPaiement;

    @Enumerated(EnumType.STRING)
    private StatutTransaction statut; // EN_ATTENTE, PAYÉE, EN_RETARD

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    private LocalDateTime derniereMiseAJour;

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget; // Association avec Budget


    public enum TypeTransaction {
        DEPENSE,
        FACTURE
    }
    public enum StatutTransaction {
        EN_ATTENTE,
        PAYEE,
        EN_RETARD
    }
    public enum MoyenPaiement {
        VIREMENT,
        CARTE,
        ESPECE,
        CHEQUE
    }
    public enum CategorieDepense {
        MATERIAUX,
        MAIN_DOEUVRE,
        TRANSPORT,
        EQUIPEMENT,
        DIVERS
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategorieDepense getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieDepense categorie) {
        this.categorie = categorie;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(String fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public StatutTransaction getStatut() {
        return statut;
    }

    public void setStatut(StatutTransaction statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDerniereMiseAJour() {
        return derniereMiseAJour;
    }

    public void setDerniereMiseAJour(LocalDateTime derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}

