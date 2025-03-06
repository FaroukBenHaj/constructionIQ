package com.example.Material.Stock;





import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockID;
    private Long projetID;



    private Long materialID;
    private int availableQuantity;
    // Vérifie que la date est dans le passé
    private LocalDate dateReceived;


    @Version
    private Long version = 0L;  // Assurez-vous que la version a une valeur initiale

    public Long getProjetID() {
        return projetID;
    }

    public void setProjetID(Long projetID) {
        this.projetID = projetID;
    }
    // Getters and Setters
    public Long getStockID() {
        return stockID;
    }

    public void setStockID(Long stockID) {
        this.stockID = stockID;
    }

    public Long getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Long materialID) {
        this.materialID = materialID;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }
}