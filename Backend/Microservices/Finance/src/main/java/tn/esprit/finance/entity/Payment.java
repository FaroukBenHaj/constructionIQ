package tn.esprit.finance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;

    @ManyToOne
    private Invoice invoiceId;
    private double montantPaye;
    private LocalDateTime datePaiement;

    @Enumerated(EnumType.STRING)
    private PaymentMode modePaiement;

    public enum PaymentMode{
        VIREMENT,
        CHEQUE,
        CARTE_BANCAIRE,
        ESPECE
    }
}
