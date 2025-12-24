package com.ToList.management.Repository;

import com.ToList.management.Enum.TaskStatus;
import com.ToList.management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

}
