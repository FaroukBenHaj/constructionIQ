import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './component/home-page/home-page.component';
import { BudgetComponent } from './component/budget/budget.component';
import { ShowBudgetComponent } from './component/budget/show-budget/show-budget.component';
import { CommandeComponent } from './component/commande/commande.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }, 
  { path: 'budget', component: BudgetComponent },
  { path: 'show-budget/:id', component: ShowBudgetComponent }, 
  { path: 'commande', component: CommandeComponent }, 
  { path: '**', redirectTo: '/home' }
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
