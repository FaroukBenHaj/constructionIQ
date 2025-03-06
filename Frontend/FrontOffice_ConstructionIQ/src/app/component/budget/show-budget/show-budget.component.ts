import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BudgetService } from 'src/app/services/budget.service';

@Component({
  selector: 'app-show-budget',
  templateUrl: './show-budget.component.html',
  styleUrls: ['./show-budget.component.css']
})
export class ShowBudgetComponent implements OnInit {
  budget: any;
  isLoading = true; // Indicateur de chargement

  constructor(
    private route: ActivatedRoute,
    private budgetService: BudgetService
  ) {}

  ngOnInit(): void {
    // Récupère l'ID du budget depuis l'URL
    const budgetId = this.route.snapshot.paramMap.get('id');

    if (budgetId) {
      // Appelle le service pour obtenir les données du budget
      this.budgetService.getBudgetById(budgetId).subscribe(
        (data) => {
          this.budget = data;
          this.isLoading = false; // Désactive l'indicateur de chargement
        },
        (error) => {
          console.error('Erreur lors du chargement du budget', error);
          this.isLoading = false;
        }
      );
    } else {
      console.error('ID de budget invalide');
      this.isLoading = false;
    }
  }
}
