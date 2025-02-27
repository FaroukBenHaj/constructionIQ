package tn.esprit.finance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projetId; // Référence à un projet du microservice "project"

    private Double montantInitial;
    private Double montantUtilise;
    private Double montantRestant;

    @UpdateTimestamp
    private LocalDateTime derniereMiseAJour;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<TransactionFinanciere> transactions = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjetId() {
        return projetId;
    }

    public void setProjetId(String projetId) {
        this.projetId = projetId;
    }

    public Double getMontantInitial() {
        return montantInitial;
    }

    public void setMontantInitial(Double montantInitial) {
        this.montantInitial = montantInitial;
    }

    public Double getMontantUtilise() {
        return montantUtilise;
    }

    public void setMontantUtilise(Double montantUtilise) {
        this.montantUtilise = montantUtilise;
    }

    public Double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(Double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public LocalDateTime getDerniereMiseAJour() {
        return derniereMiseAJour;
    }

    public void setDerniereMiseAJour(LocalDateTime derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }

    public List<TransactionFinanciere> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionFinanciere> transactions) {
        this.transactions = transactions;
    }
}

