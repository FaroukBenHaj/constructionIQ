import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Budget } from '../models/budget';  

@Injectable({
  providedIn: 'root'
})
export class BudgetService {

  private apiUrl = 'http://localhost:8089/api/budgets';  // L'URL de ton backend Spring Boot

  constructor(private http: HttpClient) { }

  // Créer un budget
  createBudget(budget: Budget): Observable<Budget> {
    return this.http.post<Budget>(this.apiUrl, budget);
  }

  // Récupérer tous les budgets
  getAllBudgets(): Observable<Budget[]> {
    return this.http.get<Budget[]>(this.apiUrl);
  }

  // (Si nécessaire) Récupérer le budget par ID de projet
  getBudgetByProjectId(projetId: number): Observable<Budget> {
    return this.http.get<Budget>(`${this.apiUrl}/projet/${projetId}`);
  }
  getBudgetById(id: number): Observable<Budget> {
    return this.http.get<Budget>(`${this.apiUrl}/${id}`);
  }
  
}

//private apiUrl = 'http://localhost:8089/api/budgets'; // À adapter selon ton backend