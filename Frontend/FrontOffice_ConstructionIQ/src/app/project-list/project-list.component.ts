import { Component, OnInit } from '@angular/core';
import { Project } from '../models/project.model';
import { ProjectService } from '../Services/project.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects: Project[] = [];
  displayedColumns: string[] = ['name', 'description', 'startDate', 'endDate', 'budget', 'actions'];
  searchQuery: string = '';
  filteredProjects: Project[] = [];

  constructor(private projectService: ProjectService, private router: Router) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.getProjects().subscribe(
      (response: Project[]) => {
        console.log('Projects from backend:', response); 
        this.projects = response; 
      },
      (error) => {
        console.error('Error loading projects', error);
      }
    );
  }
  onSearch() {
    if (this.searchQuery) {
      this.filteredProjects = this.projects.filter(project =>
        project.name.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    } else {
      this.filteredProjects = this.projects; 
    }
  }

  onProjectSelected(event: any) {
    const selectedProjectName = event.option.value;
    const selectedProject = this.projects.find(project => project.name === selectedProjectName);
    if (selectedProject) {
      this.router.navigate(['/edit-project', selectedProject.id]); 
    }
  }

  navigateToUploadProject() {
    this.router.navigate(['/upload-project']);
  }

  deleteProject(id: number) {
    if (confirm('Are you sure you want to delete this project?')) {
      this.projectService.deleteProject(id).subscribe(
        () => {
          this.loadProjects();
        },
        (error) => {
          console.error('Error deleting project', error);
        }
      );
    }
  }
  goToHome() {
    this.router.navigate(['/home']).then(() => {
      window.location.reload(); 
    });
  }
}