import { Component, OnInit } from '@angular/core';
import { Stock } from 'src/app/models/stock.model';
import { StockService } from 'src/app/service/stock.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  stocks: Stock[] = [];  // Tableau pour stocker la liste des stocks

  constructor(private stockService: StockService) { }

  ngOnInit(): void {
    this.getAllStocks();  // Appeler la méthode pour récupérer les stocks lors de l'initialisation
  }

  // Méthode pour récupérer tous les stocks
  getAllStocks(): void {
    this.stockService.getAllStocks().subscribe(
      (data) => {
        this.stocks = data;  // Assigner les données reçues à la variable stocks
      },
      (error) => {
        console.error('Erreur lors de la récupération des stocks:', error);  // Gérer les erreurs si nécessaire
      }
    );
  }
}
