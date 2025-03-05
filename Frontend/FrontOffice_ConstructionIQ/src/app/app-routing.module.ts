import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './component/home-page/home-page.component';
import { ListeMaterialComponent } from './component/liste-material/liste-material.component';
import { MaterialComponent } from './component/material/material.component';
import { StockComponent } from './component/stock/stock.component'; // Import StockComponent

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'ListeMaterial', component: ListeMaterialComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'material', component: MaterialComponent },
  { path: 'material/:id', component: MaterialComponent },  // Route pour mettre à jour un matériau

  { path: 'stock', component: StockComponent }, // Add route for StockComponent
  { path: '**', redirectTo: '/home' } // If no route matches, redirect to /home
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
