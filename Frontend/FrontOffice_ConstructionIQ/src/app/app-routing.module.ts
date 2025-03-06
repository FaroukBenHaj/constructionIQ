import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './Pages/home-page/home-page.component';
import {LoginComponent} from "./Pages/login/login.component";
import {RegisterComponent} from "./Pages/register/register.component";

const routes: Routes = [

  { path : 'home' , component:HomePageComponent},
  { path : '' , redirectTo: '/home' , pathMatch:'full'},
  { path : 'login' , component:LoginComponent},
  { path : 'register' , component:RegisterComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
