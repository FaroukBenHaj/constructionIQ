import { Component, OnInit } from '@angular/core';
import { Inspection } from 'src/models/inspection.model';
import { Incident, IncidentStatus } from 'src/models/incident.model';
import { ComplianceChecklist, ChecklistStatus } from 'src/models/compliance-checklist.model';
import { InspectionService } from 'src/app/services/inspection.service';
import { IncidentService } from 'src/app/services/incident.service';
import { ComplianceChecklistService } from 'src/app/services/compliance-checklist.service';

@Component({
  selector: 'app-safety-dashboard',
  templateUrl: './safety-dashboard.component.html',
  styleUrls: ['./safety-dashboard.component.css']
})
export class SafetyDashboardComponent implements OnInit {

  inspections: Inspection[] = [];
  incidents: Incident[] = [];
  complianceChecklists: ComplianceChecklist[] = [];

  // Aggregated data for Compliance Checklists
  totalChecklists: number = 0;
  metCount: number = 0;
  notMetCount: number = 0;
  metPercentage: number = 0;
  notMetPercentage: number = 0;

  // Aggregated data for Incident Statistics
  openIncidents: number = 0;
  investigatingIncidents: number = 0;
  closedIncidents: number = 0;

  constructor(
    private inspectionService: InspectionService,
    private incidentService: IncidentService,
    private complianceChecklistService: ComplianceChecklistService
  ) { }

  ngOnInit(): void {
    this.loadInspections();
    this.loadIncidents();
    this.loadComplianceChecklists();
  }

  loadInspections(): void {
    this.inspectionService.getAllInspections().subscribe(
      (data: Inspection[]) => {
        this.inspections = data;
      },
      error => {
        console.error('Error loading inspections', error);
      }
    );
  }

  loadIncidents(): void {
    this.incidentService.getAllIncidents().subscribe(
      (data: Incident[]) => {
        this.incidents = data;
        this.aggregateIncidentStats();
      },
      error => {
        console.error('Error loading incidents', error);
      }
    );
  }

  loadComplianceChecklists(): void {
    this.complianceChecklistService.getAllComplianceChecklists().subscribe(
      (data: ComplianceChecklist[]) => {
        this.complianceChecklists = data;
        this.aggregateComplianceStats();
      },
      error => {
        console.error('Error loading compliance checklists', error);
      }
    );
  }

  aggregateComplianceStats(): void {
    this.totalChecklists = this.complianceChecklists.length;
    this.metCount = this.complianceChecklists.filter(cl => cl.status === ChecklistStatus.MET).length;
    this.notMetCount = this.complianceChecklists.filter(cl => cl.status === ChecklistStatus.NOT_MET).length;
    if (this.totalChecklists > 0) {
      this.metPercentage = Math.round((this.metCount / this.totalChecklists) * 100);
      this.notMetPercentage = 100 - this.metPercentage;
    } else {
      this.metPercentage = 0;
      this.notMetPercentage = 0;
    }
  }

  aggregateIncidentStats(): void {
    this.openIncidents = this.incidents.filter(i => i.status === IncidentStatus.OPEN).length;
    this.investigatingIncidents = this.incidents.filter(i => i.status === IncidentStatus.INVESTIGATING).length;
    this.closedIncidents = this.incidents.filter(i => i.status === IncidentStatus.CLOSED).length;
  }
}