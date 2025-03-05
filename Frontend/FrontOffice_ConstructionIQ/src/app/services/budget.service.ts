import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BudgetService {
  private apiUrl = 'http://localhost:8089/api/budgets';

  constructor(private http: HttpClient) {}

  getBudgets(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
