import { Component, OnInit } from '@angular/core';
import { Material } from '../material.model'; // Votre modèle Material
import { MaterialService } from '../material.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.css']
})
export class MaterialComponent implements OnInit {
  materialForm: FormGroup;

  constructor(
    private materialService: MaterialService,
    private fb: FormBuilder
  ) {
    // Initialisation du formulaire avec les bons champs
    this.materialForm = this.fb.group({
      materialName: ['', [Validators.required]],
      cost: ['', [Validators.required, Validators.min(0)]], // Vérification d'un coût positif
      materialUnit: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {}

  // Gestion de la soumission du formulaire
  onSubmit(): void {
    if (this.materialForm.valid) {
      const material: Material = this.materialForm.value;
      this.materialService.createMaterial(material).subscribe(
        (response) => {
          console.log('Material submitted successfully:', response);
          // Vous pouvez ajouter un message de succès ici, par exemple un pop-up
        },
        (error) => {
          console.error('Error submitting material:', error);
          // Traitez les erreurs ici, par exemple en affichant un message d'erreur
        }
      );
    }
  }
}
