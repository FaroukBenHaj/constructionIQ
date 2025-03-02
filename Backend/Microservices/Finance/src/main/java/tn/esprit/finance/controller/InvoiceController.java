package tn.esprit.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Invoice;
import tn.esprit.finance.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
//@RequiredArgsConstructor
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

//    @PostMapping
//    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
//        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
//    }
@PostMapping
public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
    Invoice newInvoice = invoiceService.createInvoice(invoice);
    return ResponseEntity.status(HttpStatus.CREATED).body(newInvoice);
}


    @PutMapping("/{id}/status")
    public ResponseEntity<Invoice> updateStatus(@PathVariable Long id, @RequestParam Invoice.InvoiceStatus status) {
        return ResponseEntity.ok(invoiceService.updateInvoiceStatus(id, status));
    }
}

