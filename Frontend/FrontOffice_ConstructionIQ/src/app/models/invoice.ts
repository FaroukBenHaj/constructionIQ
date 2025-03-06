export class Invoice {
    id: number;
    commandeId: number;  // L'ID de la commande associée
    projectId: string;
    userId: string;
    montant: number;
    status: InvoiceStatus;
    dateEmission: string;  // Date d'émission de la facture
    dateEcheance: string;  // Date d'échéance de la facture
    //payments: Payment[];  // Liste des paiements associés à cette facture
  
    constructor(id: number = 0, commandeId: number = 0, projectId: string = '', userId: string = '', montant: number = 0, status: InvoiceStatus = InvoiceStatus.EN_ATTENTE, dateEmission: string = '', dateEcheance: string = '') {
      this.id = id;
      this.commandeId = commandeId;
      this.projectId = projectId;
      this.userId = userId;
      this.montant = montant;
      this.status = status;
      this.dateEmission = dateEmission;
      this.dateEcheance = dateEcheance;
      //this.payments = payments;
    }
  }
  
  export enum InvoiceStatus {
    EN_ATTENTE = 'EN_ATTENTE',
    PAYEE = 'PAYEE',
    REJETEE = 'REJETEE'
  }
  