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
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private long projetId;

    @Enumerated(EnumType.STRING)
    private catDep categorie;

    private String description;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private LocalDate dateDepense;

    private String fournisseurId;

    private String factureId;

    @Enumerated(EnumType.STRING)
    private MoyenPaiement moyenPaiement;

    @Enumerated(EnumType.STRING)
    private StatutDepense statut;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @UpdateTimestamp
    private LocalDateTime derniereMiseAJour;

    private String userId;

    public enum catDep {
        MATERIAUX,
        MAIN_DOEUVRE,
        TRANSPORT,
        EQUIPEMENT,
        DIVERS
    }

    public enum MoyenPaiement {
        VIREMENT,
        CARTE,
        ESPECE,
        CHEQUE
    }

    public enum StatutDepense {
        EN_ATTENTE,
        APPROUVEE,
        REJETEE
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getDerniereMiseAJour() {
        return derniereMiseAJour;
    }

    public void setDerniereMiseAJour(LocalDateTime derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public StatutDepense getStatut() {
        return statut;
    }

    public void setStatut(StatutDepense statut) {
        this.statut = statut;
    }

    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public String getFactureId() {
        return factureId;
    }

    public void setFactureId(String factureId) {
        this.factureId = factureId;
    }

    public String getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(String fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public LocalDate getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(LocalDate dateDepense) {
        this.dateDepense = dateDepense;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public catDep getCategorie() {
        return categorie;
    }

    public void setCategorie(catDep categorie) {
        this.categorie = categorie;
    }

    public long getProjetId() {
        return projetId;
    }

    public void setProjetId(long projetId) {
        this.projetId = projetId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
