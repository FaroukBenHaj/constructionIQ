import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {
  budgetForm!: FormGroup;
  budgets: any[] = []; // Simuler une liste de budgets

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.budgetForm = this.fb.group({
      montantTotal: ['', [Validators.required, Validators.min(1)]],
      montantRestant: ['', [Validators.required, Validators.min(0)]],
      projectId: ['', Validators.required],
      dateCreation: ['', Validators.required]
    });

    // Simuler des budgets existants (à remplacer par un appel API)
    this.budgets = [
      { id: 1, montantTotal: 5000, montantRestant: 2500, projectId: 101, dateCreation: new Date() },
      { id: 2, montantTotal: 8000, montantRestant: 4000, projectId: 102, dateCreation: new Date() }
    ];
  }

  onSubmit() {
    if (this.budgetForm.valid) {
      const newBudget = this.budgetForm.value;
      newBudget.id = this.budgets.length + 1; // Simuler un ID
      this.budgets.push(newBudget);
      alert('Budget enregistré avec succès !');
      this.router.navigate(['/show-budget']); // Rediriger après l'ajout
    }
  }

  editBudget(budget: any) {
    console.log('Modifier le budget', budget);
    // Logique d'édition ici
  }

  deleteBudget(id: number) {
    this.budgets = this.budgets.filter(b => b.id !== id);
    alert('Budget supprimé avec succès !');
  }
}
