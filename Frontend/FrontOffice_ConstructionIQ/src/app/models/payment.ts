export enum PaymentMode {
  CASH = 'CASH',
  CREDIT_CARD = 'CREDIT_CARD',
  BANK_TRANSFER = 'BANK_TRANSFER'
}

export interface Payment {
  id: number;
  invoiceId: string;
  montantPaye: number;
  datePaiement: Date;
  modePaiement: PaymentMode;
}
