import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent {

  budgetForm: FormGroup; 

  constructor() {
    this.budgetForm = new FormGroup({
      montantTotal: new FormControl('', [Validators.required, Validators.min(0)]),
      montantRestant: new FormControl('', [Validators.required, Validators.min(0)]),
      projectId: new FormControl('', Validators.required),
      dateCreation: new FormControl('', Validators.required)
    });
  }

  onSubmit() { 
    if (this.budgetForm.valid) {
      console.log('Budget ajouté :', this.budgetForm.value);
    }
  }
}
