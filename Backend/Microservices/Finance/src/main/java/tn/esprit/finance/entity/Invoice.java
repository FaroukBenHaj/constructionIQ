package tn.esprit.finance.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne
    private Projet projectId;
    @OneToOne
    private User userId;
    private double montant;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    private LocalDateTime dateEmission;
    private Date dateEcheance;


    public enum InvoiceStatus{
        En_Attente,
        Payee,
        Rejetee,
    }
}

