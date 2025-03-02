package tn.esprit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Invoice;
import tn.esprit.finance.entity.Payment;
import tn.esprit.finance.repository.InvoiceRepository;
import tn.esprit.finance.repository.PaymentRepository;

@Service
//@RequiredArgsConstructor
public class PaymentService {
    @Autowired
    private  PaymentRepository paymentRepository;
    @Autowired
    private  InvoiceRepository invoiceRepository;

    public Payment processPayment(Payment payment) {
        Invoice invoice = invoiceRepository.findById(payment.getInvoiceId().getId())
                .orElseThrow(() -> new RuntimeException("Facture non trouvée"));


        invoice.setStatus(Invoice.InvoiceStatus.Payee);
        invoiceRepository.save(invoice);

        return paymentRepository.save(payment);
    }
}
