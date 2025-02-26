package tn.esprit.project_domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.project_domain.Entities.Project;
import tn.esprit.project_domain.Entities.Task;
import tn.esprit.project_domain.Repositories.TaskRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectService projectService;



    public Task createTask(Task task, String projectName) {
        Project project = projectService.findByName(projectName);
        task.setProject(project);
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = getTaskById(id);
        task.setName(taskDetails.getName());
        task.setStartDate(taskDetails.getStartDate());
        task.setEndDate(taskDetails.getEndDate());
        task.setStatus(taskDetails.getStatus());
        task.setDuration(taskDetails.getDuration());
        task.setPriority(taskDetails.getPriority());
        task.setDescription(taskDetails.getDescription());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}



