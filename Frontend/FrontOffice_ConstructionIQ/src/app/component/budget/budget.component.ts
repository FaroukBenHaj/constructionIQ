import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, ValidationErrors, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent {
  budgetForm: FormGroup;

  constructor(private router: Router) {
    this.budgetForm = new FormGroup({
      montantTotal: new FormControl('', [Validators.required, Validators.min(0)]),
      montantRestant: new FormControl('', [Validators.required, Validators.min(0), this.montantRestantValidator.bind(this)]),
      projectId: new FormControl('', Validators.required),
      dateCreation: new FormControl('', Validators.required)
    });
  }

  // 🔥 VALIDATEUR PERSONNALISÉ POUR MONTANT RESTANT 🔥
  montantRestantValidator(control: AbstractControl): ValidationErrors | null {
    const montantTotal = this.budgetForm?.get('montantTotal')?.value; // Récupérer montantTotal
    const montantRestant = control.value; // Récupérer montantRestant

    return montantRestant > montantTotal
      ? { montantRestantInvalid: true } // ❌ Si montantRestant > montantTotal, erreur
      : null; // ✅ Sinon, pas d'erreur
  }

  onSubmit() {
    if (this.budgetForm.valid) {
      // Simule un enregistrement et un ID généré
      const budgetId = Math.floor(Math.random() * 1000); // Remplace ceci par l'ID réel du backend

      // Rediriger vers show-budget avec l'ID du budget créé
      this.router.navigate(['/show-budget', budgetId]);
    }
  }
}
