package com.ToList.management.Service;

import com.ToList.management.DTO.*;

import java.util.List;

public interface TaskService {
    TaskResponseDTO create(TaskCreateDTO dto);
    TaskResponseDTO update(Long id, TaskUpdateDTO dto);
    TaskResponseDTO completeTask(Long id, TaskStatusUpdateDTO dto);
    TaskResponseDTO findById(Long id);
    List<TaskListDTO> findAll();
    void delete(Long id);
    List<TaskListDTO> listTaskCompleted();
}
