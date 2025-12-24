package com.ToList.management.Service.impl;

import com.ToList.management.DTO.*;
import com.ToList.management.Enum.TaskStatus;
import com.ToList.management.Repository.TaskRepository;
import com.ToList.management.Service.TaskService;
import com.ToList.management.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public TaskResponseDTO create(TaskCreateDTO dto) {

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescrition(dto.getDescription());
        task.setCreateAt(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);
        Task savaTask = repository.save(task);

        return toResponseDTO(task);
    }

    @Override
    public TaskResponseDTO update(Long id, TaskUpdateDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        task.setTitle(dto.getTitle());
        task.setDescrition(dto.getDescription());
        task.setStatus(dto.getStatus());

        Task taskUpdated = repository.save(task);

        return toResponseDTO(taskUpdated);
    }

    @Override
    public TaskResponseDTO completeTask(Long id, TaskStatusUpdateDTO dto) {
        Task task = repository.findById(id).orElseThrow(NoSuchElementException::new);
        task.setStatus(dto.getStatus());

        Task taskUpdated = repository.save(task);

        return toResponseDTO(taskUpdated);
    }

    @Override
    public TaskResponseDTO findById(Long id) {
        Task taskSeach = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return toResponseDTO(taskSeach);
    }

    @Override
    public List<TaskListDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toListDTO)
                .toList();
    }
    @Override
    public List<TaskListDTO> listTaskCompleted() {
        return repository.findByStatus(TaskStatus.COMPLETED)
                .stream()
                .map(this::toListDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TaskResponseDTO toResponseDTO(Task task){
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescrition());
        dto.setStatus(task.getStatus());
        dto.setCreatedAt(task.getCreateAt());
        dto.setCompletedAt(task.getCompleteAt());

        return dto;
    }

    private TaskListDTO toListDTO(Task task) {

        TaskListDTO dto = new TaskListDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setStatus(task.getStatus());

        return dto;
    }



}
