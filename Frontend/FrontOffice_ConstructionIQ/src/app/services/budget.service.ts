import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BudgetService {
  private apiUrl = 'http://localhost:8089/api/budgets'; // Remplace par l'URL de ton API

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer un budget par ID
  getBudgetById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
}
