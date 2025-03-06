import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './component/home-page/home-page.component';
import { BudgetComponent } from './component/budget/budget.component';



const routes: Routes = [

  { path : 'home' , component:HomePageComponent},
  { path : '' , redirectTo: '/home' , pathMatch:'full'},
  { path: 'budget', component: BudgetComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
