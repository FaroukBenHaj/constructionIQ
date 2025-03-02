//package tn.esprit.finance.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import tn.esprit.finance.entity.TransactionFinanciere;
//import tn.esprit.finance.service.TransactionFinanciereService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/transactions")
//public class TransactionFinanciereController {
//
//    @Autowired
//    private TransactionFinanciereService transactionService;
//
//    @GetMapping
//    public List<TransactionFinanciere> getAllTransactions() {
//        return transactionService.getAllTransactions();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TransactionFinanciere> getTransactionById(@PathVariable Long id) {
//        Optional<TransactionFinanciere> transaction = transactionService.getTransactionById(id);
//        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/budget/{budgetId}")
//    public List<TransactionFinanciere> getTransactionsByBudgetId(@PathVariable Long budgetId) {
//        return transactionService.getTransactionsByBudgetId(budgetId);
//    }
//
//    @PostMapping
//    public TransactionFinanciere createTransaction(@RequestBody TransactionFinanciere transaction) {
//        return transactionService.createTransaction(transaction);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TransactionFinanciere> updateTransaction(@PathVariable Long id, @RequestBody TransactionFinanciere transactionDetails) {
//        return ResponseEntity.ok(transactionService.updateTransaction(id, transactionDetails));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
//        transactionService.deleteTransaction(id);
//        return ResponseEntity.noContent().build();
//    }
//}
