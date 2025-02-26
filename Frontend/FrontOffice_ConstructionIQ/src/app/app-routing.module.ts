import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './component/home-page/home-page.component';
import { MaterialComponent } from './material/material.component';

const routes: Routes = [

  { path : 'home' , component:HomePageComponent},
  { path : '' , redirectTo: '/home' , pathMatch:'full'},
  { path : 'material' , component:MaterialComponent},
  { path: '**', redirectTo: '/home' } // Si aucune route ne correspond, redirige vers /home


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
