package tn.esprit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.finance.entity.Invoice;
import tn.esprit.finance.entity.Projet;
import tn.esprit.finance.repository.InvoiceRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class InvoiceService {
    @Autowired
    private  InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        invoice.setStatus(Invoice.InvoiceStatus.En_Attente);
        invoice.setDateEmission(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoicesByProject(Projet projectId) {
        return invoiceRepository.findByProjectId(projectId);
    }

    public Invoice updateInvoiceStatus(Long id, Invoice.InvoiceStatus status) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture non trouvée"));
        invoice.setStatus(status);
        return invoiceRepository.save(invoice);
    }
}

