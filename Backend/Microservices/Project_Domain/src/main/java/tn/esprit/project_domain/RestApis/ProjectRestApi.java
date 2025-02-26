package tn.esprit.project_domain.RestApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.project_domain.Entities.Project;
import tn.esprit.project_domain.Services.ProjectService;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController

public class ProjectRestApi {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/upload-pdf")
    public ResponseEntity<?> uploadProjectPdf(@RequestParam("file") MultipartFile file) {
        try {
            Project savedProject = projectService.uploadProjectPdf(file);
            return ResponseEntity.ok(savedProject);
        } catch (IOException | ParseException e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Error processing PDF\n.\"}");
        }
    }

    @GetMapping("/list_projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        try {
            Project updatedProject = projectService.updateProject(id, projectDetails);
            return ResponseEntity.ok(updatedProject);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Error updating project\n.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        try {
            projectService.deleteProject(id);
            return ResponseEntity.ok().body("{\"message\": \"Project deleted successfully !\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Error deleting project\n.\"}");
        }
    }
}



