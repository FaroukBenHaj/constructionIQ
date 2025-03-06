package com.example.Material.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping("/stocks")
    public class stockController {

        @Autowired
        private StockService stockService;

        @GetMapping
        public List<Stock> getAllStocks() {
            return stockService.getAllStocks();
        }

        @GetMapping("/{id}")
        public Optional<Stock> getStockById(@PathVariable Long id) {
            return stockService.getStockById(id);
        }

        @PostMapping("/post")
        public Stock createStock(@RequestBody Stock stock) {
            if (stock == null || stock.getMaterialID() == 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock or Material ID is invalid");
            }

            try {
                return stockService.saveStock(stock);
            } catch (Exception e) {
                System.err.println("Exception occurred while saving stock: " + e.getMessage());
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de l'ajout du stock", e);
            }
        }



        @DeleteMapping("/{id}")
        public void deleteStock(@PathVariable Long id) {
            stockService.deleteStock(id);
        }
    }
