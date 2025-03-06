import { Component } from '@angular/core';
import { StockService } from 'src/app/service/stock.service';
import { Stock } from 'src/app/models/stock.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.css']
})
export class AddStockComponent {
  newStock: Stock = {
    availableQuantity: 0,
    dateReceived: '',
    stockID: 0,     // stockID peut être généré côté backend
    projetID: 0,    // ID du projet, ajuster selon votre logique
    materialID: 0   // ID du matériau
  };

  errorMessage: string = '';  // Variable pour afficher un message d'erreur
  successMessage: string = '';  // Variable pour afficher un message de succès
  isSubmitting: boolean = false; // Variable pour désactiver le bouton pendant la soumission

  constructor(private stockService: StockService, private router: Router) {}

  // Méthode appelée lors de la soumission du formulaire
  onSubmit(): void {
    this.errorMessage = ''; // Réinitialiser l'erreur à chaque soumission
    this.successMessage = ''; // Réinitialiser le message de succès

    // Vérification des données avant l'envoi
    if (this.isValidForm()) {
      this.isSubmitting = true; // Indiquer que la soumission est en cours

      // Appel du service pour ajouter le stock
      this.stockService.createStock(this.newStock).subscribe(
        (data) => {
          console.log('Stock ajouté avec succès', data);
          this.successMessage = 'Le stock a été ajouté avec succès.';
          this.router.navigate(['/stocks']); // Redirection après ajout
        },
        (error) => {
          this.isSubmitting = false; // Réinitialiser le bouton une fois la soumission terminée
          this.handleError(error);
        }
      );
    } else {
      this.errorMessage = 'Veuillez remplir tous les champs correctement.';
    }
  }

  // Vérification que le formulaire est valide
  isValidForm(): boolean {
    return (
      this.newStock.availableQuantity > 0 &&
      this.newStock.dateReceived !== '' &&
      this.newStock.materialID > 0
    );
  }

  // Fonction pour gérer les erreurs
  handleError(error: any): void {
    this.errorMessage = ''; // Réinitialiser l'erreur

    if (error.status === 500) {
      this.errorMessage = 'Une erreur interne est survenue. Veuillez réessayer plus tard.';
    } else if (error.status === 400) {
      this.errorMessage = 'Erreur dans les données envoyées. Veuillez vérifier.';
    } else {
      this.errorMessage = 'Une erreur inconnue est survenue.';
    }
    console.error(this.errorMessage);
  }
}
