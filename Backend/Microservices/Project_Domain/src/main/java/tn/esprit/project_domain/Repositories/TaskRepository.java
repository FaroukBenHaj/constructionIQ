package tn.esprit.project_domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.project_domain.Entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
