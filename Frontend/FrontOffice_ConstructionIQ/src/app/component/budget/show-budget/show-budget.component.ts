import { Component, OnInit } from '@angular/core';
import { BudgetService } from 'src/app/services/budget.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-budget',
  templateUrl: './show-budget.component.html',
  styleUrls: ['./show-budget.component.css']
})
export class ShowBudgetComponent implements OnInit {
  budget: any = null;

  constructor(private budgetService: BudgetService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const budgetId = Number(this.route.snapshot.paramMap.get('id')); // ✅ Conversion en number
    if (!isNaN(budgetId)) { 
      this.loadBudget(budgetId);
    } else {
      console.error('ID budget invalide:', budgetId);
    }
  }

  loadBudget(id: number): void {  // ✅ S'assurer que id est bien un number
    this.budgetService.getBudgetById(id).subscribe(
      (data) => {
        console.log('Budget chargé:', data); // ✅ Affichage pour debug
        this.budget = data;
      },
      (error) => {
        console.error('Erreur lors du chargement du budget', error);
      }
    );
  }
}
