export interface Task {
    id: number;
    name: string;
    description: string;
    startDate: Date;
    endDate: Date;
    status: string;
    duration: number;
    priority: string;
    projectName: string;
  }