import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { HomePageComponent } from './component/home-page/home-page.component';
import { CommonModule } from '@angular/common';
import { BudgetComponent } from './component/budget/budget.component';
import { PaymentComponent } from './component/payment/payment.component';
import { InvoiceComponent } from './component/invoice/invoice.component';
import { AddBudgetComponent } from './component/budget/add-budget/add-budget.component';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    BudgetComponent,
    PaymentComponent,
    InvoiceComponent,
    AddBudgetComponent,
   
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
