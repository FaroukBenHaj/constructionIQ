export class Commande {
  id: number;
  projetId: number;  // L'ID du projet auquel cette commande est liée
  userId: number;  // L'ID de l'utilisateur qui a passé cette commande
  status: CommandeStatus;
  totalAmount: number;
  //invoices: Invoice[]; // Liste des factures associées à cette commande
  //payments: Payment[]; // Liste des paiements associés à cette commande
  orderDate: string;  // Date de la commande
  deliveryDate: string;  // Date de livraison estimée

  constructor(id: number = 0, projetId: number = 0, userId: number = 0, status: CommandeStatus = CommandeStatus.EN_ATTENTE, totalAmount: number = 0,  orderDate: string = '', deliveryDate: string = '') {
    this.id = id;
    this.projetId = projetId;
    this.userId = userId;
    this.status = status;
    this.totalAmount = totalAmount;
    //this.invoices = invoices;
    //this.payments = payments;
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
