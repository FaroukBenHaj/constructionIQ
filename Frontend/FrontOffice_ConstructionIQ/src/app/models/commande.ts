export enum CommandeStatus {
    EN_ATTENTE = "EN_ATTENTE",
    VALIDE = "VALIDE",
    EXPEDIEE = "EXPEDIEE",
    LIVREE = "LIVREE",
    ANNULEE = "ANNULEE"
  }
  
  export interface Project {
    id: number;
    name: string;
  }
  
  export interface Supplier {
    id: number;
    name: string;
  }
  
  export interface Product {
    id: number;
    name: string;
    price: number;
    quantity: number;
  }
  
  export interface Invoice {
    id: number;
    montant: number;
    status: string;
    dateEmission: Date;
    dateEcheance: Date;
  }
  
  export interface Budget {
    id: number;
    total: number;
    used: number;
  }
  
  export interface Payment {
    id: number;
    amount: number;
    date: Date;
  }
  
  export interface Commande {
    id: number;
    project: Project;
    supplier: Supplier;
    products: Product[];
    status: CommandeStatus;
    totalAmount: number;
    invoices: Invoice[];
    budget: Budget;
    payments: Payment[];
    orderDate: Date;
    deliveryDate: Date;
  }
  