import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { HomePageComponent } from './component/home-page/home-page.component';
import { CommonModule } from '@angular/common';
import { BudgetComponent } from './component/budget/budget.component';
import { PaymentComponent } from './component/payment/payment.component';
import { InvoiceComponent } from './component/invoice/invoice.component';
import { ShowBudgetComponent } from './component/budget/show-budget/show-budget.component';
import { ReactiveFormsModule } from '@angular/forms';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    BudgetComponent,
    PaymentComponent,
    InvoiceComponent,
    ShowBudgetComponent
    
   
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
