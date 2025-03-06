export class Payment {
  id: number;
  commandeId: number;  // L'ID de la commande associée
  invoiceId: number;   // L'ID de la facture associée
  montantPaye: number;  // Montant payé
  datePaiement: string;  // Date du paiement
  modePaiement: PaymentMode;

  constructor(id: number = 0, commandeId: number = 0, invoiceId: number = 0, montantPaye: number = 0, datePaiement: string = '', modePaiement: PaymentMode = PaymentMode.VIREMENT) {
    this.id = id;
    this.commandeId = commandeId;
    this.invoiceId = invoiceId;
    this.montantPaye = montantPaye;
    this.datePaiement = datePaiement;
    this.modePaiement = modePaiement;
  }
}

export enum PaymentMode {
  VIREMENT = 'VIREMENT',
  CHEQUE = 'CHEQUE',
  CARTE_BANCAIRE = 'CARTE_BANCAIRE'
}
