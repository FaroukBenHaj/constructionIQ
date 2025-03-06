import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Commande } from '../models/commande';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
  private apiUrl = 'http://localhost:8089/api/commandes';

  constructor(private http: HttpClient) { }


  createCommande(commande: Commande): Observable<Commande> {
    return this.http.post<Commande>(this.apiUrl, commande)
      .pipe(catchError(this.handleError));
  }

  getAllCommandes(): Observable<Commande[]> {
    return this.http.get<Commande[]>(this.apiUrl)
      .pipe(catchError(this.handleError));
  }

  
  getCommandeById(id: number): Observable<Commande> {
    return this.http.get<Commande>(`${this.apiUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

  
  updateCommande(id: number, commande: Commande): Observable<Commande> {
    return this.http.put<Commande>(`${this.apiUrl}/${id}`, commande)
      .pipe(catchError(this.handleError));
  }

  
  deleteCommande(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

 
  private handleError(error: HttpErrorResponse) {
    console.error('Erreur API CommandeService:', error);
    return throwError(() => new Error('Une erreur est survenue lors de lopération.'));
  }
}
