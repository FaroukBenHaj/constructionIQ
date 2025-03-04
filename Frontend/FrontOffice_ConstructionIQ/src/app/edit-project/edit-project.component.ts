import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectService } from '../Services/project.service';
import { Project } from '../models/project.model';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  editForm: FormGroup;
  projectId!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    public router: Router,
    private projectService: ProjectService
  ) {
    this.editForm = this.fb.group({
      name: ['', [Validators.required, Validators.pattern("^[a-zA-ZÀ-ÿ\\s]+$")]],
      description: ['', [
        Validators.required,
        Validators.pattern("^[a-zA-Z0-9À-ÿ\\s*+\\-\\/&']+$")
      ]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      budget: ['', [Validators.required, Validators.pattern("^[0-9]+$"), Validators.min(1)]]
    });
  }

  ngOnInit(): void {
    this.projectId = +this.route.snapshot.paramMap.get('id')!;
    this.loadProject();
  }

  loadProject() {
    this.projectService.getProjectById(this.projectId).subscribe(
      (project: Project) => {
        this.editForm.patchValue(project);
      },
      (error: any) => {
        console.error('Error loading project', error);
      }
    );
  }

  onSubmit() {
    if (this.editForm.valid) {
      const updatedProject = this.editForm.value;
      this.projectService.updateProject(this.projectId, updatedProject).subscribe(
        () => {
          this.router.navigate(['/project-list']);
        },
        (error: any) => {
          console.error('Error updating project', error);
        }
      );
    }
  }
}