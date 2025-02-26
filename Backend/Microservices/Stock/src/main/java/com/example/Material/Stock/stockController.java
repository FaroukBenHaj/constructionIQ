package com.example.Material.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @PostMapping
        public Stock createStock(@RequestBody Stock stock) {
            return stockService.saveStock(stock);
        }

        @DeleteMapping("/{id}")
        public void deleteStock(@PathVariable Long id) {
            stockService.deleteStock(id);
        }
    }
