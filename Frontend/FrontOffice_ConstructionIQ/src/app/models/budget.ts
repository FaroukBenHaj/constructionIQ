export class Budget {
    id: number;
    projetId: number;
    montantTotal: number;
    montantRestant: number;
    dateCreation: string;
  
    constructor(id: number = 0, projetId: number = 0, montantTotal: number = 0, montantRestant: number = 0, dateCreation: string = '') {
      this.id = id;
      this.projetId = projetId;
      this.montantTotal = montantTotal;
      this.montantRestant = montantRestant;
      this.dateCreation = dateCreation;
    }
  }
  