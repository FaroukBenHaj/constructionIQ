import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stock } from '../models/stock.model';  // Import the Stock model to define the data structure

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private apiUrl = 'http://localhost:8075/stocks'; // Make sure the API URL is correct

  constructor(private http: HttpClient) { }

  // Method to retrieve all stocks
  getAllStocks(): Observable<Stock[]> {
    return this.http.get<Stock[]>(this.apiUrl); // API call to fetch stocks
  }

  // Method to retrieve a stock by ID
  getStockById(id: number): Observable<Stock> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Stock>(url); // API call to fetch a stock by its ID
  }

  // Method to create a new stock
  createStock(stock: Stock): Observable<Stock> {
    return this.http.post<Stock>(this.apiUrl, stock); // API call to create a stock
  }

  // Method to delete a stock by ID
  deleteStock(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url); // API call to delete a stock
  }
}
