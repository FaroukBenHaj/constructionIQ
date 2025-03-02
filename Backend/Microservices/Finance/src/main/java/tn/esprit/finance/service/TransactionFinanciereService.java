//package tn.esprit.finance.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import tn.esprit.finance.entity.TransactionFinanciere;
//import tn.esprit.finance.repository.TransactionFinanciereRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TransactionFinanciereService {
//
//    @Autowired
//    private TransactionFinanciereRepository transactionRepository;
//
//    public List<TransactionFinanciere> getAllTransactions() {
//        return transactionRepository.findAll();
//    }
//
//    public Optional<TransactionFinanciere> getTransactionById(Long id) {
//        return transactionRepository.findById(id);
//    }
//
//    public List<TransactionFinanciere> getTransactionsByBudgetId(Long budgetId) {
//        return transactionRepository.findByBudgetId(budgetId);
//    }
//
//    public TransactionFinanciere createTransaction(TransactionFinanciere transaction) {
//        return transactionRepository.save(transaction);
//    }
//
//    public TransactionFinanciere updateTransaction(Long id, TransactionFinanciere transactionDetails) {
//        return transactionRepository.findById(id).map(transaction -> {
//            transaction.setTypeTransaction(transactionDetails.getTypeTransaction());
//            transaction.setCategorie(transactionDetails.getCategorie());
//            transaction.setDescription(transactionDetails.getDescription());
//            transaction.setMontant(transactionDetails.getMontant());
//            transaction.setDateTransaction(transactionDetails.getDateTransaction());
//            transaction.setFournisseurId(transactionDetails.getFournisseurId());
//            transaction.setNumeroFacture(transactionDetails.getNumeroFacture());
//            transaction.setDateEcheance(transactionDetails.getDateEcheance());
//            transaction.setMoyenPaiement(transactionDetails.getMoyenPaiement());
//            transaction.setStatut(transactionDetails.getStatut());
//            return transactionRepository.save(transaction);
//        }).orElseThrow(() -> new RuntimeException("Transaction not found"));
//    }
//
//    public void deleteTransaction(Long id) {
//        transactionRepository.deleteById(id);
//    }
//}
