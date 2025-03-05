export class Stock {
    stockID: number;
    projetID: number;
    materialID: number;
    availableQuantity: number;
    dateReceived: string;
  
    constructor(stockID: number, projetID: number, materialID: number, availableQuantity: number, dateReceived: string) {
      this.stockID = stockID;
      this.projetID = projetID;
      this.materialID = materialID;
      this.availableQuantity = availableQuantity;
      this.dateReceived = dateReceived;
    }
  }
  