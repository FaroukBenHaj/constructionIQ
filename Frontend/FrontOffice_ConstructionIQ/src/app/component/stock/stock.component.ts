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
  loading: boolean = false;  // Variable pour gérer l'état de chargement
  searchName: string = '';  // Variable pour la recherche globale

  constructor(private stockService: StockService) { }

  ngOnInit(): void {
    this.getAllStocks();  // Appeler la méthode pour récupérer les stocks lors de l'initialisation
  }

  // Méthode pour récupérer tous les stocks
  getAllStocks(): void {
    this.loading = true;  // Démarrer le chargement
    this.stockService.getAllStocks().subscribe(
      (data) => {
        this.stocks = data;  // Assigner les données reçues à la variable stocks
        this.loading = false;  // Arrêter le chargement
      },
      (error) => {
        console.error('Erreur lors de la récupération des stocks:', error);  // Gérer les erreurs si nécessaire
        this.loading = false;  // Arrêter le chargement même en cas d'erreur
      }
    );
  }

  // Méthode pour supprimer un stock
  deleteStock(stockID: number): void {
    // Logic to delete stock by ID
    this.stockService.deleteStock(stockID).subscribe(
      () => {
        // Suppression réussie, on retire le stock de la liste
        this.stocks = this.stocks.filter(stock => stock.stockID !== stockID);
      },
      (error) => {
        console.error('Erreur lors de la suppression du stock:', error);
      }
    );
  }

  // Méthode pour modifier un stock
  editStock(stock: Stock): void {
    // Logic to edit stock, such as navigating to a stock edit page
    console.log('Editing stock:', stock);
    // Example: Navigate to edit page with stock data, 
    // this.router.navigate(['/edit-stock', stock.stockID]);
  }

  // Méthode pour la recherche globale
  onGlobalFilter(dt: any, event: any): void {
    dt.filterGlobal(event.target.value, 'contains');
  }
}
