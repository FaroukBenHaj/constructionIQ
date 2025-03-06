import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommandeService } from 'src/app/services/commande.service'; 
import { Commande, CommandeStatus } from 'src/app/models/commande';  

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {
  commandeForm: FormGroup;
  statuses = Object.values(CommandeStatus);  

  constructor(
    private fb: FormBuilder,
    private commandeService: CommandeService
  ) {
    this.commandeForm = this.fb.group({
      projetId: [0, [Validators.required]],
      userId: [0, [Validators.required]],
      status: [CommandeStatus.EN_ATTENTE, [Validators.required]],
      totalAmount: [0, [Validators.required, Validators.min(0)]],
      orderDate: ['', [Validators.required]],
      deliveryDate: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.commandeForm.valid) {
      this.commandeService.createCommande(this.commandeForm.value).subscribe(
        (response: Commande) => {  
          console.log('Commande créée avec succès', response);
        },
        (error: any) => {  
          console.error('Erreur lors de la création de la commande', error);
        }
      );
    }
  }
}
