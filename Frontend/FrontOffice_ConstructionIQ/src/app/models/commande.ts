import { Invoice } from './invoice';  
import { Payment } from './payment';  

export class Commande {
  id: number;
  projetId: number;  
  userId: number;  
  status: CommandeStatus;
  totalAmount: number;
  invoices: Invoice[]; 
  payments: Payment[]; 
  orderDate: string;  
  deliveryDate: string;  

  constructor(id: number = 0, projetId: number = 0, userId: number = 0, status: CommandeStatus = CommandeStatus.EN_ATTENTE, totalAmount: number = 0, invoices: Invoice[] = [], payments: Payment[] = [], orderDate: string = '', deliveryDate: string = '') {
    this.id = id;
    this.projetId = projetId;
    this.userId = userId;
    this.status = status;
    this.totalAmount = totalAmount;
    this.invoices = invoices;
    this.payments = payments;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
  }
}

export enum CommandeStatus {
  EN_ATTENTE = 'EN_ATTENTE',
  VALIDEE = 'VALIDEE',
  EXPEDIEE = 'EXPEDIEE',
  LIVREE = 'LIVREE',
  ANNULEE = 'ANNULEE'
}
