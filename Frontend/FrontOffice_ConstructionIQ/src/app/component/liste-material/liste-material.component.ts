import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { Material } from 'src/app/material.model';
import { MaterialService } from 'src/app/material.service';

@Component({
  selector: 'app-liste-material',
  templateUrl: './liste-material.component.html',
  styleUrls: ['./liste-material.component.css']
})
export class ListeMaterialComponent implements OnInit {
  loading: boolean = true;
  materials: Material[] = []; // Tableau des matériaux
  searchName: string = '';  // Pour le filtrage global
  
  constructor(private materialService: MaterialService) { }

  ngOnInit(): void {
    this.loadMaterials(); // Charger les matériaux lorsque le composant est initialisé
  }

  // Fonction pour charger les matériaux
  loadMaterials(): void {
    this.materialService.getAllMaterials().subscribe(
      (data: Material[]) => {
        this.materials = data;  // Stocker les matériaux récupérés
        this.loading = false;    // Désactiver l'indicateur de chargement
      },
      (error) => {
        console.error('Erreur lors de la récupération des matériaux', error);
        this.loading = false;    // Désactiver l'indicateur de chargement en cas d'erreur
      }
    );
  }

  // Méthode pour le filtrage global
  onGlobalFilter(table: Table, event: any): void {
    table.filterGlobal(event.target.value, 'contains');  // Effectuer un filtrage global basé sur la valeur de l'input
  }
  
  // Méthode pour réinitialiser le tableau et le champ de recherche
  clear(table: Table): void {
    table.clear();
    this.searchName = '';  // Réinitialiser la valeur de recherche
  }
}
